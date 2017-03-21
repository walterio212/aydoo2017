package ar.edu.untref.aydoo;

public class Program 
{
    public static final void main(String arg[])
    {
    	int numeroIngresado = Integer.parseInt(arg[0]);
        
    	CalculadorFactoresPrimos calculador = new CalculadorFactoresPrimos();
        int [] factoresPrimos = calculador.ObtenerFactoresPrimos(numeroIngresado);        
        
        System.out.print("Factores Primos de " + numeroIngresado + ": ");
        for(int i = 0; i< factoresPrimos.length; i++) {
        	System.out.print(factoresPrimos[i] + " ");
    	}
    }    
}
