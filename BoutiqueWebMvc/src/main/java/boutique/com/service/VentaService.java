package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Venta;
import boutique.com.repository.VentaRepository;

@Service
public class VentaService {
	
	
	@Autowired
	private VentaRepository ventaRepository;	
	
	
	/*public List<Venta> buscarTodoSep(){
		return (List<Venta>) ventaRepository.findAllVentaNoDetalle();
	}*/
	
	
	public List<Venta> buscarTodo(){
		return (List<Venta>) ventaRepository.findAll();
	}
	
	public List<Venta> buscarTodoActivos(){
		return (List<Venta>) ventaRepository.findAllByVentaActivos(true);
	}
				
	public Venta buscarPorId(int id) {
		return ventaRepository.findById(id).get();

	}
	
	
	public void registrar(Venta ven) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(ven.getVenta_id().equals(0)) {
			ven.setVenta_id(null);
			ventaRepository.save(ven);
		}

		// ACTUALIZAR
		else {
			ventaRepository.save(ven);
		}
	}
	

	public void eliminar(Integer id) {
		
		Venta p = ventaRepository.findById(id).get();
		p.setVenta_estado(false);
		
		ventaRepository.save(p);

		//usuarioRepo.deleteById(usuario_id);
		
	}
	
	

}
