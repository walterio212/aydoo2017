package ar.edu.untref.aydoo;

public abstract class Producto {

	public String nombre;
	public double precio;
	
	public Producto(String nombre, double precio){
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public abstract double obtenerPrecio();
}
