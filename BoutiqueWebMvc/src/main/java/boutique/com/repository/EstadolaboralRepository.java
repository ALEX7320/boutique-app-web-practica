package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Estadolaboral;

@Repository
public interface EstadolaboralRepository extends JpaRepository<Estadolaboral, Integer>{

}
