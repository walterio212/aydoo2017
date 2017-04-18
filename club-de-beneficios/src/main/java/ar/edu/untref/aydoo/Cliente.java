/**
 * @author walterd
 *
 */
package ar.edu.untref.aydoo;

/**
 * Objeto que representa a un Cliente.
 *
 */
public class Cliente {

	private String nombre;
	private Tarjeta tarjeta;

	public Cliente(String nombre) {
		this.nombre = nombre;		
	}

	public String obtenerNombre() {
		return this.nombre;
	}
	
	public Tarjeta obtenerTarjeta() {
		return this.tarjeta;
	}
}
