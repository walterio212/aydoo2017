package ar.edu.untref.aydoo;

import java.time.LocalDate;

public class Venta {
	private LocalDate fechaDeVenta;

	public Venta(LocalDate fechaVenta) {
		this.fechaDeVenta = fechaVenta;
	}

	public LocalDate obtenerFechaDeVenta() {
		return this.fechaDeVenta;
	}
}
