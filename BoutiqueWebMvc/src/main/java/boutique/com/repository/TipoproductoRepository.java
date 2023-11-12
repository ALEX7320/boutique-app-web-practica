package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Tipoproducto;

@Repository
public interface TipoproductoRepository extends JpaRepository<Tipoproducto, Integer>{

}
