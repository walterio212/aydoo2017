package ar.edu.untref.aydoo;

public class Programa 
{
    public static final void main(String arg[])
    {
    	ValidadorDeParametros validador = new ValidadorDeParametros();
    	Impresora impresora = new Impresora();
    	String[] parametros;
    	
    	try{
    		parametros = validador.validarYDevolverFormateado(arg);
    		
    		int numeroIngresado = Integer.parseInt(parametros[0]);
        
    		CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
    		int[] factoresPrimos = calculador.ObtenerFactoresPrimos(numeroIngresado);        
    		
    		System.out.print("Factores Primos de " + numeroIngresado + ": ");
    		
    		impresora.imprimir(factoresPrimos, parametros[1]);  		
    	}
    	catch(IllegalArgumentException e){
    		System.err.println(e.getMessage());
    	}    	
    }
}
