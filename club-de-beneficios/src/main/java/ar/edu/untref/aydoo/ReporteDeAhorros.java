package ar.edu.untref.aydoo;

import java.util.List;

public class ReporteDeAhorros {
	private Cliente cliente;
	private List<Venta> ventas;
	
	public ReporteDeAhorros(Cliente cliente, List<Venta> ventasDelCliente) {
		this.cliente = cliente;
		this.ventas = ventasDelCliente;
	}
	
	public List<Venta> obtenerVentas(){
		return this.ventas;
	}
	
	public Cliente obtenerCliente(){
		return this.cliente;
	}
	
	public double obtenerCostoTotalSinDescuento(){
		double total = 0;
		for (int i = 0; i < ventas.size(); i++){
			double totalProductos = ventas.get(i).obtenerCostoTotalSinDescuento();
			total += totalProductos;
		}
		
		return total;
	}
	
	public double obtenerCostoTotalConDescuento(){
		double total = 0;
		for (int i = 0; i < ventas.size(); i++){
			double totalProductos = ventas.get(i).obtenerCostoTotalConDescuento();
			total += totalProductos;
		}

		return total;
	}
}
