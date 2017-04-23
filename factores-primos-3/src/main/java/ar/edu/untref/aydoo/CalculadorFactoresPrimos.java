package ar.edu.untref.aydoo;

public class CalculadorFactoresPrimos {

    public int[] obtenerFactoresPrimos(int numero) {

    	int divisor = 2;
    	int[] factoresPrimos = new int[0];

    	while (divisor <= numero) {
    		if (numero % divisor == 0) {
    			int[] aux = factoresPrimos;
    			numero = numero / divisor;
    			factoresPrimos = new int[aux.length + 1];

    			for (int j = 0; j < aux.length; j++) {
    				factoresPrimos[j] = aux[j];
    	        }

    			factoresPrimos[aux.length] = divisor;
    		} else {
                divisor++;
            }
    	}
    	return factoresPrimos;
    }
}
