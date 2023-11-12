package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Producto;
import boutique.com.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository porductoRepository;	
		
	public List<Producto> buscarTodo(){
		// BUSCAR SOLO PRODUCTOS ACTIVOS
		return (List<Producto>) porductoRepository.findAllByProductoActivos(true);

		//return (List<Producto>) porductoRepository.findAll();
	}
		
	
	
	public List<Producto> buscarSinExcepcion(){
		// BUSCAR SOLO PRODUCTOS ACTIVOS
		return (List<Producto>) porductoRepository.findAll();
	}
		


	public Producto buscarPorId(int id) {
		return porductoRepository.findById(id).get();

	}

	
	public void registrar(Producto prod) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(prod.getProducto_id().equals(0)) {
			prod.setProducto_id(null);
			porductoRepository.save(prod);
		}

		// ACTUALIZAR
		else {
			porductoRepository.save(prod);
		}
	}
	
	

	public void eliminar(Integer id) {
		
		Producto p = porductoRepository.findById(id).get();
		p.setProducto_estado(false);
		
		porductoRepository.save(p);

		//usuarioRepo.deleteById(usuario_id);
		
	}
	
	
}
