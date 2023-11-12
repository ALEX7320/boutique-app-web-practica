package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Detalleventa;

@Repository
public interface DetalleventaRepository extends JpaRepository<Detalleventa, Integer>{
	
	@Query(value="SELECT d FROM Detalleventa d WHERE d.venta_id.venta_id = ?1")
	List<Detalleventa> findAllByIdVenta(Integer id);

}
