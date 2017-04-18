package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

	private List<Establecimiento> establecimientos;

	public ClubDeBeneficios(List<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}

	public void otorgarTarjeta(Cliente cliente, TipoDeTarjeta tipo) {
		cliente.asignarTarjeta(new Tarjeta(tipo));
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

	public List<ReporteDeAhorros> obtenerReportesDeAhorro(Month month){
		List<Venta> ventas = new ArrayList<Venta>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<ReporteDeAhorros> reporte = new ArrayList<ReporteDeAhorros>();
		
		for (int i = 0; i < this.establecimientos.size(); i++) {
			List<Venta> ventasEstablecimiento = this.establecimientos.get(i).obtenerVentas(month);
			ventas.addAll(ventasEstablecimiento);			
		}
		
		clientes = obtenerClientesEnVentas(ventas);
				
		for (int i = 0; i < clientes.size(); i++) {
			Cliente actual = clientes.get(i);
			List<Venta> ventasDelCliente = obtenerVentasDeCliente(ventas, actual);
			ReporteDeAhorros nuevo = new ReporteDeAhorros(actual, ventasDelCliente);
			reporte.add(nuevo);
		}
		
		return reporte;
	}
	
	private List<Venta> obtenerVentasDeCliente(List<Venta> ventas, Cliente cliente) {
		List<Venta> ventasDelCliente = new ArrayList<Venta>();
		
		for (int i = 0; i < ventas.size(); i++){
			if(ventas.get(i).obtenerCliente() == cliente){
				ventasDelCliente.add(ventas.get(i));
			}
		}

		return ventasDelCliente;
	}

	private List<Cliente> obtenerClientesEnVentas(List<Venta> ventas){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		for(int i = 0; i < ventas.size(); i++){
			if(!clientes.contains(ventas.get(i).obtenerCliente())) {
				clientes.add(ventas.get(i).obtenerCliente());
			}
		}
		
		return clientes;
	}

}
