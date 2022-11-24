package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.domain.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
