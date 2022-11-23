package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services;

import java.util.List;


import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;





public interface JugadorService {
	
	public Jugador guardar(Jugador jugador);
	public Jugador buscarPorId(int jugadorId);
	public void eliminarJugador(int id);
	public List<Jugador> listar();
	public boolean jugadorExiste(Jugador jugador);
	

}
