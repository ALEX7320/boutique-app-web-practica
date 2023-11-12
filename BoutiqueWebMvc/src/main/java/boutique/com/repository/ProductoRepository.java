package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>  {

	
	@Query(value="SELECT a FROM Producto a WHERE a.producto_estado = ?1")
	List<Producto> findAllByProductoActivos(Boolean active);

}
