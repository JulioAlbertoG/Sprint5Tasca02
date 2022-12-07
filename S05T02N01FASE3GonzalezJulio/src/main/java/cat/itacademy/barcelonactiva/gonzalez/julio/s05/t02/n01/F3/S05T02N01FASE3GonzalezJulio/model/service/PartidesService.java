package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.service;

import java.util.List;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.Partides;



public interface PartidesService {
	
	public void eliminarPartidas(int id);
	public Partides guardar(Jugador jugador);
	public List<Partides> matches(int id);
	List<Partides> bringAll();

}
