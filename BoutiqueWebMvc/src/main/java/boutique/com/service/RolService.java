package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Rol;
import boutique.com.repository.RolRepository;


@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	
	public List<Rol> buscarTodo(){
		return (List<Rol>) rolRepository.findAll();
	}
	
	
}
