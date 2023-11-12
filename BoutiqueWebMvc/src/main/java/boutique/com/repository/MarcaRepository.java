package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
