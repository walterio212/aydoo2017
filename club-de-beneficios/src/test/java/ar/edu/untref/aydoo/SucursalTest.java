package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class SucursalTest {

	@Test
	public void venderDeberiaGenerarUnaVenta(){
		Cliente clienteA = new Cliente("A");
		
		Producto productoA = new Producto("ProductoA", 20);
		Producto productoB = new Producto("ProductoB", 50);
		
		ArrayList<Producto> productosClienteA = new ArrayList<Producto>();
		productosClienteA.add(productoA);
		productosClienteA.add(productoB);
		
		Sucursal sucursalRojaA = new Sucursal("SRA");
		sucursalRojaA.vender(clienteA, productosClienteA, LocalDate.of(2017, 2, 1));
		
		List<Venta> ventasRealizadas = sucursalRojaA.obtenerVentas(Month.FEBRUARY);
		
		Assert.assertEquals(1, ventasRealizadas.size());
	}
}
