package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Salida;
import boutique.com.repository.SalidaRepository;

@Service
public class SalidaService {
	
	@Autowired
	private SalidaRepository salidaRepository;	
	
	
	public List<Salida> buscarTodo(){
		// BUSCAR SOLO INGRESO DE PRODUCTOS ACTIVOS
		return (List<Salida>) salidaRepository.findAllByProductoActivo(true);
	}
	
	public List<Salida> buscarPorProductosId(Integer id){
		return (List<Salida>) salidaRepository.findAllByProductoId(id);
	}
		
	public Salida buscarPorId(int id) {
		return salidaRepository.findById(id).get();

	}
	
	
	public void registrar(Salida sal) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(sal.getSalida_id().equals(0)) {
			sal.setSalida_id(null);
			salidaRepository.save(sal);
		}

		// ACTUALIZAR
		else {
			salidaRepository.save(sal);
		}
	}
	
	
	public void eliminar(Integer id) {
		
		//Producto p = porductoRepository.findById(id).get();
		//p.setProducto_estado(false);
		//porductoRepository.save(p);

		salidaRepository.deleteById(id);
		
	}

}
