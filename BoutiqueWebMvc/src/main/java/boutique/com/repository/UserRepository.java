package boutique.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import boutique.com.model.bd.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
	User findByUsername(String username);
	
	User findByDni(String dni);

	
	List<User> findAllByActive(Boolean active);
	
	List<User> findAllByActiveAndDni(Boolean active, String dni);

	
}
