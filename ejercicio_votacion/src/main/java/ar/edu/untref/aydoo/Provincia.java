package ar.edu.untref.aydoo;

public class Provincia {

	private String nombre;
	private int votosEnProvincia;
		
	public Provincia(String nombre){
		this.nombre = nombre;
	}
	
	public void sumarVoto(){
		this.votosEnProvincia++;		
	}
	
	public int obtenerVotosEnProvincia(){
		return this.votosEnProvincia;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}	
}
