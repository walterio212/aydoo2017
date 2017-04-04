package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class LibroTest {

	@Test
	public void obtenerPrecioDeberiaDevolverPrecio(){
		Libro libro = new Libro("El Hobbit", 50);
		
		double precio = libro.obtenerPrecio();
		
		Assert.assertEquals(50, precio, 0.1);
	}
	
	@Test
	public void obtenerNombreDeberiaDevolverNombre(){
		Libro libro = new Libro("El Hobbit", 50);
		
		String nombre = libro.obtenerNombre();
		
		Assert.assertEquals("El Hobbit", nombre);
	}
}
