package ar.edu.untref.aydoo;

public class Tarjeta {
	private TipoDeTarjeta tipoDeTarjeta;
	
	public Tarjeta(TipoDeTarjeta tipo) {
		this.tipoDeTarjeta = tipo;
	}

	public TipoDeTarjeta obtenerTipoDeTarjeta() {
		return this.tipoDeTarjeta;
	}
}
