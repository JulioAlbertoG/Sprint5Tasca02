package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain;




public class Partides {
	

	
	
	private int id;
	
	private int valor1;
	
	private int valor2;
	
	private boolean guanyador;
	
	


	public Partides(int id,int valor1, int valor2, boolean guanyador) {
		this.id=id;
		this.valor1=valor1;
		this.valor2=valor2;
		this.guanyador=guanyador;
	}
	
	public Partides() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "Partides [id=" + id + ", valor1=" + valor1 + ", valor2=" + valor2 + ", guanyador=" + guanyador
				 + "]";
	}

	
}

