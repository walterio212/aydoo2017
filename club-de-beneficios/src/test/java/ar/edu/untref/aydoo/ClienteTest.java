package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class ClienteTest {

	@Test
	public void obtenerNombreDeberiaRetornarElNombre(){
		Cliente cliente = new Cliente("Cliente1");
		
		String nombre = cliente.obtenerNombre();
		
		Assert.assertEquals("Cliente1", nombre);
	}
}
