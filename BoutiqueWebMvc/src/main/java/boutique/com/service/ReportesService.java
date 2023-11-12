package boutique.com.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.body.BodyReporteProd;
import boutique.com.model.sp.VentaProductoFechaSp;
import boutique.com.repository.VentaProductoFechaSpRepository;

@Service
public class ReportesService {
	
	@Autowired
	private VentaProductoFechaSpRepository ventaProductosRepository;
	
	private BodyReporteProd producto = new BodyReporteProd("","","","","");
	
	private List<VentaProductoFechaSp> listado_rep = new LinkedList<VentaProductoFechaSp>();
		
	public void setProductoRep(List<VentaProductoFechaSp> listado_rep) {
		
		for(VentaProductoFechaSp re: listado_rep) {
			this.producto.setRe_producto(re.getProducto_nombre());
			this.producto.setRe_marca(re.getMarca_nombre());
			this.producto.setRe_tipo(re.getTipoproducto_nombre());
			this.producto.setRe_ffinal(re.getVar_fecha_fin());
			this.producto.setRe_finicio(re.getVar_fecha_inicio());
			break;
		}
	}
	
	public BodyReporteProd getProductoRep() {
		return this.producto;
	}
	
	public void setListado_rep(List<VentaProductoFechaSp> listado_rep) {
		
		setProductoRep(listado_rep);
		this.listado_rep=listado_rep;
	}
	
	public void clearListado_rep() {
		this.producto.resetearValores();
		this.listado_rep=new LinkedList<VentaProductoFechaSp>();
	}
	
	public List<VentaProductoFechaSp> getListado_rep() {
		return this.listado_rep;
	}
	
	public List<VentaProductoFechaSp> reporteVentasProductoPorId(Integer id, Date inicio, Date fin){
		return ventaProductosRepository.reporteVentasProductoPorId(id,inicio,fin);
	}

}

