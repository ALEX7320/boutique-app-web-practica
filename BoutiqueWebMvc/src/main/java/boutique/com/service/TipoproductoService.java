package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Tipoproducto;
import boutique.com.repository.TipoproductoRepository;

@Service
public class TipoproductoService {
	
	@Autowired
	private TipoproductoRepository tipoproductoRepository;	
	
	
	public List<Tipoproducto> buscarTodo(){
		return (List<Tipoproducto>) tipoproductoRepository.findAll();
	}
		
	public Tipoproducto buscarPorId(int id) {
		return tipoproductoRepository.findById(id).get();

	}

}
