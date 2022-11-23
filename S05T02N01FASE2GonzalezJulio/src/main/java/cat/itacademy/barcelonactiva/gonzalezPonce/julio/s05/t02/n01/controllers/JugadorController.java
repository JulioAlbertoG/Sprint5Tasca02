package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services.JugadorService;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services.SequenceGeneratorService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/players")
	public List<Jugador> getAll() {
		List<Jugador> listaJugadores = jugadorService.listar();
		
		return listaJugadores;
	}

	
	@PostMapping("/players")
	public ResponseEntity<?> save(@RequestBody Jugador jugador){
		
		if (jugador.getNom()=="") {
			jugador.setId(sequenceGeneratorService.generateSequence("db_sequences"));
			jugador.setNom("Anónimo");
			
		}
		if (!jugadorService.jugadorExiste(jugador)) {
			Jugador nou=new Jugador(jugador.getNom());
			nou.setId(sequenceGeneratorService.generateSequence("db_sequences"));
			jugadorService.guardar(nou);
			return new ResponseEntity<>("Se ha creado correctamente ",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("No se ha creado ",HttpStatus.BAD_REQUEST);
		}
		
								
	}
	
	@GetMapping("/players/ranking/loser")
	public ResponseEntity<?> getRankingLoser(){
		List<Jugador> listaJugadores=jugadorService.listar();

		listaJugadores.sort(Comparator.comparing(Jugador::getPorcentajeExito));
		Jugador loser = listaJugadores.get(0);
		
		return new ResponseEntity<>("Jugador con peores resultados" + loser.getNom(),HttpStatus.OK);
	}
	
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<?> getRankingWinner(){
		List<Jugador> listaJugadores=jugadorService.listar();

		listaJugadores.sort(Comparator.comparing(Jugador::getPorcentajeExito).reversed());
		Jugador winner = listaJugadores.get(0);
		
		return new ResponseEntity<>("Jugador con mejores resultados" + winner.getNom(),HttpStatus.OK);
	}
	
	@PutMapping("/players/{id}")
	public ResponseEntity<?> update(@RequestBody Jugador jugadorDetail,@PathVariable (value="id")int jugadorId){
		Jugador jugador = jugadorService.buscarPorId(jugadorId);
		jugador.setNom(jugadorDetail.getNom());
		jugadorService.guardar(jugador);
		
		return new ResponseEntity<>("Jugador actualizado", HttpStatus.OK);
	}
	@DeleteMapping("/players/{id}")
	public void delete(@PathVariable (value="id")int jugadorId) {
		jugadorService.eliminarJugador(jugadorId);
	}
	
}
