package ar.edu.untref.aydoo;

public class Impresora {

	public void imprimir(int[] array, String format){

		if(format.toLowerCase().equals("quiet")){
			
			String newLine = System.getProperty("line.separator");
			System.out.print(newLine);		
			for(int i = 0; i< array.length; i++) {
	        	System.out.print(array[i] + newLine);
	    	}
		}
		else{
			for(int i = 0; i< array.length; i++) {
				System.out.print(array[i] + " ");
	    	}
		}		
	}
}
