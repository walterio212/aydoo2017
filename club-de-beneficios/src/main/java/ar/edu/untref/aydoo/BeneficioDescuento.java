package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class BeneficioDescuento extends Beneficio {
	private double porcentaje;
	
	public BeneficioDescuento(String nombre, double porcentaje, TipoDeTarjeta tipo) {
		super(nombre, tipo);
		setPorcentaje(porcentaje);
	}

	@Override
	public List<ProductoVendido> obtenerProductosConDescuento(List<Producto> productos) {
		List<ProductoVendido> productosResult = new ArrayList<ProductoVendido>();

		for (int i = 0; i < productos.size(); i++){
			Producto actual = productos.get(i);
			double precioFinal = actual.obtenerPrecio() - (actual.obtenerPrecio() * porcentaje / 100);
			ProductoVendido nuevo = new ProductoVendido(actual, precioFinal);

			productosResult.add(nuevo);
		}

		return productosResult;
	}
	
	private void setPorcentaje(double porcentaje){
		if(porcentaje < 5){
			throw new IllegalArgumentException("El porcentaje del descuento debe ser mayor a 5");
		}
		this.porcentaje = porcentaje;
	}
}
