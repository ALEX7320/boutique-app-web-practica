package boutique.com.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boutique.com.model.bd.Detalleventa;
import boutique.com.model.bd.Producto;
import boutique.com.model.bd.Venta;
import boutique.com.model.body.DetalleventaBody;
import boutique.com.model.body.LLaveInt;
import boutique.com.model.body.VentaBody;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.model.sp.StockProductoSp;
import boutique.com.model.sp.StockSp;
import boutique.com.service.ClienteService;
import boutique.com.service.ComprobanteService;
import boutique.com.service.DescuentoService;
import boutique.com.service.DetalleventaService;
import boutique.com.service.ProductoService;
import boutique.com.service.StockSpService;
import boutique.com.service.TipopagoService;
import boutique.com.service.VentaService;
import boutique.com.utiles.Utiles;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	// AGREGADOS
	@Autowired
	private TipopagoService tipopagoService;
	@Autowired
	private ComprobanteService comprobanteService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProductoService productoService;
	@Autowired
	private DescuentoService descuentoService;
	@Autowired
	private DetalleventaService detalleventaService;
	@Autowired
	private StockSpService stockSpService;
	
	
	private Double igv_monto = 0.18; // valor por defecto
	private Utiles utiles = new Utiles();


	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Venta> ven = ventaService.buscarTodoActivos();
		model.addAttribute("listado", ven);
		
		// VENTA
		model.addAttribute("comprobante_list", comprobanteService.buscarTodo());
		model.addAttribute("cliente_list", clienteService.buscarTodo());
		model.addAttribute("tipopago_list", tipopagoService.buscarTodo());
		model.addAttribute("igv_monto", igv_monto);
		
		// DETALLEVENTA
		model.addAttribute("venta_list", ven);
		model.addAttribute("producto_list", productoService.buscarTodo());
		model.addAttribute("descuento_list", descuentoService.buscarTodoDisponibles());
		
		
		model.addAttribute("dia_list", utiles.getDiaActual());

		
		return "FolderVenta/listaVentas";
	}
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminarventa")
	@ResponseBody
	public ResultadoResponse eliminarCategoria(@RequestBody Venta ven) {
		
		String mensaje = "Venta eliminada correctamente";
		Boolean respuesta = true;
		
		try {

			ventaService.eliminar(ven.getVenta_id());
		}
		catch(Exception ex){
			
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
		
	
	// CREAR CATEGORIA
	@PostMapping("/registrarventa")
	@ResponseBody
	public ResultadoResponse registrarventa(@RequestBody VentaBody ven)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistroVenta(ven);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			
			Venta v = new Venta();	
			v.setVenta_id(ven.venta_id);
			v.setVenta_fecha(utiles.plusDay(ven.venta_fecha));
			v.setVenta_descripcion(ven.venta_descripcion);
			v.setVenta_igv(ven.venta_igv);
			v.setVenta_estado(ven.venta_estado);
			v.setTipopago_id(tipopagoService.buscarPorId(ven.tipopago_id));
			v.setCliente_id(clienteService.buscarPorId(ven.cliente_id));
			v.setComprobante_id(comprobanteService.buscarPorId(ven.comprobante_id));
			v.setDetalleventa_list(
					detalleventaService.buscarPorIdVenta(ven.venta_id)
					);
			ventaService.registrar(v);
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminardetalleventa")
	@ResponseBody
	public ResultadoResponse eliminarCategoriwa(@RequestBody Detalleventa det) {
		
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		
		try {

			detalleventaService.eliminar(det.getDetalleventa_id());
		}
		catch(Exception ex){
			
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	// CREAR CATEGORIA
	@PostMapping("/registrardetalleventa")
	@ResponseBody
	public ResultadoResponse registrarDetalleventa(@RequestBody DetalleventaBody det)  {		
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		// VALIDA LA EXISTENCIA DEL STOCK
		
		List<StockSp> lista_stock_dispo = stockSpService.listarStock();
		for(StockSp stock :lista_stock_dispo) {
			if(stock.getStock_id()==det.producto_id) {
				
				if(stock.getStock_total()<=0) {
					mensaje = "Sin stock del producto: "+stock.getStock_nombre();
					respuesta = false;
					return new ResultadoResponse(respuesta, mensaje);
					
				}else if(det.detalleventa_cantidad > stock.getStock_total()){
					mensaje = "Sin stock suficiente, solo contamos con "+stock.getStock_total()+" unidades.";
					respuesta = false;
					return new ResultadoResponse(respuesta, mensaje);
					
				}else {
					break;
				}
				
			}
		}

		
		// CONTINUA CON EL REGISTRO
		
		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistroDetalleventa(det);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			
			Detalleventa d = new Detalleventa();
			
			d.setDetalleventa_id(det.detalleventa_id);
			d.setDetalleventa_cantidad(det.detalleventa_cantidad);
			d.setVenta_id(ventaService.buscarPorId(det.venta_id));
			d.setProducto_id(productoService.buscarPorId(det.producto_id));
			d.setDescuento_id(descuentoService.buscarPorId(det.descuento_id));
			
			detalleventaService.registrar(d);

		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	@GetMapping("/listarProductosJson")
	@ResponseBody
	public List<Producto> listarProductosJson() {
		return productoService.buscarTodo();
	}
		
	// CREAR CATEGORIA
	@PostMapping("/listarProductosPorIdVentaJson")
	@ResponseBody
	public List<Integer> listarProductosPorIdVentaJson(@RequestBody DetalleventaBody det)  {
		
		List<Integer> lista_id = new LinkedList<Integer>();
		
		for(Detalleventa dt_ls : detalleventaService.buscarPorIdVenta(det.venta_id)) {
			
			Integer num = dt_ls.getProducto_id().getProducto_id();
			lista_id.add(num);
		}
				
		return lista_id;
	}
	
	
	@DeleteMapping("/consultaStockJson_All")
	@ResponseBody
	public List<StockProductoSp> listarSalidasJson_All(@RequestBody LLaveInt prod) {
		List<StockProductoSp> lista = stockSpService.stockPorIdProducto(prod.llave_id);
		return lista;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	// VALIDACIONES /////////////////////////////////////////////////////////////////
	// //////////////////////////////////////////////////////////////////////////////
	
	

	// VALIDACION REGISTRO
	public String validacionRegistroVenta(VentaBody obj) {
		
		String mensaje = "";
		
		if(obj.cliente_id==-1) {
			mensaje+="- Cliente\n";
		}
		if(obj.venta_fecha==null) {
			mensaje+="- Fecha\n";	
		}
		if(obj.tipopago_id==-1) {
			mensaje+="- Tipo de pago\n";
		}
		if(obj.comprobante_id==-1) {
			mensaje+="- Comprobante de pago\n";
		}

		return mensaje;
	}
	

	// VALIDACION REGISTRO
	public String validacionRegistroDetalleventa(DetalleventaBody obj) {
		
		String mensaje = "";
		
		if(obj.producto_id==-1) {
			mensaje+="- Producto\n";
		}


		return mensaje;
	}
	
}


