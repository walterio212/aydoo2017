package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class PeriodicoTest {

	@Test
	public void obtenerNombreDeberiaDevolverNombre(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, true);
		
		String nombre = periodico.obtenerNombre();
		
		Assert.assertEquals("Diario A", nombre);
	}
	
	@Test
	public void obtenerPrecioIndividualDeberiaDevolverPrecioCrudo(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, true);
		
		double precio = periodico.obtenerPrecio();
		
		Assert.assertEquals(10, precio, 0.1);
	}
	
	@Test
	public void obtenerPrecioSuscripcionNoAnualDeberiaDevolverPrecioPorPeriodicidad(){
		Periodico periodico = new Periodico("Diario A", 10, 2, false, false);
		
		double precio = periodico.obtenerPrecio();
		
		Assert.assertEquals(20, precio, 0.1);
	}
	
	@Test
	public void obtenerPrecioSuscripcionAnualDeberiaDevolverPrecioPorPeriodicidadCon20PorcientoDeDescuento(){
		Periodico periodico = new Periodico("Diario A", 10, 2, true, false);
		
		double precio = periodico.obtenerPrecio();
		
		Assert.assertEquals(16, precio, 0.1);
	}
}
