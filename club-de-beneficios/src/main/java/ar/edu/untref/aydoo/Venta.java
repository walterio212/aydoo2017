package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
	private LocalDate fechaDeVenta;
	private List<ProductoVendido> productosVendidos;
	private Cliente cliente;
	private Beneficio beneficioAplicado;
	private Establecimiento establecimiento;

	public Venta(LocalDate fechaVenta, Cliente cliente, List<Producto> productos, Establecimiento establecimiento) {
		this.fechaDeVenta = fechaVenta;
		this.cliente = cliente;
		this.establecimiento = establecimiento;
		this.agregarProductosVendidos(productos, establecimiento.obtenerBeneficios());
	}

	public LocalDate obtenerFechaDeVenta() {
		return this.fechaDeVenta;
	}

	private void agregarProductosVendidos(List<Producto> productos, List<Beneficio> beneficios) {
		Tarjeta tarjeta = this.cliente.obtenerTarjeta();
		Beneficio beneficio = obtenerBeneficio(tarjeta.obtenerTipoDeTarjeta(), beneficios);
		this.beneficioAplicado = beneficio;

		if (beneficio == null) {
			productosVendidos = obtenerProductosVendidosSinBeneficios(productos);
		}
		else{
			productosVendidos = beneficio.obtenerProductosConDescuento(productos);
		}
	}
	
	private Beneficio obtenerBeneficio(TipoDeTarjeta tipo, List<Beneficio> beneficios) {
		Beneficio beneficio = null;
		
		for (int i = 0; i < beneficios.size(); i++){
			if(tipo == beneficios.get(i).obtenerTipoDeTarjeta()){
				beneficio = beneficios.get(i);
			}
		}
		
		return beneficio;
	}
	
	private List<ProductoVendido> obtenerProductosVendidosSinBeneficios(List<Producto> productos){
		List<ProductoVendido> productosResult = new ArrayList<ProductoVendido>();
		
		for (int i = 0; i < productos.size(); i++) {
			ProductoVendido nuevo = new ProductoVendido(productos.get(i), productos.get(i).obtenerPrecio());
			productosResult.add(nuevo);
		}
		
		return productosResult;
	}

	public Cliente obtenerCliente() {
		return this.cliente;
	}
}
