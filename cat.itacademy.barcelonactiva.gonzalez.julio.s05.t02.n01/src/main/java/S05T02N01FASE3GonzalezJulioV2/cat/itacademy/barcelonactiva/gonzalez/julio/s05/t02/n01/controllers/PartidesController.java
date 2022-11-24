package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.controllers;

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

import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Partides;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services.JugadorService;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services.PartidesService;



@RestController
@CrossOrigin(origins = "http://localhost:3306")
public class PartidesController {

	@Autowired
	private PartidesService partidesService;
	@Autowired
	private JugadorService jugadorService;
	

	@PostMapping("/players/{id}/games")
	public ResponseEntity<?> playMatch(@PathVariable(value = "id")int id){
		Jugador jugador= jugadorService.buscarPorId(id);
		Partides game = partidesService.guardar(jugador);

		return new ResponseEntity<>(game.toString(),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<?> deleteMatches(@PathVariable(value = "id") int id){
		Jugador jugador = jugadorService.buscarPorId(id);
		partidesService.eliminarPartidas(jugador.getJugadorId());
		
		return new ResponseEntity<>("Partidas borradas", HttpStatus.CREATED);
		
	}
	@GetMapping("/players/{id}/games")
	public ResponseEntity<?> getOne(@PathVariable int id){
		List<Partides> listaPartidas= partidesService.matches(id);
		return new ResponseEntity<>(listaPartidas.toString(),HttpStatus.CREATED);
	}
	@GetMapping("/players/ranking")
	public ResponseEntity<?> rankindPartides(){
		List<Partides> totalPartidas= partidesService.bringAll();
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
