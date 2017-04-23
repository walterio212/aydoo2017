package ar.edu.untref.aydoo;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ObtenedorDeParametrosTest {

	@Test
	public void ObtnerParametrosTodosLosParametrosDeberiaDevolverLosParametrosMapeados(){
		String[] args = new String[4];
		args[0] = "120";
		args[1] = "--format=pretty";
		args[2] = "--output-file=salida.txt";
		args[3] = "--sort=asc";
		
		ObtenedorDeParametros target = new ObtenedorDeParametros();
		
		Map<String, String> result = target.obtener(args);
		
		Assert.assertEquals("120", result.get("Numero"));
		Assert.assertEquals("pretty", result.get("Format"));
		Assert.assertEquals("asc", result.get("Sort"));
		Assert.assertEquals("salida.txt", result.get("OutputFile"));
	}
	
	@Test
	public void ObtnerParametrosSinOutPutFileDevuelveElRestoYdevuelveParamOutputFileVacio(){
		String[] args = new String[3];
		args[0] = "120";
		args[1] = "--format=pretty";
		args[2] = "--sort=asc";
		
		ObtenedorDeParametros target = new ObtenedorDeParametros();
		
		Map<String, String> result = target.obtener(args);
		
		Assert.assertEquals("120", result.get("Numero"));
		Assert.assertEquals("pretty", result.get("Format"));
		Assert.assertEquals("asc", result.get("Sort"));
		Assert.assertEquals("", result.get("OutputFile"));
	}	
}
