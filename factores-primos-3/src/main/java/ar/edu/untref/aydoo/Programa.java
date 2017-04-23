package ar.edu.untref.aydoo;

public class Programa
{
    public static final void main(String arg[]) {
        ValidadorDeParametros validador = new ValidadorDeParametros();
    	Impresora impresora = new Impresora();
    	ConstructorDeTexto constructorTxt = new ConstructorDeTexto();
    	CreadorDeArchivo creador = new CreadorDeArchivo();
    	String[] parametros;

    	try {
    		parametros = validador.validarYDevolverFormateado(arg);

    		int numeroIngresado = Integer.parseInt(parametros[0]);

    		CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
    		int[] factoresPrimos = calculador
    				.obtenerFactoresPrimos(numeroIngresado);

    		System.out
    		.print("Factores Primos de " + numeroIngresado + ": ");

    		String texto = constructorTxt.construir(factoresPrimos, parametros[1], "asc");

    		System.out.print(texto);

    		creador.crearArchivo(texto, "salida.txt");

    	}
    	catch (IllegalArgumentException e) {
    		System.err.println(e.getMessage());
    	}
    }
}
