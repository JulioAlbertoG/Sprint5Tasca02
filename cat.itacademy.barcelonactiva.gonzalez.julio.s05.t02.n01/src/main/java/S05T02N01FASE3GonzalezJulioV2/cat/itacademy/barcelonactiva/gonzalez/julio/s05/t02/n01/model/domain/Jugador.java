package S05T02N01FASE3GonzalezJulioV2.cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="Jugadores")
public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
	private int id;
	@Column(name="Nombre")
	private String nom;
	@Column(name="fechaReg")
	private Date data;
	@Column(name="PorcentajeExito")
	private double porcentajeExito;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
	
	private List<Partides> listaPartidas;
	


	public Jugador(String nom) {
		
		this.nom = nom;
		this.data= new Date();
		this.listaPartidas = null;
		
	}
	
	public Jugador () {}

	public int getJugadorId() {
		return id;
	}

	public void setJugadorId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getData() {
		
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public double getPorcentajeExito() {
		return porcentajeExito;
	}

	public double setPorcentajeExito() {
		double exit;
		int win =0;
		int total =0;
		for (Partides partides : listaPartidas) {
			if (partides.isGuanyador()) {
				win++;
				total++;
			}
			total=0;
	
		}
		exit = (win/total)*100;
		return exit;
	}
	
	public List<Partides> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(Partides partida) {
		if (listaPartidas==null) 
		listaPartidas=new ArrayList<>();	
		
		listaPartidas.add(partida);
		partida.setJugador(this);
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nom=" + nom + ", data=" + data + "]";
	}
	
	
}


