package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.domain.Role;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.domain.UserEntity;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.dto.AuthResponseDTO;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.dto.LoginDto;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.dto.RegisterDto;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.repositories.RoleRepository;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.repositories.UserRepository;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.security.JWTGenerator;

import java.util.Collections;

@RestController
@RequestMapping("/players/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}