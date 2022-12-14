package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.Role;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.UserEntity;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	private  UserRepository userRepository;
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		
	}
	@Override
	public  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user= userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not Found"));
		return new User(user.getUsername(), user.getPassword(), mapRolesAuthorities(user.getRoles()));
	}
	
	private Collection<GrantedAuthority> mapRolesAuthorities(List<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
