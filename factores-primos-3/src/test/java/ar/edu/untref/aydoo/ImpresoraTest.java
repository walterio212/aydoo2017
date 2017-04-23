package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;

public class ImpresoraTest {
	private Impresora impresora;
	private ByteArrayOutputStream consola;
	
	@Before
	public void Initialize(){
		consola = new ByteArrayOutputStream();
		impresora = new Impresora();
		
		System.setOut(new PrintStream(consola));
	}
	
	@After
	public void After(){
		System.setOut(null);
	}
	
	@Test
	public void ImprimirFormatoQuietDeberiaImprimirConSaltosDeLinea(){
		int[] array = new int[2];
		
		array[0] = 3;
		array[1] = 5;
		
		impresora.imprimir(array, "quiet");
		String salidaConsola = consola.toString();
		
		Assert.assertEquals("\n3\n5\n", salidaConsola);
	}
	
	@Test
	public void ImprimirFormatoPrettyDeberiaImprimirEnMismaLinea(){
		int[] array = new int[2];
		
		array[0] = 3;
		array[1] = 5;
		
		impresora.imprimir(array, "pretty");
		String salidaConsola = consola.toString();
		
		Assert.assertEquals("3 5 ", salidaConsola);
	}
	
	@Test
	public void ImprimirCualquierFormatoVacioDeberiaDevolverFormatoPretty(){
		int[] array = new int[2];
		
		array[0] = 3;
		array[1] = 5;
		
		impresora.imprimir(array, "");
		String salidaConsola = consola.toString();
		
		Assert.assertEquals("3 5 ", salidaConsola);
	}
}
