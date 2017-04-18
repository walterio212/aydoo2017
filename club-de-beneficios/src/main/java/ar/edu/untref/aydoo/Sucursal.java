package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private String nombre;
    private Establecimiento establecimiento;
    private List<Venta> ventas;

	public Sucursal(String nombre) {
		this.nombre = nombre;
		ventas = new ArrayList<Venta>();
	}

	public void vender(Cliente cliente, ArrayList<Producto> productos, LocalDate fechaDeVenta) {
		Venta venta = new Venta(fechaDeVenta, cliente, productos, this.establecimiento);
		this.ventas.add(venta);
	}

	public List<Venta> obtenerVentas(Month month) {
		List<Venta> ventasDelMes = new ArrayList<Venta>();

		for (int i = 0; i < this.ventas.size(); i++) {
			Venta actual = this.ventas.get(i);
			if (actual.obtenerFechaDeVenta().getMonth() == month) {
				ventasDelMes.add(actual);
			}
		}

		return ventasDelMes;
	}

	public void asignarEstablecimiento(Establecimiento establecimiento){
		this.establecimiento = establecimiento;
	}

	public Establecimiento obtenerEstablecimiento(){
		return this.establecimiento;
	}

	public Object obtenerNombre() {
		return this.nombre;
	}
}
