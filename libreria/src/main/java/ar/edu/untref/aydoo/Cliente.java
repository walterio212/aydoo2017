package ar.edu.untref.aydoo;

//Tipo de Objeto: Entity
public class Cliente {
	
	private String nombre;
	private String direccion;
	
	public Cliente(String nombre, String direccion){
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public String obtenerDireccion(){
		return this.direccion;
	}
}
