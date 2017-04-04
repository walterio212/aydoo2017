package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class ClienteTest {

	@Test
	public void obtenerNombreDeberiaDevlverElNombre(){
		Cliente cliente = new Cliente("Juan", "Direccion1");
		
		String nombre = cliente.obtenerNombre();
		
		Assert.assertEquals("Juan", nombre);
	}
	
	@Test
	public void obtenerDireccionDeberiaDevlverLaDireccion(){
		Cliente cliente = new Cliente("Maria", "Direccion2");
		
		String direccion = cliente.obtenerDireccion();
		
		Assert.assertEquals("Direccion2", direccion);
	}
}
