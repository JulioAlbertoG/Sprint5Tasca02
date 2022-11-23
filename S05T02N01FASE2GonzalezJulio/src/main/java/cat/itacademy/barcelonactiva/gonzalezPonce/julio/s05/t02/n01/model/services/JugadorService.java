package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Partides;



public interface JugadorService {

	public Jugador guardar(Jugador jugador);
	public Jugador buscarPorId(int jugadorId);
	public void eliminarJugador(int id);
	public List<Jugador> listar();
	public boolean jugadorExiste(Jugador jugador);
	
	public void eliminarPartidas(int id);
	public Partides guardarPartida(int id);
	public List<Partides> matches(int id);
	
	public List<Partides> bringAll(List<Jugador> listaJugador);
}
