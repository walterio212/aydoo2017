package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {
	@Test
	public void obtenerNombreDeberiaDevolverNombre(){
		Revista revista = new Revista("Revista A", 10, 2, false, true);
		
		String nombre = revista.obtenerNombre();
		
		Assert.assertEquals("Revista A", nombre);
	}
	
	@Test
	public void obtenerPrecioIndividualDeberiaDevolverPrecioCrudo(){
		Revista revista = new Revista("Revista A", 10, 2, false, true);
		
		double precio = revista.obtenerPrecio();
		
		Assert.assertEquals(10, precio, 0.1);
	}
	
	@Test
	public void obtenerPrecioSuscripcionNoAnualDeberiaDevolverPrecioPorPeriodicidad(){
		Revista revista = new Revista("Revista A", 10, 2, false, false);
		
		double precio = revista.obtenerPrecio();
		
		Assert.assertEquals(20, precio, 0.1);
	}
	
	@Test
	public void obtenerPrecioSuscripcionAnualDeberiaDevolverPrecioPorPeriodicidadCon20PorcientoDeDescuento(){
		Revista revista = new Revista("Revista A", 10, 2, true, false);
		
		double precio = revista.obtenerPrecio();
		
		Assert.assertEquals(16, precio, 0.1);
	}
}
