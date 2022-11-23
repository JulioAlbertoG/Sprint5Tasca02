package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name="Partides")
public class Partides implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private int valor1;
	@Column
	private int valor2;
	@Column
	private boolean guanyador;
	
	@ManyToOne
	@JoinColumn(name="jugadorId")
	private Jugador jugador;

	public Partides(Jugador jugador) {
		
		this.jugador = jugador;
	}
	
	public Partides() {}

	public int getPartidaId() {
		return id;
	}

	public void setpartidaId(int partidaId) {
		this.id = partidaId;
	}

	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}


	public boolean isGuanyador() {
		return guanyador;
	}

	public void setGuanyador(boolean guanyador) {
		this.guanyador = guanyador;
	}

	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Partides [id=" + id + ", valor1=" + valor1 + ", valor2=" + valor2 + ", guanyador=" + guanyador + "]";
	}
}

