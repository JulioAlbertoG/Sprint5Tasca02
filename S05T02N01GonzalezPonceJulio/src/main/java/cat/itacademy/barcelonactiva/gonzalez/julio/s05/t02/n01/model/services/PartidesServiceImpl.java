package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain.Partides;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.repository.PartidesRepository;



@Service
public class PartidesServiceImpl implements PartidesService{

	@Autowired
	private PartidesRepository partidesRepository;
	@Autowired
	private JugadorRepository jugadorRepository;
	
	
	
	
	@Override
	public void eliminarPartidas(int id) {
		jugadorRepository.getById(id);
		partidesRepository.deleteAll();
		
	}

	@Override
	public Partides guardar(Jugador jugador) {
		
		Partides match=new Partides(jugador);
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
		partidesRepository.save(match);
		return match;
	}

	@Override
	public List<Partides> matches(int id){
		
		Jugador jugador=jugadorRepository.getById(id);
		
		return jugador.getListaPartidas();
	}


	@Override
	public List<Partides> bringAll() {
		List<Partides> entityList= partidesRepository.findAll();
		return entityList;
	}

}

