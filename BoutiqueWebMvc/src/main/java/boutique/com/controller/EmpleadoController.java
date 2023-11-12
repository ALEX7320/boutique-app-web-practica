package boutique.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boutique.com.model.bd.Rol;
import boutique.com.model.bd.User;
import boutique.com.service.RolService;
import boutique.com.service.UserService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RolService rolService;
	
	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", userService.buscarPorEstado(true));
				
		model.addAttribute("buscar", new User());
				
		return "FolderEmpleado/listar";
	}
	
	// LISTADO X DNI
	@GetMapping("listar/dni")
	public String buscar(@ModelAttribute("buscar") User user, Model model) {
		System.out.print("bucasr porg:" + user.getDni());

		String	dni = user.getDni().trim();
		
		if(dni.equals("")) {
			model.addAttribute("listado", userService.buscarPorEstado(true));
		
		}
		else {
			List<User> lista = userService.buscarPorEstadoAndDni(true,dni);
			
			if(lista.size()>0) model.addAttribute("listado", lista);
			else model.addAttribute("alerta_busqueda", "Empleado no encontrado con el DNI ingresado");	

		}

		return "FolderEmpleado/listar";
	}
	
		
	// REGISTRAR - FORM
	@GetMapping("/registrar")
	public String registrar (Model model, RedirectAttributes attributes) {
		
		model.addAttribute("user", new User());
		
		model.addAttribute("lista_rol", rolService.buscarTodo());

		return "FolderEmpleado/registrar";
	}
	
	
	// GUARDAR POST - FUNCION
	@PostMapping("/save")
	public String registrarPost(@ModelAttribute("user") User usuario, RedirectAttributes attributes,
							@RequestParam("seleccion_rol") String rol) {
		
		String cadena_validacion = validacionFormulario(usuario,"POST");
		if(!cadena_validacion.equals("")) {
			
			attributes.addFlashAttribute("msg", cadena_validacion);
			return "redirect:/empleado/registrar/";
			
		}
		
		
		userService.saveUser(usuario,rol);
		
		attributes.addFlashAttribute("msg", "¡Empleado registrado correctamente!");


		return "redirect:/empleado/listar";
		
	}
	
	
	// ELIMINAR	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(name="id") int id) {
		
		User user = userService.findUserById(id);
		user.setActive(false);
		
		userService.guardadoSimple(user);
		
		return "redirect:/empleado/listar";
	}
	
	// ACTUALIZAR
	@GetMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(name="id") int id, Model model) {
		
		User usuario = userService.findUserById(id);
		
		String rol_sel = "";
		for(Rol rol : usuario.getRoles()) {
			rol_sel = rol.getRolname();
			break;
		}	
		
		System.out.print(usuario.getPassword()+"");
	
		model.addAttribute("user", usuario);
		model.addAttribute("lista_rol", rol_sel);

		return "FolderEmpleado/editar";
	}
	
	// GUARDAR POST - FUNCION
	@PostMapping("/update")
	public String actualizarPost(@ModelAttribute("user") User usuario, RedirectAttributes attributes,
							@RequestParam("seleccion_rol") String rol) {
		
		
		String cadena_validacion = validacionFormulario(usuario,"PUT");
		if(!cadena_validacion.equals("")) {
			
			attributes.addFlashAttribute("msg", cadena_validacion);
			return "redirect:/empleado/actualizar/"+usuario.getUserid();
			
		}
		
		attributes.addFlashAttribute("msg", "¡Empleado editado correctamente!");

		userService.guardadoSimple(usuario);

		return "redirect:/empleado/listar";

	}
	
	//
	
	public String validacionFormulario(User us, String tipo) {
		
		String validacion = "";
		
		if(tipo.equals("POST")) {
	
			String usna = us.getUsername().trim();
			if(usna.equals("")) {validacion+="| *Usuario ";}
			else {
				User existeUser= userService.findUserByUserName(us.getUsername());
				if(existeUser != null) {validacion+="| *Usuario '"+usna+"' ya existe ";}
			}
			
			String dni = us.getDni().trim();
			if(dni.equals("")) {validacion+="| *DNI.";}
			else {
				User existeDni= userService.findUserByDni(us.getDni());
				if(existeDni != null) {validacion+="| *DNI '"+dni+"' ya existe ";}
			}
			
			
		}


		if(us.getName().trim().equals("")) validacion+="| *Nombre ";
		if(us.getLastname().trim().equals("")) validacion+="| *Apellido ";
		if(us.getEmail().trim().equals("")) validacion+="| *Email ";
		if(us.getPassword().trim().equals("")) validacion+="| *Contraseña ";
		if(us.getMovil().trim().equals("")) validacion+="| *Celular ";
		
		if(!validacion.equals("")) {
			validacion = "Por favor, es necesario registrar los datos obligatorios: "+validacion+".";
		}
		
		return validacion;
	}

		
		
	
	
}