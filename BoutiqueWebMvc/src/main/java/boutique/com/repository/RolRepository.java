package boutique.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Rol findByRolname(String rolname);

}
