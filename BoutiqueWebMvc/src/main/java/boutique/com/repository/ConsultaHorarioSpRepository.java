package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.sp.ConsultaHorarioSp;

@Repository
public interface ConsultaHorarioSpRepository extends JpaRepository<ConsultaHorarioSp, Integer> {

	@Query(value="{call sp_consulta_horarios}", nativeQuery=true)
	List<ConsultaHorarioSp> listarHorariosPorFecha();
	
}
