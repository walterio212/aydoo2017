package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoVendidoTest {
	@Test
	public void obtenerProductoDeberiaDevolverEllProducto(){
		Producto p = new Producto("P1", 12);
		ProductoVendido target  = new ProductoVendido(p, 9);
		
		Assert.assertEquals(p, target.obtenerProducto());
	}
	
	@Test
	public void obtenerPrecioVendidoDeberiaDevolverElPrecioDelProductoVendido(){
		Producto p = new Producto("P1", 12);
		ProductoVendido target  = new ProductoVendido(p, 9);
		
		Assert.assertEquals(9, target.obtenerPrecioVendido(), 0.1);
	}
}
