package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;




public interface JugadorRepository extends JpaRepository<Jugador, Integer> {}
