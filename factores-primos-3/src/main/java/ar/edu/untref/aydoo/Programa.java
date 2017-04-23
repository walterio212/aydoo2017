package ar.edu.untref.aydoo;

import java.util.Map;

public class Programa
{
    public static final void main(String arg[]) {
    	ObtenedorDeParametros obtenedorDeParametros = new ObtenedorDeParametros();
        ConstructorDeTexto constructorTxt = new ConstructorDeTexto();
    	CreadorDeArchivo creador = new CreadorDeArchivo();
    	Map<String, String> parametros;

    	try {
    		parametros = obtenedorDeParametros.obtener(arg);

    		int numeroIngresado = Integer.parseInt(parametros.get("Numero"));

    		CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
    		int[] factoresPrimos = calculador
    				.obtenerFactoresPrimos(numeroIngresado);

    		System.out
    		.print("Factores Primos de " + numeroIngresado + ": ");

    		String texto = constructorTxt.construir(factoresPrimos, parametros.get("Format"), parametros.get("Sort"));

    		System.out.print(texto);
    		if (!parametros.get("Format").equals("")) {
    			creador.crearArchivo(texto, parametros.get("OutputFile"));
    		}

    	}
    	catch (IllegalArgumentException e) {
    		System.err.println(e.getMessage());
    	}
    }
}
