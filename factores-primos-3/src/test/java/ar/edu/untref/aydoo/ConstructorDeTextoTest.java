package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ConstructorDeTextoTest {

	@Test
	public void construirArrayFormatoPrettySortAscDeberiaDevolverUnStringConNumerosEnUnaLinea(){
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		
		ConstructorDeTexto constructor = new ConstructorDeTexto();
		String resultado = constructor.construir(array, "pretty", "asc");
		
		Assert.assertEquals("1 2 3 ", resultado);
	}
	
	@Test
	public void construirArrayFormatoPrettySortDescDeberiaDevolverUnStringConNumerosEnUnaLinea(){
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		
		ConstructorDeTexto constructor = new ConstructorDeTexto();
		String resultado = constructor.construir(array, "pretty", "des");
		
		Assert.assertEquals("3 2 1 ", resultado);
	}
	
	@Test
	public void construirArrayFormatoQuietSortAscDeberiaDevolverUnStringConNumerosConSaltosDeLinea(){
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		String saltoDeLinea = System.getProperty("line.separator");
		
		ConstructorDeTexto constructor = new ConstructorDeTexto();
		String resultado = constructor.construir(array, "quiet", "asc");
		
		Assert.assertEquals("1"+ saltoDeLinea + "2" + saltoDeLinea + "3" + saltoDeLinea, resultado);
	}
	
	@Test
	public void construirArrayFormatoQuietSortDescDeberiaDevolverUnStringConNumerosConSaltosDeLinea(){
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		String saltoDeLinea = System.getProperty("line.separator");
		
		ConstructorDeTexto constructor = new ConstructorDeTexto();
		String resultado = constructor.construir(array, "quiet", "des");
		
		Assert.assertEquals("3" + saltoDeLinea + "2" + saltoDeLinea +  "1" + saltoDeLinea, resultado);
	}
}
