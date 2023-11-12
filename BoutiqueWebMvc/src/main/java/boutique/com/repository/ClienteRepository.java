package boutique.com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value="SELECT c FROM Cliente c WHERE c.cliente_dni = ?1 AND c.cliente_id != ?2")
	Cliente buscarDniExistente(String dni, Integer id);
	
	
	@Query(value="SELECT c FROM Cliente c WHERE c.cliente_estado = ?1")
	List<Cliente> findAllByClienteActivos(Boolean active);
	
}
