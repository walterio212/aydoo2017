package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VentaTest {

	@Test
	public void obtenerClienteDeberiaDevolverElCLienteDeLaVenta(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		
		Venta venta = new Venta(LocalDate.of(2017, 2, 1) ,clienteA, productos, establecimientoA);
		
		Cliente result = venta.obtenerCliente();
		
		Assert.assertEquals(clienteA, result);
	}
	
	@Test
	public void obtenerFechaDeVentaDeberiaDevolverFechaDeLaVenta(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		LocalDate result = venta.obtenerFechaDeVenta();
		
		Assert.assertEquals(fecha, result);
	}
	
	@Test
	public void obtenerBeneficioAplicadoDeberiaDevolverBeneficioAplicadoEnLaVenta(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		BeneficioDescuento benPremium = new BeneficioDescuento("10 Porciento Premium", 10, TipoDeTarjeta.PREMIUM);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		beneficios.add(benPremium);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		Beneficio result = venta.obtenerBeneficioAplicado();
		
		Assert.assertEquals(ben, result);
	}
	
	@Test
	public void obtenerEstablecimientoDeberiaDevolverEstablecimientoEnQUeSeHizoLaVenta(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		BeneficioDescuento benPremium = new BeneficioDescuento("10 Porciento Premium", 10, TipoDeTarjeta.PREMIUM);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		beneficios.add(benPremium);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		Establecimiento result = venta.obtenerEstablecimiento();
		
		Assert.assertEquals(establecimientoA, result);
	}
	
	@Test
	public void obtenerBenficioCuandoNoAplicaParaClienteDeberiaDevolverNull(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		
		BeneficioDescuento benPremium = new BeneficioDescuento("10 Porciento Premium", 10, TipoDeTarjeta.PREMIUM);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(benPremium);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		Beneficio result = venta.obtenerBeneficioAplicado();
		
		Assert.assertNull(result);
	}
	
	@Test
	public void obtenerProductosVendidosDeberiaDevolverProductosVendidosAsociaadosAProductos(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		List<ProductoVendido> result = venta.obtenerProductosVendidos();
		
		Assert.assertEquals(1, result.size());
		Assert.assertEquals(pa, result.get(0).obtenerProducto());
		Assert.assertEquals(90, result.get(0).obtenerPrecioVendido(), 0.1);
	}
	
	@Test
	public void obtenerCostoTotalSinDescuentoSumaPrecioSinDEscuentoProductosVendidos(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		double result = venta.obtenerCostoTotalSinDescuento();
		
		Assert.assertEquals(100, result, 0.1);
	}
	
	@Test
	public void obtenerCostoTotalConDescuentoSumaPrecioConDEscuentoProductosVendidos(){
		Cliente clienteA = new Cliente("A");
		clienteA.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Sucursal sa = new Sucursal("SA");
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		sucursales.add(sa);
		
		BeneficioDescuento ben = new BeneficioDescuento("10 Porciento", 10, TipoDeTarjeta.CLASSIC);
		List<Beneficio> beneficios = new ArrayList<Beneficio>();
		beneficios.add(ben);
		Establecimiento establecimientoA = new Establecimiento("EstablecimientoA", sucursales, beneficios);
		Producto pa = new Producto("PA", 100);
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(pa);
		LocalDate fecha = LocalDate.of(2017, 2, 1);
		Venta venta = new Venta(fecha ,clienteA, productos, establecimientoA);
		
		double result = venta.obtenerCostoTotalConDescuento();
		
		Assert.assertEquals(90, result, 0.1);
	}
}
