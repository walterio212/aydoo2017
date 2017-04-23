package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

public class ObtenedorDeParametros {
	
	private ValidadorDeParametros validador;
	
	public ObtenedorDeParametros() {
		this.validador = new ValidadorDeParametros();
	}

	public Map<String, String> obtener(String[] args) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("Numero", obtenerNumero(args));
		result.put("Format", obtenerFormat(args));
		result.put("Sort", obtenerSort(args));
		result.put("OutputFile", obtenerOuputFile(args));

		return result;
	}

	private String obtenerNumero(String[] args) {
		String numero = args[0];
		validador.validarNumero(numero);
		return numero;
	}

	private String obtenerFormat(String[] args) {
		String format = "";
		String formatParam = "--format=";

		for (int i = 1; i < args.length; i++) {
			String param = args[i];
			if (param.startsWith(formatParam)){
				format = param.substring(formatParam.length(), param.length());
				validador.validarParametroFormat(format);
			}
		}

		return format;
	}

	private String obtenerOuputFile(String[] args) {
		String outputFile = "";
		String formatParam = "--output-file=";

		for (int i = 1; i < args.length; i++) {
			String param = args[i];
			if (param.startsWith(formatParam)){
				outputFile = param.substring(formatParam.length(), param.length());
				validador.validarParametroOutputFile(outputFile);
			}
		}

		return outputFile;
	}

	private String obtenerSort(String[] args) {
		String sort = "";
		String formatParam = "--sort=";

		for (int i = 1; i < args.length; i++) {
			String param = args[i];
			if (param.startsWith(formatParam)){
				sort = param.substring(formatParam.length(), param.length());
				validador.validarParametroSort(sort);
			}
		}

		return sort;
	}
}