package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.service;

import java.util.List;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.Jugador;





public interface JugadorService {
	
	public String guardar(Jugador jugador);
	public Jugador buscarPorId(int jugadorId);
	public void eliminarJugador(int id);
	public List<Jugador> listar();
	public boolean jugadorExiste(Jugador jugador);
	public Jugador loser();
	public Jugador winner();
	public void actualizarExito(Jugador jugador);
	

	

}
