package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Ingreso;
import boutique.com.repository.IngresoRepository;

@Service
public class IngresoService {

	
	@Autowired
	private IngresoRepository ingresoRepository;	
	
	
	public List<Ingreso> buscarTodo(){
		// BUSCAR SOLO INGRESO DE PRODUCTOS ACTIVOS
		return (List<Ingreso>) ingresoRepository.findAllByProductoActivo(true);
	}
	
	public List<Ingreso> buscarPorProductosId(Integer id){
		return (List<Ingreso>) ingresoRepository.findAllByProductoId(id);
	}
	
		
	public Ingreso buscarPorId(int id) {
		return ingresoRepository.findById(id).get();

	}
	
	
	public void registrar(Ingreso ing) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(ing.getIngreso_id().equals(0)) {
			ing.setIngreso_id(null);
			ingresoRepository.save(ing);
		}

		// ACTUALIZAR
		else {
			ingresoRepository.save(ing);
		}
	}
	
	
	public void eliminar(Integer id) {
		
		//Producto p = porductoRepository.findById(id).get();
		//p.setProducto_estado(false);
		//porductoRepository.save(p);

		ingresoRepository.deleteById(id);
		
	}
	
	
	
}
