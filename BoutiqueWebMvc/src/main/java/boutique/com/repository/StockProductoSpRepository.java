package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import boutique.com.model.sp.StockProductoSp;

@Repository
public interface StockProductoSpRepository extends JpaRepository<StockProductoSp, Integer> {

	@Transactional // RollBack para errores
	@Query(value="{call sp_consulta_stock_producto_id(:var_id_producto)}", nativeQuery=true)
	List<StockProductoSp> stockPorIdProducto(@Param("var_id_producto") Integer id);
	
}
