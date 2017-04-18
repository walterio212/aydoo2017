package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BeneficioDosPorUnoTest {
	@Test
	public void obtenerProductosConDescuentoUnSoloProductoDeberaDevolverElProductoSinAplicarNingunDescuento(){
		Producto p1 = new Producto("P1", 22);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(p1);
		
		BeneficioDosPorUno beneficio = new BeneficioDosPorUno("2x1", TipoDeTarjeta.CLASSIC);
		
		List<ProductoVendido> resultado = beneficio.obtenerProductosConDescuento(productos);
		
		Assert.assertEquals(1, resultado.size());
		Assert.assertEquals(22, resultado.get(0).obtenerPrecioVendido(), 0.1);
	}
	
	@Test
	public void obtenerProductosConDescuentoProductosSuperando100DeberaDevolverElMasCaroCobrandoloYElOtroGratis(){
		Producto p22 = new Producto("P22", 22);
		Producto p50 = new Producto("P50", 50);
		Producto p122 = new Producto("P122", 122);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(p122);
		productos.add(p22);
		productos.add(p50);
		
		BeneficioDosPorUno beneficio = new BeneficioDosPorUno("2x1", TipoDeTarjeta.CLASSIC);
		
		List<ProductoVendido> resultado = beneficio.obtenerProductosConDescuento(productos);
		
		Assert.assertEquals(3, resultado.size());
		Assert.assertEquals(122, resultado.get(0).obtenerPrecioVendido(), 0.1);
		Assert.assertEquals(0, resultado.get(1).obtenerPrecioVendido(), 0.1);
		Assert.assertEquals(50, resultado.get(2).obtenerPrecioVendido(), 0.1);
	}
	
	@Test
	public void obtenerProductosConDescuentoProductosSInSUperar100DeberaDevolverElPrecioSinDescuento(){
		Producto p22 = new Producto("P22", 22);
		Producto p50 = new Producto("P50", 50);
		Producto p80 = new Producto("P80", 80);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(p80);
		productos.add(p22);
		productos.add(p50);
		
		BeneficioDosPorUno beneficio = new BeneficioDosPorUno("2x1", TipoDeTarjeta.CLASSIC);
		
		List<ProductoVendido> resultado = beneficio.obtenerProductosConDescuento(productos);
		
		Assert.assertEquals(3, resultado.size());
		Assert.assertEquals(22, resultado.get(0).obtenerPrecioVendido(), 0.1);
		Assert.assertEquals(50, resultado.get(1).obtenerPrecioVendido(), 0.1);
		Assert.assertEquals(80, resultado.get(2).obtenerPrecioVendido(), 0.1);
	}
	
	@Test
	public void obtenerNombreDeberiaDevolverElNombre(){
		BeneficioDosPorUno beneficio = new BeneficioDosPorUno("2x1", TipoDeTarjeta.CLASSIC);
		
		String nombre = beneficio.obtenerNombre();
		
		Assert.assertEquals("2x1", nombre);
	}
}
