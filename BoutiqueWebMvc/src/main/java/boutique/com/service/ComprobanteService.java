package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Comprobante;
import boutique.com.repository.ComprobanteRepository;

@Service
public class ComprobanteService {

	@Autowired
	private ComprobanteRepository comprobanteRepository;	
	
	
	public List<Comprobante> buscarTodo(){
		return (List<Comprobante>) comprobanteRepository.findAll();
	}
		
	public Comprobante buscarPorId(int id) {
		return comprobanteRepository.findById(id).get();

	}

	
}
