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

import boutique.com.model.bd.Salida;
import boutique.com.model.body.SalidaBody;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.service.ProductoService;
import boutique.com.service.SalidaService;
import boutique.com.utiles.Utiles;


@Controller
@RequestMapping("/salida")
public class SalidaController {


	@Autowired
	private SalidaService salidaService;
	
	@Autowired
	private ProductoService productoService;
	
	private Utiles utiles = new Utiles();
	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", salidaService.buscarTodo());
		
		model.addAttribute("producto_list", productoService.buscarTodo());
		
		model.addAttribute("dia_list", utiles.getDiaActual());

				
		return "FolderProducto/salida";
	}
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResultadoResponse eliminar(@RequestBody Salida sal) {
		
		String mensaje = "Salida eliminado correctamente";
		Boolean respuesta = true;
		
		try {

			salidaService.eliminar(sal.getSalida_id());
		}
		catch(Exception ex){
			
			mensaje = "Salida no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody SalidaBody sal)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(sal);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			Salida s = new Salida();		
			s.setSalida_id(sal.salida_id);
			s.setSalida_cantidad(sal.salida_cantidad);
			s.setSalida_descripcion(sal.salida_descripcion);
			s.setSalida_fecha(utiles.plusDay(sal.salida_fecha));
			s.setProducto_id(productoService.buscarPorId(sal.producto_id));
						
			salidaService.registrar(s);
			
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
		
	}
	
	
	
	@GetMapping("/listarSalidaJson")
	@ResponseBody
	public List<Salida> listarSalidaJson() {
		return salidaService.buscarTodo();
	}	
	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(SalidaBody obj) {
		
		System.out.println(obj.salida_fecha+"------valors");
		String mensaje = "";
		
		if(obj.salida_cantidad<=0) {
			mensaje+="- Cantidad\n";
		}
		if(obj.salida_descripcion.equals("")) {
			mensaje+="- Descripcion\n";	
		}
		if(obj.salida_fecha==null) {
			mensaje+="- Fecha\n";	
		}
		if(obj.producto_id==-1) {
			mensaje+="- Producto\n";	
		}

		return mensaje;
	}
	

}

