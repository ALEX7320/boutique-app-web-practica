package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Descuento;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Integer>{

	@Query(value="SELECT d FROM Descuento d WHERE d.descuento_disponible = ?1")
	List<Descuento> findAllByDescuentosActivos(Boolean active);
	
}
