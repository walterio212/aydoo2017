package ar.edu.untref.aydoo;

//Tipo de Objeto: Value Object
public class Venta {

	private Cliente cliente;
	private Producto producto;
	private Mes mes;
	private int cantidad;
	
	public Venta(Cliente cliente, Producto producto, Mes mes, int cantidad) {
		this.cliente = cliente;
		this.producto = producto;
		this.mes = mes;
		this.cantidad = cantidad;
	}
	
	public double obtenerPrecioProductoVendido(){
		return this.producto.obtenerPrecio() * cantidad;
	}
	
	public Cliente obtenerCliente(){
		return this.cliente;
	}
	
	public Mes obtenerMes(){
		return this.mes;
	}
}
