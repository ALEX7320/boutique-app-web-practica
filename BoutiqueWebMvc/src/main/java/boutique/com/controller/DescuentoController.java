package boutique.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boutique.com.model.bd.Descuento;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.service.DescuentoService;

@Controller
@RequestMapping("/descuento")
public class DescuentoController {
	
	@Autowired
	private DescuentoService descuentoService;
	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", descuentoService.buscarTodo());
		model.addAttribute("list_dsc_tipos", descuentoService.listadoTipos());

		return "FolderDescuento/listar";
	}
	
	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody Descuento des)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(des);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			descuentoService.registrar(des);
			
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
		
	}
	
	
	@GetMapping("/listarDescuentosJson")
	@ResponseBody
	public List<Descuento> listarCategoria() {
		return descuentoService.buscarTodo();
	}	
	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(Descuento obj) {
		
		String mensaje = "";
		
		if(obj.getDescuento_nombre().equals("")) {
			mensaje+="- Nombre de campaña\n";
		}


		return mensaje;
	}
	
	

}
