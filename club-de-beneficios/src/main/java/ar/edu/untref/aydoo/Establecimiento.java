package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.List;

public class Establecimiento {

	private String nombre;
	private List<Sucursal> sucursales;

	public Establecimiento(String nombre, List<Sucursal> sucursalesEstablecimientoAzul, List<Beneficio> beneficiosPorcentajesAltos) {
		this.nombre = nombre;
		this.sucursales = sucursalesEstablecimientoAzul;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public Sucursal obtenerSucursalConMasBeneficiosOtorgados(Month month) {
		Sucursal actual = null;

		for (int i = 0; i < sucursales.size(); i++) {
			if (actual == null || actual.obtenerVentas(month).size() < sucursales.get(i).obtenerVentas(month).size()) {
				actual = sucursales.get(i);
			}
		}

		return actual;
	}

	public int obtenerTotalBeneficiosOtorgados(Month month) {
		int total = 0;

		for (int i = 0; i < sucursales.size(); i++) {
			total += sucursales.get(i).obtenerVentas(month).size();
		}

		return total;
	}
}
