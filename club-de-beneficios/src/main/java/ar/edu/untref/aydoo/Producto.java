package ar.edu.untref.aydoo;

public class Producto {

	private double precio;
	private String nombre;
	
	public Producto(String nombre, double precio) {
		this.precio = precio;
		this.nombre = nombre;
	}

	public double obtenerPrecio() {
		return this.precio;
	}

	public String obtenerNombre() {
		return this.nombre;
	}
}
