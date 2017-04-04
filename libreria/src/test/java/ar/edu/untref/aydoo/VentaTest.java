package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VentaTest {
	
	@Test
	public void obtenerPrecioDeberiaDevolverPrecioDelProductoPorCantidad(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, true);
		Cliente cliente = new Cliente("Juan", "Direccion 1");
		Venta venta = new Venta(cliente, periodico, Mes.Agosto, 3);
		
		double precio = venta.obtenerPrecioProductoVendido();
		
		Assert.assertEquals(30, precio, 0.1);
	}
	
	@Test
	public void obtenerClienteDeberiaDevolverElCliente(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, true);
		Cliente cliente = new Cliente("Juan", "Direccion 1");
		Venta venta = new Venta(cliente, periodico, Mes.Agosto, 3);
		
		Cliente clienteResultado = venta.obtenerCliente();
		
		Assert.assertEquals(cliente, clienteResultado);
	}
	
	@Test
	public void obtenerClienteDeberiaDevolverElMes(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, true);
		Cliente cliente = new Cliente("Juan", "Direccion 1");
		Venta venta = new Venta(cliente, periodico, Mes.Agosto, 3);
		
		Mes agosto = venta.obtenerMes();
		
		Assert.assertEquals(Mes.Agosto, agosto);
	}
}
