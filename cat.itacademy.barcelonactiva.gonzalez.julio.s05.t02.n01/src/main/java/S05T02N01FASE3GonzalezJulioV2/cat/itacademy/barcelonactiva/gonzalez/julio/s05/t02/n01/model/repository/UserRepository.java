package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
