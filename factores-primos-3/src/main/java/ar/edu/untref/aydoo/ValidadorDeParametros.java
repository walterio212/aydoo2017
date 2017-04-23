package ar.edu.untref.aydoo;

public class ValidadorDeParametros {

	public void validarParametrosNoVacio(String[] args) {

		if (args.length == 0) {
			throw new IllegalArgumentException("No se encontraron parametros");
		}
	}

	public void validarNumero(String numero) {

		try {
			Integer.parseInt(numero);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("El primer parametro enviado no es un número natural");
		}
	}

	public void validarParametroFormat(String format){
		String formato = format.toLowerCase();

		if (!formato.equals("quiet") && !formato.equals("pretty")) {
			throw new IllegalArgumentException("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
		}
	}

	public void validarParametroSort(String sort){
		String formato = sort.toLowerCase();

		if (!formato.equals("asc") && !formato.equals("des")) {
			throw new IllegalArgumentException("Formato no aceptado. Las opciones posibles son: asc o des.");
		}
	}

	public void validarParametroOutputFile(String outputFile){
		String formato = outputFile.toLowerCase();

		if (!formato.endsWith(".txt")) {
			throw new IllegalArgumentException("Formato no aceptado. El archivo especificado deberia ser .txt");
		}
	}
}
