package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services;

import java.util.List;

import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;
import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Partides;



public interface PartidesService {
	
	public void eliminarPartidas(int id);
	public Partides guardar(Jugador jugador);
	public List<Partides> matches(int id);
	List<Partides> bringAll();

}
