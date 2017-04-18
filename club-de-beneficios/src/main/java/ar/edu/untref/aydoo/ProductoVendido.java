package ar.edu.untref.aydoo;

public class ProductoVendido {
	private Producto producto;
	private double precioVendido;
	
	public ProductoVendido(Producto producto, double precioVendido){
		this.producto = producto;
		this.precioVendido = precioVendido;
	}
	
	public Producto obtenerProducto(){
		return this.producto;
	}
	
	public double obtenerPrecioVendido(){
		return this.precioVendido;
	}
}
