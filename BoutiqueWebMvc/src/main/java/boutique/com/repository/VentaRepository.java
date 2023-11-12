package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
	@Query(value="SELECT v FROM Venta v WHERE v.venta_estado = ?1 order by v.venta_id desc")
	List<Venta> findAllByVentaActivos(Boolean active);
	
	//@Query(value="SELECT v.venta_id,v.venta_fecha,v.venta_descripcion,v.venta_igv,v.venta_estado,v.tipopago_id,v.cliente_id FROM Venta v")
	//List<Venta> findAllVentaNoDetalle();


}
