package ar.edu.untref.aydoo;

public class Periodico extends Suscripcion {

	private boolean esEjemplarIndividual;
	
	public Periodico(String nombre, double precio, int periodicidad, boolean anual, boolean esEjemplarIndividual) {
		super(nombre, precio, periodicidad, anual);
		this.esEjemplarIndividual = esEjemplarIndividual;
	}
	
	public double obtenerPrecio(){
		if(!this.esEjemplarIndividual){
			return super.obtenerPrecio();
		}
		
		return this.precio;
	}
}
