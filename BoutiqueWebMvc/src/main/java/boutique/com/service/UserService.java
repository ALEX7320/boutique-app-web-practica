package boutique.com.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Rol;
import boutique.com.model.bd.User;
import boutique.com.repository.RolRepository;
import boutique.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private RolRepository rolRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
	
	public User findUserByDni(String dni) {
		return userRepository.findByDni(dni);
	}
	
	public User findUserById(int id) {
		return userRepository.findById(id).get();

	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User saveUser(User user, String rol) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		
		//Esto puede ser dinámico
		Rol userRol = rolRepository.findByRolname(rol);
		
		user.setRoles(new HashSet<Rol>(Arrays.asList(userRol)));		
		return userRepository.save(user);
	}
	
	// estras

	public List<User> buscarTodo(){
		return (List<User>) userRepository.findAll();
	}
	
	
	public List<User> buscarPorEstado(Boolean active){
		return (List<User>) userRepository.findAllByActive(active);
	}
	
	
	
	public List<User> buscarPorEstadoAndDni(Boolean active, String dni){
		return (List<User>) userRepository.findAllByActiveAndDni(active, dni);
	}
	
	
	
	public User guardadoSimple(User user) {
		
		//Esto puede ser dinámico
		//Rol userRol = rolRepository.findByRolname(rol);
		//user.setRoles(new HashSet<Rol>(Arrays.asList(userRol)));		
		
		return userRepository.save(user);
	}
	
}
