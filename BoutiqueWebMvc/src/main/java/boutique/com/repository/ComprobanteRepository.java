package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Comprobante;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer>{

}
