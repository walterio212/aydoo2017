package ar.edu.untref.aydoo;

public class PartidoPorProvincia {

	private Provincia provincia;
	private Partido partido;
	private int cantidadDeVotos;
	
	public PartidoPorProvincia(Provincia provincia, Partido partido){
		this.provincia = provincia;
		this.partido = partido;		
	}
	
	public void sumarVoto(){
		this.cantidadDeVotos++;
	}
	
	public int obtenerCantidadDeVotos(){
		return this.cantidadDeVotos;
	}
	
	public Partido obtenerPartido(){
		return this.partido;
	}
	
	public Provincia obtenerProvincia(){
		return this.provincia;
	}
}
