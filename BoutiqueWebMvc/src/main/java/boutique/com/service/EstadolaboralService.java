package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Estadolaboral;
import boutique.com.repository.EstadolaboralRepository;

@Service
public class EstadolaboralService {
	
	@Autowired
	private EstadolaboralRepository estadolaboralRepository;	
	
	public List<Estadolaboral> buscarTodo(){
		return (List<Estadolaboral>) estadolaboralRepository.findAll();
	}

	
	public Estadolaboral buscarPorId(int id) {
		return estadolaboralRepository.findById(id).get();

	}

}
