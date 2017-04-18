package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.List;

public class ClubDeBeneficios {

	private List<Establecimiento> establecimientos;

	public ClubDeBeneficios(List<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}

	public void otorgarTarjeta(Cliente clienteA, TipoDeTarjeta classic) {
		// TODO Auto-generated method stub
	}

	public Establecimiento obtenerEstablecimientoConMasBeneficiosOtorgados(Month month) {
		Establecimiento actual = null;

		for (int i = 0; i < establecimientos.size(); i++) {
			if (actual == null || actual.obtenerTotalBeneficiosOtorgados(month) < establecimientos.get(i).obtenerTotalBeneficiosOtorgados(month)) {
				actual = establecimientos.get(i);
			}
		}

		return actual;
	}

	public Sucursal obtenerSucursalConMasBeneficiosOtorgados(Month month) {
		Sucursal actual = null;

		for (int i = 0; i < establecimientos.size(); i++) {
			Establecimiento establecimientoActual = establecimientos.get(i);

			if (actual == null || actual.obtenerVentas(month).size() < establecimientoActual.obtenerSucursalConMasBeneficiosOtorgados(month).obtenerVentas(month).size()) {
				actual = establecimientoActual.obtenerSucursalConMasBeneficiosOtorgados(month);
			}
		}

		return actual;
	}

}
