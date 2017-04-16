package ar.edu.untref.aydoo;

import java.util.List;

public class ClubDeBeneficios {

	private List<Establecimiento> establecimientos;

	public ClubDeBeneficios(List<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}

	public void otorgarTarjeta(Cliente clienteA, TipoDeTarjeta classic) {
		// TODO Auto-generated method stub
	}

	public Establecimiento obtenerEstablecimientoConMasBeneficiosOtorgados() {
		Establecimiento actual = null;

		for (int i = 0; i < establecimientos.size(); i++){
			if(actual == null || actual.obtenerTotalBeneficiosOtorgados() < establecimientos.get(i).obtenerTotalBeneficiosOtorgados()){
				actual = establecimientos.get(i);
			}
		}

		return actual;
	}

}
