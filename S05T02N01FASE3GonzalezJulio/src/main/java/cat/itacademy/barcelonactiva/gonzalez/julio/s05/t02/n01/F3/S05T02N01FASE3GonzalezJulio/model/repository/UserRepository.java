package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUsername(String username);
	Boolean existsByUsername(String username);
	
}
