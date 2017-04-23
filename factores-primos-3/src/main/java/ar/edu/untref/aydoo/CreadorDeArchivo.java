package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreadorDeArchivo {

	public void crearArchivo(String contenido, String nombreArchivo) {
		File file = new File("./" + nombreArchivo);
		if (!file.exists()) {
			try {
				file.createNewFile();
				this.escribirArchivo(file, contenido);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void escribirArchivo(File file, String contenido) throws IOException {
		FileWriter fileWriter = new FileWriter(file.getName(), true);
		BufferedWriter buffWriter = new BufferedWriter(fileWriter);

		buffWriter.write(contenido);
		buffWriter.close();
	}
}
