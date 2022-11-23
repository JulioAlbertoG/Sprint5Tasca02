package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.Partides;
import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.repositories.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private JugadorRepository jugadorRepository;
	
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
	public void eliminarPartidas(int id) {
		Jugador jugador =jugadorRepository.findById(id).orElse(null);
		jugador.getListaPartidas().clear();
		
		jugadorRepository.save(jugador);
	}

	@Override
	public Partides guardarPartida(int id ) {
		Partides match=new Partides();
		match.setId(id);
		int valor1= (int)(Math. random()*6+1);
		match.setValor1(valor1);
		int valor2= (int)(Math. random()*6+1);
		match.setValor2(valor2);
		int total = valor1+valor2;
		if (total==7) {
			match.setGuanyador(true);
				
			
		}else {
			match.setGuanyador(false);
			
			
		}
		jugadorRepository.save(match);
		
		return match;
	}

	@Override
	public List<Partides> matches(int id) {
		Jugador jugador=jugadorRepository.findById(id).orElse(null);
		
		return jugador.getListaPartidas();
	}

	@Override
	public List<Partides> bringAll(List<Jugador> listaJugador) {
		List<Partides> entityList= new ArrayList<Partides>();
		for (Jugador jugador : listaJugador) {
			jugador.getListaPartidas().toString();
			entityList.addAll(jugador.getListaPartidas());
		}
		
		
		
		return entityList;
	}


}
