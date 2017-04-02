package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class ValidadorDeParametrosTest {
	private ValidadorDeParametros validador;
	
	@Before
	public void Initialize(){
		validador = new ValidadorDeParametros();
	}
	
	@Test
	public void ValidarArrayVacioDeberiaLanzarError(){
		String [] array = new String[0];
		
		try{
			validador.validarYDevolverFormateado(array);
			Assert.fail("Ocurrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			
			Assert.assertEquals("No se encontraron parametros", mensaje);
		}
	}
	
	@Test
	public void ValidarArrayPrimerParametroNoNumericoDeberiaLanzarError(){
		String [] array = new String[1];
		array[0] = "asd";
		
		try{
			validador.validarYDevolverFormateado(array);
			Assert.fail("Ocurrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			
			Assert.assertEquals("El primer parametro enviado no es un número natural", mensaje);
		}
	}
	
	@Test
	public void ValidarArrayPrimerParametroNumericoDeberiaDevolver2Parametros(){
		String [] array = new String[1];
		array[0] = "12";
		
		String[] resultado = validador.validarYDevolverFormateado(array);
		
		Assert.assertEquals(2, resultado.length);
		Assert.assertEquals("12", resultado[0]);
		Assert.assertEquals("", resultado[1]);
	}
	
	@Test
	public void ValidarArrayPrimerParametroNumericoSegundoParametroConEntradaMalArmadaDeberiaLanzarError(){
		String [] array = new String[2];
		array[0] = "12";
		array[1] = "-format=12";
		try{
			validador.validarYDevolverFormateado(array);
			Assert.fail("Ocrrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			Assert.assertEquals("La entrada del parametro format es invalida. Deberia ser --format=", mensaje);
		}		
	}
	
	@Test
	public void ValidarArrayPrimerParametroNumericoSegundoParametroNoValidoLanzarError(){
		String [] array = new String[2];
		array[0] = "12";
		array[1] = "--format=yerba";
		try{
			validador.validarYDevolverFormateado(array);
			Assert.fail("Ocrrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", mensaje);
		}		
	}
	
	@Test
	public void ValidarPrimerParametroNumericoSegundoParametroRecortadoCorrectoDeberiaDevolverLos2Parametros(){
		String [] array = new String[2];
		array[0] = "12";
		array[1] = "--format=pretty";
		
		String[] resultado = validador.validarYDevolverFormateado(array);
		Assert.assertEquals(2, resultado.length);
		Assert.assertEquals("12", resultado[0]);
		Assert.assertEquals("pretty", resultado[1]);
	}
	
	@Test
	public void ValidarPrimerParametroNumericoSegundoParametroRecortadoNoCaseSensitiveCorrectoDeberiaDevolverLos2Parametros(){
		String [] array = new String[2];
		array[0] = "12";
		array[1] = "--format=pREtTy";
		
		String[] resultado = validador.validarYDevolverFormateado(array);
		Assert.assertEquals(2, resultado.length);
		Assert.assertEquals("12", resultado[0]);
		Assert.assertEquals("pretty", resultado[1]);
	}
}
