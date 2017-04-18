package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BeneficioDosPorUno extends Beneficio{
	public BeneficioDosPorUno(String nombre, TipoDeTarjeta tipo) {
		super(nombre, tipo);
	}

	@Override
	public List<ProductoVendido> obtenerProductosConDescuento(List<Producto> productos) {
		List<ProductoVendido> productosResult = new ArrayList<ProductoVendido>();

		if (productos.size() == 1) {
			ProductoVendido producto = new ProductoVendido(productos.get(0), productos.get(0).obtenerPrecio());
			productosResult.add(producto);
		}

		if (productos.size() > 1) {
			productos.sort(new Comparator<Producto>() {
				public int compare(Producto p1, Producto p2) {
					double precioP1 = p1.obtenerPrecio();
					double precioP2 = p2.obtenerPrecio();
					return precioP1 < precioP2 ? -1 : precioP1 > precioP2 ? 1 : 0;
				}
			});

			Producto productoPrecioMasBajo= productos.get(0);
			Producto productoPrecioMasAlto = productos.get(productos.size() - 1);

			if(productoPrecioMasAlto.obtenerPrecio() >= 100){
				ProductoVendido productoPagoDosPorUno = new ProductoVendido(productoPrecioMasAlto, productoPrecioMasAlto.obtenerPrecio());
				ProductoVendido productoGratisDosPorUno = new ProductoVendido(productoPrecioMasBajo, 0);

				productosResult.add(productoPagoDosPorUno);
				productosResult.add(productoGratisDosPorUno);

				for (int i = 1; i < productos.size() - 1; i++){
					ProductoVendido actual = new ProductoVendido(productos.get(i), productos.get(i).obtenerPrecio());
					productosResult.add(actual);
				}
			}
			else {
				for (int i = 0; i < productos.size(); i++){
					ProductoVendido actual = new ProductoVendido(productos.get(i), productos.get(i).obtenerPrecio());
					productosResult.add(actual);
				}
			}
		}

		return productosResult;
	}
}
