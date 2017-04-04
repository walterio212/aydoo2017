package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class ArticuloDeLibreriaTest {

	@Test
	public void obtenerPrecioDeberiaDevolverPrecioConIva(){
		ArticuloDeLibreria articulo = new ArticuloDeLibreria("Lapicera", 5);
		
		double precio = articulo.obtenerPrecio();
		
		Assert.assertEquals(6.05, precio, 0.001);
	}
	
	@Test
	public void obtenerNombreDeberiaDevolverNombre(){
		ArticuloDeLibreria articulo = new ArticuloDeLibreria("Lapicera", 5);
		
		String nombre = articulo.obtenerNombre();
		
		Assert.assertEquals("Lapicera", nombre);
	}
}
