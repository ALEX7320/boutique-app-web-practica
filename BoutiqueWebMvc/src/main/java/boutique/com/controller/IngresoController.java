package boutique.com.controller;


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

import boutique.com.model.bd.Ingreso;
import boutique.com.model.body.IngresoBody;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.service.IngresoService;
import boutique.com.service.ProductoService;
import boutique.com.utiles.Utiles;

@Controller
@RequestMapping("/ingreso")
public class IngresoController {
	
	@Autowired
	private IngresoService ingresoService;
	
	@Autowired
	private ProductoService productoService;
	
	private Utiles utiles = new Utiles();

	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", ingresoService.buscarTodo());
		
		model.addAttribute("producto_list", productoService.buscarTodo());
		
		model.addAttribute("dia_list", utiles.getDiaActual());

				
		return "FolderProducto/ingreso";
	}
	
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResultadoResponse eliminar(@RequestBody Ingreso ing) {
		
		String mensaje = "Ingreso eliminado correctamente";
		Boolean respuesta = true;
		
		try {

			ingresoService.eliminar(ing.getIngreso_id());
		}
		catch(Exception ex){
			
			mensaje = "Ingreso no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	

	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody IngresoBody ing)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(ing);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			Ingreso i = new Ingreso();		
			i.setIngreso_id(ing.ingreso_id);
			i.setIngreso_cantidad(ing.ingreso_cantidad);
			i.setIngreso_descripcion(ing.ingreso_descripcion);
			i.setIngreso_fecha(utiles.plusDay(ing.ingreso_fecha));
			i.setIngreso_proveedor(ing.ingreso_proveedor);
			i.setProducto_id(productoService.buscarPorId(ing.producto_id));
						
			ingresoService.registrar(i);
			
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
		
	}

	@GetMapping("/listarIngresosJson")
	@ResponseBody
	public List<Ingreso> listarIngresosJson() {
		return ingresoService.buscarTodo();
	}	
	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(IngresoBody obj) {
		
		String mensaje = "";
		
		if(obj.ingreso_cantidad<=0) {
			mensaje+="- Cantidad\n";
		}
		if(obj.ingreso_proveedor.equals("")) {
			mensaje+="- Proveedor\n";	
		}
		if(obj.ingreso_descripcion.equals("")) {
			mensaje+="- Descripcion\n";	
		}
		if(obj.ingreso_fecha==null) {
			mensaje+="- Fecha\n";	
		}
		if(obj.producto_id==-1) {
			mensaje+="- Producto\n";	
		}

		return mensaje;
	}
	

	
	
}

