package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Role;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.UserEntity;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Nombre de usuario no encontrado"));
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    
}

