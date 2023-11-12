package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Tipopago;
import boutique.com.repository.TipopagoRepository;

@Service
public class TipopagoService {
	
	@Autowired
	private TipopagoRepository tipopagoRepository;	
	
	
	public List<Tipopago> buscarTodo(){
		// BUSCAR SOLO INGRESO DE PRODUCTOS ACTIVOS
		return (List<Tipopago>) tipopagoRepository.findAll();
		
		//return (List<Ingreso>) ingresoRepository.findAll();
	}
		
	public Tipopago buscarPorId(int id) {
		return tipopagoRepository.findById(id).get();

	}

}
