package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {
	
	@Test
	public void obtenerEstablecimientoConMasBeneficiosDeberiaDevolverAquelQueVEndioMasBeneficios(){
		
		Beneficio beneficio10PorcientoClassic = new Beneficio("10 porciento de descuento CLASSIC", 10, TipoDeTarjeta.CLASSIC);
		Beneficio beneficio30PorcientoPremium = new Beneficio("30 porciento de descuento PREMIUM", 30, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoPremium = new Beneficio("50 porciento de descuento PREMIUM", 50, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoClassic = new Beneficio("50 porciento de descuento CLASSIC", 50, TipoDeTarjeta.CLASSIC);
		
		ArrayList<Beneficio> beneficiosPorcentajesBajos = new ArrayList<Beneficio>();
		beneficiosPorcentajesBajos.add(beneficio10PorcientoClassic);
		beneficiosPorcentajesBajos.add(beneficio30PorcientoPremium);
		
		ArrayList<Beneficio> beneficiosPorcentajesAltos = new ArrayList<Beneficio>();
		beneficiosPorcentajesAltos.add(beneficio50PorcientoPremium);
		beneficiosPorcentajesAltos.add(beneficio50PorcientoClassic);
		
		Sucursal sucursalRojaA = new Sucursal("SRA");
		Sucursal sucursalRojaB = new Sucursal("SRB");
				
		ArrayList<Sucursal> sucursalesEstablecimientoRojo = new ArrayList<Sucursal>();
		sucursalesEstablecimientoRojo.add(sucursalRojaA);
		sucursalesEstablecimientoRojo.add(sucursalRojaB);

		Sucursal sucursalAzulA = new Sucursal("SAA");
		Sucursal sucursalAzulB = new Sucursal("SAB");
		
		ArrayList<Sucursal> sucursalesEstablecimientoAzul = new ArrayList<Sucursal>();
		
		sucursalesEstablecimientoAzul.add(sucursalAzulA);
		sucursalesEstablecimientoAzul.add(sucursalAzulB);
		
		Establecimiento establecimientoRojo = new Establecimiento("EstablecimientoRojo", sucursalesEstablecimientoRojo, beneficiosPorcentajesBajos);
		Establecimiento establecimientoAzul = new Establecimiento("EstablecimientoAzul", sucursalesEstablecimientoAzul, beneficiosPorcentajesAltos);
		
		ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
		establecimientos.add(establecimientoRojo);
		establecimientos.add(establecimientoAzul);
		
		Cliente clienteA = new Cliente("A");
		Cliente clienteB = new Cliente("B");
		
		Producto productoA = new Producto("ProductoA", 20);
		Producto productoB = new Producto("ProductoB", 50);
		
		ArrayList<Producto> productosClienteA = new ArrayList<Producto>();
		productosClienteA.add(productoA);
		productosClienteA.add(productoB);
		
		ArrayList<Producto> productosClienteB = new ArrayList<Producto>();
		productosClienteB.add(productoA);
		
		ClubDeBeneficios club = new ClubDeBeneficios(establecimientos);
		club.otorgarTarjeta(clienteA, TipoDeTarjeta.CLASSIC);
		club.otorgarTarjeta(clienteB, TipoDeTarjeta.PREMIUM);
		
		sucursalRojaA.vender(clienteA, productosClienteA, LocalDate.of(2017, 2, 1));
		sucursalRojaA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		
		Establecimiento establecimientoConMasBeneficios = club.obtenerEstablecimientoConMasBeneficiosOtorgados(Month.FEBRUARY);
		
		Assert.assertEquals("EstablecimientoRojo", establecimientoConMasBeneficios.obtenerNombre());
	}
	
	@Test
	public void obtenerSucursalConMasBeneficiosDeberiaDevolverAquelQueVendioMasBeneficios(){
		
		Beneficio beneficio10PorcientoClassic = new Beneficio("10 porciento de descuento CLASSIC", 10, TipoDeTarjeta.CLASSIC);
		Beneficio beneficio30PorcientoPremium = new Beneficio("30 porciento de descuento PREMIUM", 30, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoPremium = new Beneficio("50 porciento de descuento PREMIUM", 50, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoClassic = new Beneficio("50 porciento de descuento CLASSIC", 50, TipoDeTarjeta.CLASSIC);
		
		ArrayList<Beneficio> beneficiosPorcentajesBajos = new ArrayList<Beneficio>();
		beneficiosPorcentajesBajos.add(beneficio10PorcientoClassic);
		beneficiosPorcentajesBajos.add(beneficio30PorcientoPremium);
		
		ArrayList<Beneficio> beneficiosPorcentajesAltos = new ArrayList<Beneficio>();
		beneficiosPorcentajesAltos.add(beneficio50PorcientoPremium);
		beneficiosPorcentajesAltos.add(beneficio50PorcientoClassic);
		
		Sucursal sucursalRojaA = new Sucursal("SRA");
		Sucursal sucursalRojaB = new Sucursal("SRB");
				
		ArrayList<Sucursal> sucursalesEstablecimientoRojo = new ArrayList<Sucursal>();
		sucursalesEstablecimientoRojo.add(sucursalRojaA);
		sucursalesEstablecimientoRojo.add(sucursalRojaB);

		Sucursal sucursalAzulA = new Sucursal("SAA");
		Sucursal sucursalAzulB = new Sucursal("SAB");
		
		ArrayList<Sucursal> sucursalesEstablecimientoAzul = new ArrayList<Sucursal>();
		
		sucursalesEstablecimientoAzul.add(sucursalAzulA);
		sucursalesEstablecimientoAzul.add(sucursalAzulB);
		
		Establecimiento establecimientoRojo = new Establecimiento("EstablecimientoRojo", sucursalesEstablecimientoRojo, beneficiosPorcentajesBajos);
		Establecimiento establecimientoAzul = new Establecimiento("EstablecimientoAzul", sucursalesEstablecimientoAzul, beneficiosPorcentajesAltos);
		
		ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
		establecimientos.add(establecimientoRojo);
		establecimientos.add(establecimientoAzul);
		
		Cliente clienteA = new Cliente("A");
		Cliente clienteB = new Cliente("B");
		
		Producto productoA = new Producto("ProductoA", 20);
		Producto productoB = new Producto("ProductoB", 50);
		
		ArrayList<Producto> productosClienteA = new ArrayList<Producto>();
		productosClienteA.add(productoA);
		productosClienteA.add(productoB);
		
		ArrayList<Producto> productosClienteB = new ArrayList<Producto>();
		productosClienteB.add(productoA);
		
		ClubDeBeneficios club = new ClubDeBeneficios(establecimientos);
		club.otorgarTarjeta(clienteA, TipoDeTarjeta.CLASSIC);
		club.otorgarTarjeta(clienteB, TipoDeTarjeta.PREMIUM);
		
		sucursalRojaA.vender(clienteA, productosClienteA, LocalDate.of(2017, 2, 1));
		sucursalRojaA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		
		Sucursal sucursalConMasBeneficios = club.obtenerSucursalConMasBeneficiosOtorgados(Month.FEBRUARY);
		
		Assert.assertEquals("SRA", sucursalConMasBeneficios.obtenerNombre());
	}
}
