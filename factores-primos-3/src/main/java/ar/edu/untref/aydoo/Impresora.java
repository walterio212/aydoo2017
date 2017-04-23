package ar.edu.untref.aydoo;

public class Impresora {

	public void imprimir(int[] array, String format, String sort) {
		ConstructorDeTexto constructor = new ConstructorDeTexto();
		String texto = constructor.construir(array, format, sort);
		System.out.print(texto);
	}
}
