package boutique.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import boutique.com.model.sp.VentaProductoFechaSp;

@Repository
public interface VentaProductoFechaSpRepository extends JpaRepository<VentaProductoFechaSp, Integer> {
	
	@Transactional // RollBack para errores
	@Query(value="{call sp_reporte_venta_prod_fechas(:var_id_producto,:var_fecha_inicio,:var_fecha_fin)}", nativeQuery=true)
	List<VentaProductoFechaSp> reporteVentasProductoPorId(
			@Param("var_id_producto") Integer id,
			@Param("var_fecha_inicio") Date inicio,
			@Param("var_fecha_fin") Date fin

			);
	

}
