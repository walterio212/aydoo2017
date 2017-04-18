package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Beneficio {

	private TipoDeTarjeta tipo;
	private String nombre;

	public Beneficio(String nombre, TipoDeTarjeta tipo) {
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public TipoDeTarjeta obtenerTipoDeTarjeta(){
		return this.tipo;
	}

	public String obtenerNombre(){
		return this.nombre;
	}

	public abstract List<ProductoVendido> obtenerProductosConDescuento(List<Producto> productos);

}
