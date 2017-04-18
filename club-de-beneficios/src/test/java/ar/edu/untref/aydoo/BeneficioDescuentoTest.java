package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BeneficioDescuentoTest {
	
	@Test
	public void crearBeneficioCoPorcentajeMenorA5Error(){
		try {
			Beneficio ben = new BeneficioDescuento("1", 1, TipoDeTarjeta.CLASSIC);
		}catch(IllegalArgumentException e) {
			Assert.assertEquals("El porcentaje del descuento debe ser mayor a 5", e.getMessage());
		}
	}
	
	@Test
	public void obtenerProductosConDescuentoDeberiaDescontarATodosLosProductos(){
		Beneficio ben = new BeneficioDescuento("10", 10, TipoDeTarjeta.CLASSIC);
		
		Producto p1 = new Producto("P1", 100);
		Producto p2 = new Producto("P2", 300);
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(p1);
		productos.add(p2);
		
		List<ProductoVendido> productosResult = ben.obtenerProductosConDescuento(productos);
		
		Assert.assertEquals(2, productosResult.size());
		Assert.assertEquals(90, productosResult.get(0).obtenerPrecioVendido(), 0.1);
		Assert.assertEquals(270, productosResult.get(1).obtenerPrecioVendido(), 0.1);
	}
}
