package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Ingreso;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Integer>{

	
	@Query(value="SELECT i FROM Ingreso i WHERE i.producto_id.producto_estado = ?1")
	List<Ingreso> findAllByProductoActivo(Boolean active);
	
	
	@Query(value="SELECT i FROM Ingreso i WHERE i.producto_id.producto_id = ?1")
	List<Ingreso> findAllByProductoId(Integer id);
}
