package ar.edu.untref.aydoo;

// Tipo de objeto: Entity
public class Revista extends Suscripcion {

	private boolean esEjemplarIndividual;
	
	public Revista(String nombre, double precio, int periodicidad, boolean anual, boolean esEjemplarIndividual) {
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
