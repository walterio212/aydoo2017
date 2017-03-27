package ar.edu.untref.aydoo;

public class Partido {

	private String nombre;
	private int cantidadDeVotos;
	
	public Partido(String nombre){
		this.nombre = nombre;
	}
	
	public void sumarVoto(){
		this.cantidadDeVotos++;
	}
	
	public int obtenerCantidadDeVotos(){
		return this.cantidadDeVotos;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
}
