package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer>{

}
