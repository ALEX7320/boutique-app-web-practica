package boutique.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Rol;
import boutique.com.model.bd.User;

import java.util.*;
import javax.transaction.Transactional;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User user = userService.findUserByUserName(username);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Rol> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for(Rol role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRolname()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, 
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.getActive(),
				true, true, true, authorities);
	}
	
	
}
