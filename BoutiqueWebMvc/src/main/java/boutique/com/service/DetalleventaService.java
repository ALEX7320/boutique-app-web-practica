package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Detalleventa;
import boutique.com.repository.DetalleventaRepository;

@Service
public class DetalleventaService {
	
	@Autowired
	private DetalleventaRepository detalleventaRepository;	
	
	
	// DETALLE VENTA X ID VENTA
	public List<Detalleventa> buscarPorIdVenta(Integer id){
		return (List<Detalleventa>) detalleventaRepository.findAllByIdVenta(id);
	}
	
	public List<Detalleventa> buscarTodo(){
		return (List<Detalleventa>) detalleventaRepository.findAll();
	}
		
	public Detalleventa buscarPorId(int id) {
		return detalleventaRepository.findById(id).get();

	}
	
	public void registrar(Detalleventa det) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(det.getDetalleventa_id().equals(0)) {
			det.setDetalleventa_id(null);
			detalleventaRepository.save(det);
		}

		// ACTUALIZAR
		else {
			detalleventaRepository.save(det);
		}
	}
	

	public void eliminar(Integer id) {
		
		//Producto p = porductoRepository.findById(id).get();
		//p.setProducto_estado(false);
		//porductoRepository.save(p);

		detalleventaRepository.deleteById(id);
		
	}
	
	
	


}
