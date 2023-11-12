package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Horario;
import boutique.com.model.sp.ConsultaHorarioSp;
import boutique.com.repository.ConsultaHorarioSpRepository;
import boutique.com.repository.HorarioRepository;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository horarioRepository;	
	
	@Autowired
	private ConsultaHorarioSpRepository consultaHorarioSpRepository;	
	
	public List<ConsultaHorarioSp> buscarTodoCalculos(){
		return (List<ConsultaHorarioSp>) consultaHorarioSpRepository.listarHorariosPorFecha();
	}

	
	public List<Horario> buscarTodo(){
		return (List<Horario>) horarioRepository.findAll();
	}

	
	public Horario buscarPorId(int id) {
		return horarioRepository.findById(id).get();

	}
	
	public void registrar(Horario hor) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(hor.getHorario_id().equals(0)) {
			hor.setHorario_id(null);
			horarioRepository.save(hor);
		}

		// ACTUALIZAR
		else {
			horarioRepository.save(hor);
		}
	}
	
	public void eliminar(Integer id) {
		
		//Producto p = porductoRepository.findById(id).get();
		//p.setProducto_estado(false);
		//porductoRepository.save(p);

		horarioRepository.deleteById(id);
		
	}
	
	
}
