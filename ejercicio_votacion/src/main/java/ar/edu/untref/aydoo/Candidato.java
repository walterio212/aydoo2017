package ar.edu.untref.aydoo;

public class Candidato {

	private Partido partido;
	private String nombre;
	private int cantidadDeVotos;
	
	public Candidato(String nombre, Partido partido){
		this.nombre = nombre;
		this.partido = partido;
	}
	
	public void sumarVoto(){
		this.cantidadDeVotos++;
		this.partido.sumarVoto();
	}

	public String obtenerNombre(){
		return this.nombre;
	}
	
	public Partido obtenerPartido(){
		return this.partido;
	}
	
	public int obtenerCantidadDeVotos(){
		return cantidadDeVotos;
	}
}
