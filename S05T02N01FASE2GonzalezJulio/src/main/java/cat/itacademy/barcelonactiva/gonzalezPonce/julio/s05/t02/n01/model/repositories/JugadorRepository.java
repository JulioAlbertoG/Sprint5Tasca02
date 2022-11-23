package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Partides;

public interface JugadorRepository extends MongoRepository<Jugador, Integer>{

	public void save(Partides match);
	
	

}
