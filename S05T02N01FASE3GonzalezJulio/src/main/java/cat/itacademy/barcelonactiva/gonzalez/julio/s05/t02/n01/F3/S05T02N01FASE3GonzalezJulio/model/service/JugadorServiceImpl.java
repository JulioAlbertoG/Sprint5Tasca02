package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.service;



import java.util.Comparator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.F3.S05T02N01FASE3GonzalezJulio.model.repository.JugadorRepository;






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
	public String guardar(Jugador jugador) {
		String result;
		
		if (jugador.getNom()=="") {
			jugador.setNom("Anónimo");
			jugadorRepository.save(jugador);
			
		}
		if (this.jugadorExiste(jugador)) {
			result= "No se ha creado ";
		}else {
			Jugador nou=new Jugador(jugador.getNom());
			jugadorRepository.save(nou);
			result= "Se ha creado correctamente ";
			
		}
		
		return result;
		
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


	@Override
	public Jugador loser() {
		List<Jugador> listaJugadores=this.listar();

		listaJugadores.sort(Comparator.comparing(Jugador::getPorcentajeExito));
		Jugador loser = listaJugadores.get(0);
		return loser;
	}


	@Override
	public Jugador winner() {
		List<Jugador> listaJugadores=this.listar();
		listaJugadores.sort(Comparator.comparing(Jugador::getPorcentajeExito).reversed());
		Jugador winner = listaJugadores.get(0);
		return winner;
	}


	@Override
	public void actualizarExito(Jugador jugador) {
		jugadorRepository.save(jugador);
		
	}





	
}
