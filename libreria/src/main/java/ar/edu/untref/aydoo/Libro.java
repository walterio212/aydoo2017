package ar.edu.untref.aydoo;

//Tipo de Objeto: Entity
public class Libro extends Producto {

	public Libro(String nombre, double precio){
		super(nombre, precio);
	}
	
	public double obtenerPrecio() {
		return this.precio;
	}
}
