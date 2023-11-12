package boutique.com.utiles;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import boutique.com.model.body.BodyReporteProd;
import boutique.com.model.sp.VentaProductoFechaSp;
import boutique.com.service.ReportesService;

import com.lowagie.text.Phrase;



@Component("/FolderReporte/listar")
public class ReportePdfVentas extends AbstractPdfView{

	@Autowired
	private ReportesService reportesService;
	
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
      
		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(-20, -20, 20, 20);
		document.open();
			
		List<VentaProductoFechaSp> listadoReportes = (List<VentaProductoFechaSp>) reportesService.getListado_rep();
		BodyReporteProd prod = reportesService.getProductoRep();
		
		
		Font fontTitulo=FontFactory.getFont("Bookman Old Style",12,Color.WHITE);
		Font fontTitulo2=FontFactory.getFont("Bookman Old Style",15,Color.BLACK);

		PdfPTable tableTituto = new PdfPTable(1);
		
		PdfPCell ctitulo = new PdfPCell(new Phrase("VANYLUCK: Reporte Ventas de Producto",fontTitulo));
		ctitulo.setBorder(0);
		ctitulo.setBackgroundColor(new Color(147, 117, 150));
		ctitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		ctitulo.setPadding(10);
		tableTituto.addCell(ctitulo);//1S	
		
		ctitulo = new PdfPCell(new Phrase(prod.getRe_producto(),fontTitulo2));
		ctitulo.setBorder(0);
		ctitulo.setBackgroundColor(new Color(216, 202, 218));
		ctitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		ctitulo.setPaddingTop(20);
		tableTituto.addCell(ctitulo);//1S	
		
		ctitulo = new PdfPCell(new Phrase(prod.getRe_marca()+" - "+prod.getRe_tipo(),fontTitulo2));
		ctitulo.setBorder(0);
		ctitulo.setBackgroundColor(new Color(216, 202, 218));
		ctitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		ctitulo.setPaddingBottom(20);
		tableTituto.addCell(ctitulo);//1S
		
		ctitulo = new PdfPCell(new Phrase("Fecha desde "+prod.getRe_finicio()+" hasta "+prod.getRe_ffinal(),fontTitulo));
		ctitulo.setBorder(0);
		ctitulo.setBackgroundColor(new Color(147, 117, 150));
		ctitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		ctitulo.setPadding(10);
		tableTituto.addCell(ctitulo);//1S
		
		tableTituto.setSpacingAfter(30);		
		tableTituto.setWidthPercentage(50);

		
		
        float[] widths = {0.05f,0.25f,0.10f,0.10f,0.15f,0.15f,0.10f,0.10f};
		PdfPTable tableContenido = new PdfPTable(widths);		
		tableContenido.setWidthPercentage(85);

		PdfPCell ccont = null;
		setCellTHeader("ID",tableContenido,ccont);
		setCellTHeader("COMPRADOR",tableContenido,ccont);
		setCellTHeader("DNI",tableContenido,ccont);
		setCellTHeader("PRECIO",tableContenido,ccont);
		setCellTHeader("PRECIO IGV",tableContenido,ccont);
		setCellTHeader("DESCUENTO",tableContenido,ccont);
		setCellTHeader("CANTIDAD",tableContenido,ccont);
		setCellTHeader("TOTAL",tableContenido,ccont);
	

		Double v_total=0.0;
		int contador = 0;
		Color color =null;
		for(VentaProductoFechaSp rep:listadoReportes){
			
			
			if(contador%2==0) {
				color = new Color(255,255,255);

			}else {
				color = new Color(232,232,232);
			}
			contador+=1;
			
			
			 // ESTABLECE VARIABLES
            Double v_precio = rep.getProducto_precio();
            Integer v_cantidad = rep.getDetalleventa_cantidad();
            Double v_descuento = rep.getDescuento_procentaje();
            Double v_igv = rep.getVenta_igv();


            // CALCULOS
            Double f_descuento = v_descuento / 100;

            Double f_precio = v_precio; // precio sin igv cu
            Double f_precio_con_igv = f_precio + (f_precio * v_igv); // PRECIO CON IGV

            Double f_precio_del_descuento = f_precio_con_igv * f_descuento; // PRECIO DEL DSC CON IGV
            Double f_precio_con_descuento = f_precio_con_igv - f_precio_del_descuento; // PRECIO DEL DSC CON IGV

            Double f_precio_x_cantidad = f_precio_con_descuento * v_cantidad;
            
            
            v_total = f_precio_x_cantidad; //+ v_total
            
            
            String dsct_cadena = "";
            if(v_descuento==0) {
            	dsct_cadena="";
            	
            }else {
            	dsct_cadena=" (-"+Math.round(v_descuento)+"%)";
            }
      
            DecimalFormat df=new DecimalFormat("0.00");
		
            setCellT1(Integer.toString(rep.getReporte_detalleventa_id()),tableContenido,color);//1
            setCellT1(rep.getCliente_nombre()+" "+rep.getCliente_apellido(),tableContenido,color);//2			
			setCellT1(rep.getCliente_dni(),tableContenido,color);
			setCellT1("S/ "+df.format(v_precio),tableContenido,color);//4
			setCellT1("S/ "+df.format(f_precio_con_igv),tableContenido,color);//5
			setCellT1("S/ "+df.format(f_precio_con_descuento)+dsct_cadena,tableContenido,color);//6
			setCellT1(Integer.toString(v_cantidad),tableContenido,color);//7
			setCellT1("S/ "+df.format(v_total),tableContenido,color);//8	
			
		};
		
		

		document.add(tableTituto);
		document.add(tableContenido);
		
		//	private List<VentaProductoFechaSp> listado_rep = new LinkedList<VentaProductoFechaSp>();

		document.close();
	
		
	}
	
	public void setCellT1(String texto, PdfPTable tabla,Color fondoColor) {

		PdfPCell cell = new PdfPCell(new Phrase(texto));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setPaddingBottom(10);
		cell.setPaddingTop(10);
	
		
		if(fondoColor!=null) {
			cell.setBackgroundColor(fondoColor);
		}

		tabla.addCell(cell);//5
	}
	

	public void setCellTHeader(String texto, PdfPTable tabla,PdfPCell celda) {

		
		Font font =FontFactory.getFont("Bookman Old Style",13,Color.WHITE);
		celda = new PdfPCell(new Phrase(texto,font));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPaddingBottom(15);
		celda.setPaddingTop(15);
		
		celda.setBackgroundColor(new Color(147, 117, 150));

		tabla.addCell(celda);//1
		
	}
		
	


	
	
}
