package ar.edu.untref.aydoo;

public class ValidadorDeParametros {

	public String[] validarYDevolverFormateado(String[] args) {

		String[] resultado = new String[2];

		validar(args);

		resultado[0] = args[0];
		resultado[1] = "";

		if (args.length >= 2) {
			String formato = ObtenerFormato(args[1]);
			resultado[1] = formato.toLowerCase();
		}

		return resultado;
	}

	private void validar(String[] args) {

		if (args.length == 0) {
			throw new IllegalArgumentException("No se encontraron parametros");
		}

		validarNumero(args[0]);

		if (args.length >= 2){ 
			validarParametroFormat(args[1]);
		}
	}

	private void validarNumero(String numero) {

		try {
			Integer.parseInt(numero);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("El primer parametro enviado no es un número natural");
		}
	}
	
	private void validarParametroFormat(String format){
		//--format=quiet; --format=pretty;
		if (!format.startsWith("--format=")) {
			throw new IllegalArgumentException("La entrada del parametro format es invalida. Deberia ser --format=");			
		}

		String formato = ObtenerFormato(format).toLowerCase();

		if (!formato.equals("quiet") && !formato.equals("pretty")) {
			throw new IllegalArgumentException("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
		}
	}

	private String ObtenerFormato(String format) {
		return format.substring(9, format.length());
	}
}
