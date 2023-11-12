package boutique.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import boutique.com.model.bd.Rol;
import boutique.com.model.bd.User;
import boutique.com.model.body.GenerateKey;
import boutique.com.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/error_acceso")
	public String error_accesoFuncion(Model model) {
		return "error_ingreso";
	}	
	
	@GetMapping("/error_404")
	public String error_404Funcion(Model model) {
		return "404_html";
	}
	

	@GetMapping("/admin/home")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();		
		 
		User user = userService.findUserByUserName(auth.getName());
		
		String rol_in = "";
		for(Rol r: user.getRoles()) {
			rol_in=r.getRolname();
			break;
		}
		

		
		model.addAttribute("username", user.getName()+" "+user.getLastname());
		model.addAttribute("userrol", rol_in);		
		
		
		return "admin/home";
	}
	
	

	
	@GetMapping("/admin/config")
	public String contrasena(Model model) {
		model.addAttribute("generador_key", new GenerateKey());
		model.addAttribute("cifrado_key", "");

		return "admin/contrasena";
	}
	
	@PostMapping("/admin/config")
	public String guardar(@ModelAttribute("generador_key") GenerateKey llave, Model model) {
		
		String contasena = llave.getKey_texto().trim();
		String encoded = "";
		if(contasena!="") {
		    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    encoded = encoder.encode(contasena);
		}
		
		llave.setKey_texto(llave.getKey_texto().trim());
		
		model.addAttribute("generador_key", llave);  
		model.addAttribute("cifrado_key", encoded);

		return "admin/contrasena";
	}
	

	
	
	
	
	
	
	
	
	
	
}
