package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscrípcionTest {
	
	@Test
	public void obtenerNombreDeberiaDevolverNombre(){
		Suscripcion suscripcion = new Suscripcion("Suscripcion A", 10, 2, false);
		
		String nombre = suscripcion.obtenerNombre();
		
		Assert.assertEquals("Suscripcion A", nombre);
	}
		
	@Test
	public void obtenerPrecioSuscripcionNoAnualDeberiaDevolverPrecioPorPeriodicidad(){
		Suscripcion suscripcion = new Suscripcion("Suscripcion A", 10, 2, false);
		
		double precio = suscripcion.obtenerPrecio();
		
		Assert.assertEquals(20, precio, 0.1);
	}
	
	@Test
	public void obtenerPrecioSuscripcionAnualDeberiaDevolverPrecioPorPeriodicidadCon20PorcientoDeDescuento(){
		Suscripcion suscripcion = new Suscripcion("Suscripcion A", 10, 2, true);
		
		double precio = suscripcion.obtenerPrecio();
		
		Assert.assertEquals(16, precio, 0.1);
	}
}
