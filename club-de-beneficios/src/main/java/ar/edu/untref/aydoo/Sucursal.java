package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private String nombre;
	private List<Venta> ventas;
	
	public Sucursal(String nombre) {
		this.nombre = nombre;
		ventas = new ArrayList<Venta>();
	}

	public void vender(Cliente clienteA, ArrayList<Producto> productosClienteA) {
		Venta venta = new Venta();
		this.ventas.add(venta);
	}

	public List<Venta> obtenerVentas() {
		return this.ventas;
	}

	public Object obtenerNombre() {
		return this.nombre;
	}
}
