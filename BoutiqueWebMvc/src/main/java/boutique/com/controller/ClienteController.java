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

import boutique.com.model.bd.Cliente;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
				
		model.addAttribute("listado", clienteService.buscarTodo());
						
		return "FolderCliente/listar";
	}
	
	
	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody Cliente cli)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
						
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(cli);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			clienteService.registrar(cli);

			
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
		
	}
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResultadoResponse eliminar(@RequestBody Cliente cli) {
		
		String mensaje = "Cliente eliminado correctamente";
		Boolean respuesta = true;
		
		try {
			
			clienteService.eliminar(cli.getCliente_id());
		}
		catch(Exception ex){
			
			mensaje = "Cliente no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	
	@GetMapping("/listarClientesJson")
	@ResponseBody
	public List<Cliente> listarCategoria() {
		return clienteService.buscarTodo();
	}	
	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(Cliente cli) {
		
		String mensaje = "";
		
		if(cli.getCliente_nombre().equals("")) {
			mensaje+="- Nombre\n";
		}
		if(cli.getCliente_apellido().equals("")) {
			mensaje+="- Apellido\n";
			
		}		
		if(cli.getCliente_dni().equals("") || cli.getCliente_dni().length()<8) {
			mensaje+="- DNI\n";	
			
		}else if(clienteService.buscarDniExistente(cli.getCliente_dni(), cli.getCliente_id())!=null) {
			mensaje+="- DNI ya esta registrado\n";
		}
		
		if(cli.getCliente_celular().equals("") || cli.getCliente_celular().length()<9) {
			mensaje+="- Celular\n";
		}
	
		return mensaje;
	}
	
	
}



