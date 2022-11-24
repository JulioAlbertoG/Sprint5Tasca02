package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services;

import java.util.List;

import S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;





public interface JugadorService {
	
	public Jugador guardar(Jugador jugador);
	public Jugador buscarPorId(int jugadorId);
	public void eliminarJugador(int id);
	public List<Jugador> listar();
	public boolean jugadorExiste(Jugador jugador);
	

}
