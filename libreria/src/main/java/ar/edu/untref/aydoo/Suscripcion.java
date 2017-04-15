package ar.edu.untref.aydoo;

//Tipo de Objeto Entity
public class Suscripcion extends Producto {

	private int periodicidad;
	private boolean anual;
	
	public Suscripcion(String nombre, double precio, int periodicidad, boolean anual) {
		super(nombre, precio);
		
		this.periodicidad = periodicidad;
		this.anual = anual;
	}

	@Override
	public double obtenerPrecio() {
		
		double precioFinal = this.precio;
		
		if(anual){
			precioFinal = this.precio - (this.precio * 20/100);
		}
		
		precioFinal = precioFinal * this.periodicidad;
		
		
		return precioFinal;
	}

}
