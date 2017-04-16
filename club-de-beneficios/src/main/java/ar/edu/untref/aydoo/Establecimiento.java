package ar.edu.untref.aydoo;

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

	public Sucursal obtenerSucursalConMasBeneficiosOtorgados(){
		Sucursal actual = null;

		for(int i = 0; i < sucursales.size(); i++){
			if(actual == null || actual.obtenerVentas().size() < sucursales.get(i).obtenerVentas().size()){
				actual = sucursales.get(i);
			}
		}

		return actual;
	}

	public int obtenerTotalBeneficiosOtorgados() {
		int total = 0;

		for (int i = 0; i < sucursales.size(); i++) {
			total += sucursales.get(i).obtenerVentas().size();
		}

		return total;
	}
}
