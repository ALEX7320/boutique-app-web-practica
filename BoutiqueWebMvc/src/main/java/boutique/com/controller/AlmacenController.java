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

import boutique.com.model.bd.Ingreso;
import boutique.com.model.bd.Salida;
import boutique.com.model.body.LLaveInt;
import boutique.com.model.sp.StockSp;
import boutique.com.service.IngresoService;
import boutique.com.service.ProductoService;
import boutique.com.service.SalidaService;
import boutique.com.service.StockSpService;
import boutique.com.utiles.Utiles;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {
	
	
	@Autowired
	private StockSpService stockSpService;
	
	@Autowired
	private ProductoService productoService;
	@Autowired
	private IngresoService ingresoService;
	@Autowired
	private SalidaService salidaService;
	
	private Utiles utiles = new Utiles();
	
		
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", stockSpService.listarStock());
		model.addAttribute("producto_list", productoService.buscarSinExcepcion());
		
		model.addAttribute("dia_list", utiles.getDiaActual());


		return "FolderAlmacen/listar";
	}
	
	
	@DeleteMapping("/listarIngresosJsonAll")
	@ResponseBody
	public List<Ingreso> listarIngresosJson_All(@RequestBody LLaveInt prod) {
		List<Ingreso> lista = ingresoService.buscarPorProductosId(prod.llave_id);
		return lista;
	}	
	
	@DeleteMapping("/listarSalidasJson_All")
	@ResponseBody
	public List<Salida> listarSalidasJson_All(@RequestBody LLaveInt prod) {
		List<Salida> lista = salidaService.buscarPorProductosId(prod.llave_id);
		return lista;
	}
	
	@GetMapping("/listarStockJson")
	@ResponseBody
	public List<StockSp> listarStockJson() {
		return stockSpService.listarStock();
	}	

	
	
}
