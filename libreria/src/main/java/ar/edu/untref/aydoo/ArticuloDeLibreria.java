package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	public ArticuloDeLibreria(String nombre, double precio) {
		super(nombre, precio);
	}

	public double obtenerPrecio() {
		return this.precio + (this.precio * 21/100);
	}
}
