package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Marca;
import boutique.com.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;	
	
	
	public List<Marca> buscarTodo(){
		return (List<Marca>) marcaRepository.findAll();
	}
		
	public Marca buscarPorId(int id) {
		return marcaRepository.findById(id).get();

	}

}
