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
	public void validarNumeroPasandoStringConNumeroMayorA0NoLanzaError(){
		validador.validarNumero("12");
	}
	
	@Test
	public void validarNumeroPasandoStringQueNoesNumeroMayorA0LanzaError(){
		
		try {
			validador.validarNumero("asd");
		}
		catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			
			Assert.assertEquals("El primer parametro enviado no es un número natural", mensaje);
		}
	}
	
	@Test
	public void ValidarArrayVacioDeberiaLanzarError(){
		String [] array = new String[0];
		
		try{
			validador.validarParametrosNoVacio(array);
			Assert.fail("Ocurrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			
			Assert.assertEquals("No se encontraron parametros", mensaje);
		}
	}

	@Test
	public void ValidarParametroFormatNoValidoDeberiaLanzarError(){
		
		try{
			validador.validarParametroFormat("yerba");
			Assert.fail("Ocrrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", mensaje);
		}		
	}
	
	@Test
	public void validarParametroFormatOk(){
		validador.validarParametroFormat("pretty");		
	}
	
	@Test
	public void ValidarFormatoPrettyNoCaseSensitiveCorrecto(){
		validador.validarParametroFormat("pREtTy");		
	}
	
	@Test
	public void ValidarFormatoQuietNoCaseSensitiveCorrecto(){
		validador.validarParametroFormat("quiet");		
	}
	
	@Test
	public void ValidarParametroAscCorrecto(){
		validador.validarParametroSort("asc");		
	}
	
	@Test
	public void ValidarParametroDesCorrecto(){
		validador.validarParametroSort("des");		
	}
	
	@Test
	public void ValidarParametroNoVacioConArrayConValoresCorrecto(){
		String[] array = new String[2];
		array[0] = "asd";
		array[1] = "oqwi";
			
		validador.validarParametrosNoVacio(array);		
	}
	
	@Test
	public void ValidarParametroSortNoValidoDeberiaLanzarError(){
		
		try{
			validador.validarParametroSort("asddd");
			Assert.fail("Ocrrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			Assert.assertEquals("Formato no aceptado. Las opciones posibles son: asc o des.", mensaje);
		}		
	}
	
	@Test
	public void ValidarParametroOutputFileOk(){
		validador.validarParametroOutputFile("salida.txt");		
	}
	
	@Test
	public void ValidarParametroOutputFileNoValidoDeberiaLanzarError(){
		
		try{
			validador.validarParametroOutputFile("asddd");
			Assert.fail("Ocrrio un error");
		}catch(IllegalArgumentException e){
			String mensaje = e.getMessage();
			Assert.assertEquals("Formato no aceptado. El archivo especificado deberia ser .txt", mensaje);
		}		
	}
}
