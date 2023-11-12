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

import boutique.com.model.bd.Horario;
import boutique.com.model.body.HorarioBody;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.model.sp.ConsultaHorarioSp;
import boutique.com.service.EstadolaboralService;
import boutique.com.service.HorarioService;
import boutique.com.service.UserService;
import boutique.com.utiles.Utiles;

@Controller
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private HorarioService horarioService;	
	
	@Autowired
	private EstadolaboralService estadolaboralService;	
	
	@Autowired
	private UserService userService;	
	
	private Utiles utiles = new Utiles();

			
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", horarioService.buscarTodoCalculos());
		model.addAttribute("empleado_list", userService.buscarPorEstado(true));
		model.addAttribute("estado_list", estadolaboralService.buscarTodo());

		return "FolderHorario/listar";
	}
	
	
	
	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody HorarioBody hor)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {

			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(hor);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			Horario h = new Horario();	
			
			h.setHorario_id(hor.horario_id);
			h.setHorario_fecha(utiles.plusDay(hor.horario_fecha));
			h.setHorario_hora_inicio(hor.horario_hora_inicio);
			h.setHorario_hora_fin(hor.horario_hora_fin);
			h.setHorario_detalle(hor.horario_detalle);
			h.setUserid(userService.findUserById(hor.userid));
			h.setEstadolaboral_id(estadolaboralService.buscarPorId(hor.estadolaboral_id));

			horarioService.registrar(h);
			
			
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
	public ResultadoResponse eliminar(@RequestBody Horario hor) {
		
		String mensaje = "Horario eliminado correctamente";
		Boolean respuesta = true;
		
		try {
			horarioService.eliminar(hor.getHorario_id());
		}
		catch(Exception ex){
			mensaje = "Horario no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	
	@GetMapping("/listarHorariosJson")
	@ResponseBody
	public List<ConsultaHorarioSp> listarSalidaJson() {
		return horarioService.buscarTodoCalculos();
	}	
	
	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(HorarioBody obj) {
		
		String mensaje = "";
		
		if(obj.userid==-1) {
			mensaje+="- Empleado\n";
		}
		if(obj.horario_fecha==null) {
			mensaje+="- Fecha\n";
		}
		if(obj.horario_hora_inicio=="") {
			mensaje+="- Hora ingreso\n";
		}
		if(obj.horario_hora_fin=="") {
			mensaje+="- Hora salida\n";
		}
		if(obj.estadolaboral_id==-1) {
			mensaje+="- Tipo\n";
		}


		return mensaje;
	}
	
	
	

}
