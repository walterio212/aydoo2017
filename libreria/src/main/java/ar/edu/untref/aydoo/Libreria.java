package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Libreria {

	private ArrayList<Venta> ventas;
	
	public Libreria(){
		ventas = new ArrayList<Venta>();
	}
	
	public void realizarVenta(Cliente cliente, Mes mes, Producto producto, int cantidad){
		Venta venta = new Venta(cliente, producto, mes, cantidad);
		ventas.add(venta);
	}
	
	public double calcularMontoACobrar(Cliente cliente, Mes mes){
		double precio = 0;
		
		for(int i = 0; i < ventas.size(); i++){
			Venta venta = ventas.get(i);
			if(venta.obtenerCliente() == cliente && venta.obtenerMes() == mes){
				precio += venta.obtenerPrecioProductoVendido();
			}
		}
		
		return precio;
	}	
}
