package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("jugadores")
public class Jugador {
/*
	@Transient
    public static final String SEQUENCE_NAME = "db_sequences";
*/
	@Id
	private int id;
	
	private String nom;
	
	private Date data;
	
	private double porcentajeExito;

	
	
	private List<Partides> listaPartidas;
	


	public Jugador(String nom) {
		
		this.nom = nom;
		this.data= new Date();
		this.listaPartidas = null;
		
	}
	
	public Jugador () {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setPorcentajeExito(double porcentajeExito) {
		this.porcentajeExito = porcentajeExito;
	}

	public List<Partides> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(List<Partides> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nom=" + nom + ", data=" + data + ", porcentajeExito=" + porcentajeExito
				+ ", listaPartidas=" + listaPartidas + "]";
	}


	
}



