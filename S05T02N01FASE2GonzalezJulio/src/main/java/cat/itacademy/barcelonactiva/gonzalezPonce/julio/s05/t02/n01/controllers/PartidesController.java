package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Partides;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services.JugadorService;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class PartidesController {
	
	@Autowired
	private JugadorService jugadorService;
	

	@PostMapping("/players/{id}/games")
	public ResponseEntity<?> playMatch(@PathVariable(value = "id")int id){
		
		jugadorService.guardarPartida(id);
		

		return new ResponseEntity<>(jugadorService.buscarPorId(id).toString(),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<?> deleteMatches(@PathVariable(value = "id") int id){
		
		jugadorService.eliminarPartidas(id);
		
		
		return new ResponseEntity<>("Partidas borradas", HttpStatus.CREATED);
		
	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<?> getOne(@PathVariable int id){
		
		List<Partides> listaPartidas=jugadorService.matches(id);
		return new ResponseEntity<>(listaPartidas.toString(),HttpStatus.CREATED);
	}
	@GetMapping("/players/ranking")
	public ResponseEntity<?> rankindPartides(){
		List<Jugador> listaJugadors=jugadorService.listar();
		List<Partides> totalPartidas= jugadorService.bringAll(listaJugadors);
		int exit=0;
		for (Partides partides : totalPartidas) {
			if (partides.isGuanyador()) {
				exit++;
			}
		}
		double ranking = (exit/totalPartidas.size()*100);
		return new ResponseEntity<>("Media de éxito total es: "+ ranking,HttpStatus.CREATED);
	}
}
