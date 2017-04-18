package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReporteDeAhorrosTest {
	@Test
	public void obtenerCLienteDeberiaDevolverElCliente(){
		Cliente cliente = new Cliente("A");
		List<Venta> ventas = new ArrayList<Venta>();
		ReporteDeAhorros reporte = new ReporteDeAhorros(cliente, ventas);
		
		Cliente result = reporte.obtenerCliente();
		
		Assert.assertEquals(cliente, result);
	}
	
	@Test
	public void obtenerVentasDeberiaDevolverLasVentas(){
		Cliente cliente = new Cliente("A");
		cliente.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		
		List<Venta> ventas = new ArrayList<Venta>();
		Producto p1 = new Producto("P1", 100);
		Producto p2 = new Producto("P2", 300);
		Establecimiento estab = new Establecimiento("EST", new ArrayList<Sucursal>(), new ArrayList<Beneficio>());
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(p1);
		productos.add(p2);
		ventas.add(new Venta(LocalDate.of(2017, 2, 1), cliente, productos, estab));
		
		ReporteDeAhorros reporte = new ReporteDeAhorros(cliente, ventas);
		
		List<Venta> result = reporte.obtenerVentas();
		
		Assert.assertEquals(1, result.size());
	}
}
