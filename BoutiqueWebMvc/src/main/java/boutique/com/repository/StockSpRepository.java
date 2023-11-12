package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.sp.StockSp;

@Repository
public interface StockSpRepository extends JpaRepository<StockSp, Integer> {

	@Query(value="{call sp_consulta_stock}", nativeQuery=true)
	List<StockSp> listarStock();


	
	
}
