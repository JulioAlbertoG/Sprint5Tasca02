package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository.JugadorRepository;






@Service

public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private JugadorRepository jugadorRepository;
	
	
	@Override
	public List<Jugador> listar() {
		List<Jugador> EntityList = jugadorRepository.findAll();

		return EntityList;
	}
	
	@Override
	public boolean jugadorExiste(Jugador jugador) {
		boolean exist=false;
		List<Jugador> listaJugadores=this.listar();
		if (jugador.getNom()!=null) {
			for (int i = 0; i < listaJugadores.size(); i++) {

				if (jugador.getNom().equalsIgnoreCase(listaJugadores.get(i).getNom())) {

					exist = true;
				}

			}
		}
		return exist;
	}	
	
	@Override
	public Jugador guardar(Jugador jugador) {
		jugadorRepository.save(jugador);
		return jugador;
		
		}
		
		
			

	

	@Override
	public Jugador buscarPorId(int jugadorId) {
		
		Jugador jugador = jugadorRepository.findById(jugadorId).isPresent() ?
				jugadorRepository.findById(jugadorId).get():null;

		return jugador;
	}

	@Override
	public void eliminarJugador(int id) {
		jugadorRepository.deleteById(id);
		
	}




	
}
