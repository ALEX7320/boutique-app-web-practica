package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Integer>{
	
	@Query(value="SELECT s FROM Salida s WHERE s.producto_id.producto_estado = ?1")
	List<Salida> findAllByProductoActivo(Boolean active);
	
	@Query(value="SELECT s FROM Salida s WHERE s.producto_id.producto_id = ?1")
	List<Salida> findAllByProductoId(Integer id);

}
