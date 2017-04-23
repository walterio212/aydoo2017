package ar.edu.untref.aydoo;

public class ConstructorDeTexto {

	public String construir(int[] array, String format, String sort) {
		String texto = "";
		ordenarArray(array, sort);

		if (format.toLowerCase().equals("quiet")) {
			String newLine = "\n";
			texto += newLine;

			 //System.getProperty("line.separator");
			for (int i = 0; i < array.length; i++) {
	        	texto += array[i] + newLine;
	    	}
		}
		else {
			for (int i = 0; i < array.length; i++) {
				texto += array[i] + " ";
	    	}
		}

		return texto;
	}

	private void ordenarArray(int[] array, String sort) {

		if (sort.equals("des")) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length - 1; j++) {
					if (array[j] < array[j + 1]) {
						int tmp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = tmp;
					}
				}
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length - 1; j++) {
					if (array[j] > array[j + 1]) {
						int tmp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = tmp;
					}
				}
			}
		}
	}
}
