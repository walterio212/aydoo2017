package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {
	@Test
	public void obtenerPrecioDeberiaDevolverPrecioDelProducto(){
		Producto p1 = new Producto("P1", 22);
		double precio = p1.obtenerPrecio();
		
		Assert.assertEquals(22, precio, 0.1);
	}
	
	@Test
	public void obtenerNombreDeberiaDevolverNombreDelProducto(){
		Producto p1 = new Producto("P1", 22);
		String nombre = p1.obtenerNombre();
		
		Assert.assertEquals("P1", nombre);
	}
}
