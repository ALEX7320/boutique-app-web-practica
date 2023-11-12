package boutique.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boutique.com.model.body.ReporteVentasBody;
import boutique.com.model.sp.VentaProductoFechaSp;
import boutique.com.service.ProductoService;
import boutique.com.service.ReportesService;
import boutique.com.utiles.Utiles;


@Controller
@RequestMapping("/reporte")
public class ReporteVentasController {
	
	
	@Autowired
	private ReportesService reportesService;
	
	@Autowired
	private ProductoService productoService;
	
	private Utiles utiles = new Utiles();
	
	@GetMapping("/listar")
	public String listado(Model model) {
	
		model.addAttribute("listado", reportesService.getListado_rep());
		model.addAttribute("producto_list", productoService.buscarTodo());
		model.addAttribute("dia_list", utiles.getDiaActual());

		return "/FolderReporte/listar";
	}

	
	@DeleteMapping("/listarReporteVentasJson")
	@ResponseBody
	public List<VentaProductoFechaSp> listarReporteVentasJson(@RequestBody ReporteVentasBody rep) {
				
		List<VentaProductoFechaSp> reporte = null;
		try {	
			reporte = reportesService.reporteVentasProductoPorId(
					rep.id_reporte,
					utiles.plusDay(rep.fecha_inicio_reporte),
					utiles.plusDay(rep.fecha_fin_reporte)
					);
			reportesService.setListado_rep(reporte);
						
		}catch(Exception e) {
			reporte=null;
			reportesService.clearListado_rep();
		}
				
		return reporte;
	}
	
	/*
	@GetMapping("/limpiarListaJson")
	@ResponseBody
	public ResultadoResponse limpiarListaJson() {
		
		reportesService.clearListado_rep(); // variable reporte
		return new ResultadoResponse(true, "TERMINO");

	}
	*/

	
}
