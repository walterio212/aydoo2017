package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

	private String nombre;
	private List<Sucursal> sucursales;
	private List<Beneficio> beneficios;

	public Establecimiento(String nombre, List<Sucursal> sucursalesEstablecimiento, List<Beneficio> beneficios) {
		this.nombre = nombre;
		this.beneficios = beneficios;
		this.sucursales = sucursalesEstablecimiento;
		this.asignarEstablecimientoASucursales(this.sucursales);
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
	
	public List<Venta> obtenerVentas(Month month) {
		List<Venta> ventas = new ArrayList<Venta>();

		for (int i = 0; i < sucursales.size(); i++) {
			ventas.addAll(sucursales.get(i).obtenerVentas(month));
		}

		return ventas;
	}
	
	private void asignarEstablecimientoASucursales(List<Sucursal> sucursalesEstablecimiento){
		for (int i = 0; i < sucursalesEstablecimiento.size(); i++) {
			Sucursal actual = sucursalesEstablecimiento.get(i);
			actual.asignarEstablecimiento(this);
		}
	}

	public List<Beneficio> obtenerBeneficios() {
		return this.beneficios;
	}
}
