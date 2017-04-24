package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CreadorDeArchivoTest {

	@After
	public void destruir(){
		File file = new File("./fileTest.txt");
		file.delete();
	}
	
	@Test
	public void crearArchivoYEscribirEnElOk() {
		CreadorDeArchivo target = new CreadorDeArchivo();
		
		target.crearArchivo("asd", "fileTest.txt");
		try {
			FileReader reder = new FileReader("fileTest.txt");
			BufferedReader buffReader = new BufferedReader(reder);
			
			String txt;
			while ((txt = buffReader.readLine()) != null) {
				Assert.assertEquals("asd", txt);
			}
			
			buffReader.close();
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
}
