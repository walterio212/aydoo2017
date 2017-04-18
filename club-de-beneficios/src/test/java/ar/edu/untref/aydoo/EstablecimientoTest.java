package ar.edu.untref.aydoo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class EstablecimientoTest {

	@Test
	public void obtenerSucursalConMasBeneficiosOtorgadosDeberiaDevolverSucursaleConMayorCantidadDeVentas(){
		Beneficio beneficio10PorcientoClassic = new BeneficioDescuento("10 porciento de descuento CLASSIC", 10, TipoDeTarjeta.CLASSIC);
		Beneficio beneficio30PorcientoPremium = new BeneficioDescuento("30 porciento de descuento PREMIUM", 30, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoPremium = new BeneficioDescuento("50 porciento de descuento PREMIUM", 50, TipoDeTarjeta.PREMIUM);
		Beneficio beneficio50PorcientoClassic = new BeneficioDescuento("50 porciento de descuento CLASSIC", 50, TipoDeTarjeta.CLASSIC);
		
		ArrayList<Beneficio> beneficiosPorcentajesBajos = new ArrayList<Beneficio>();
		beneficiosPorcentajesBajos.add(beneficio10PorcientoClassic);
		beneficiosPorcentajesBajos.add(beneficio30PorcientoPremium);
		
		ArrayList<Beneficio> beneficiosPorcentajesAltos = new ArrayList<Beneficio>();
		beneficiosPorcentajesAltos.add(beneficio50PorcientoPremium);
		beneficiosPorcentajesAltos.add(beneficio50PorcientoClassic);
		
		Sucursal sucursalAzulA = new Sucursal("SAA");
		Sucursal sucursalAzulB = new Sucursal("SAB");
		
		ArrayList<Sucursal> sucursalesEstablecimientoAzul = new ArrayList<Sucursal>();
		
		sucursalesEstablecimientoAzul.add(sucursalAzulA);
		sucursalesEstablecimientoAzul.add(sucursalAzulB);
		
		Establecimiento establecimientoAzul = new Establecimiento("EstablecimientoAzul", sucursalesEstablecimientoAzul, beneficiosPorcentajesBajos);
		
		Cliente clienteB = new Cliente("B");
		clienteB.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		
		Producto productoA = new Producto("ProductoA", 20);
				
		ArrayList<Producto> productosClienteB = new ArrayList<Producto>();
		productosClienteB.add(productoA);
				
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulB.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		sucursalAzulB.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		
		Sucursal sucursalConMasBeneficios = establecimientoAzul.obtenerSucursalConMasBeneficiosOtorgados(Month.FEBRUARY);
		
		Assert.assertEquals("SAA", sucursalConMasBeneficios.obtenerNombre());
	}
	
	@Test
	public void obtenerTotalBeneficiosOtorgadosDeberiaDevolverLaSumaDeVentasDeLasSucursales(){
		Beneficio beneficio10PorcientoClassic = new BeneficioDescuento("10 porciento de descuento CLASSIC", 10, TipoDeTarjeta.CLASSIC);
		Beneficio beneficio30PorcientoPremium = new BeneficioDescuento("30 porciento de descuento PREMIUM", 30, TipoDeTarjeta.PREMIUM);
		
		ArrayList<Beneficio> beneficiosPorcentajesBajos = new ArrayList<Beneficio>();
		beneficiosPorcentajesBajos.add(beneficio10PorcientoClassic);
		beneficiosPorcentajesBajos.add(beneficio30PorcientoPremium);
		
		Sucursal sucursalAzulA = new Sucursal("SAA");
		Sucursal sucursalAzulB = new Sucursal("SAB");
		
		ArrayList<Sucursal> sucursalesEstablecimientoAzul = new ArrayList<Sucursal>();
		
		sucursalesEstablecimientoAzul.add(sucursalAzulA);
		sucursalesEstablecimientoAzul.add(sucursalAzulB);
		
		Establecimiento establecimientoAzul = new Establecimiento("EstablecimientoAzul", sucursalesEstablecimientoAzul, beneficiosPorcentajesBajos);
		
		Cliente clienteB = new Cliente("B");
		clienteB.asignarTarjeta(new Tarjeta(TipoDeTarjeta.CLASSIC));
		Producto productoA = new Producto("ProductoA", 20);
				
		ArrayList<Producto> productosClienteB = new ArrayList<Producto>();
		productosClienteB.add(productoA);
				
		sucursalAzulA.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulB.vender(clienteB, productosClienteB, LocalDate.of(2017, 2, 1));
		sucursalAzulB.vender(clienteB, productosClienteB, LocalDate.of(2017, 3, 1));
		
		int totalBeneficiosOtorgados = establecimientoAzul.obtenerTotalBeneficiosOtorgados(Month.FEBRUARY);
		
		Assert.assertEquals(2, totalBeneficiosOtorgados);
	}
	
	@Test
	public void obtenerBeneficiosDeberiaDevolverBeneficiosDelEstablecimiento(){
		Beneficio beneficio10PorcientoClassic = new BeneficioDescuento("10 porciento de descuento CLASSIC", 10, TipoDeTarjeta.CLASSIC);
		Beneficio beneficio30PorcientoPremium = new BeneficioDescuento("30 porciento de descuento PREMIUM", 30, TipoDeTarjeta.PREMIUM);
		
		ArrayList<Beneficio> beneficiosPorcentajesBajos = new ArrayList<Beneficio>();
		beneficiosPorcentajesBajos.add(beneficio10PorcientoClassic);
		beneficiosPorcentajesBajos.add(beneficio30PorcientoPremium);
		
		Sucursal sucursalAzulA = new Sucursal("SAA");
		Sucursal sucursalAzulB = new Sucursal("SAB");
		
		ArrayList<Sucursal> sucursalesEstablecimientoAzul = new ArrayList<Sucursal>();
		
		sucursalesEstablecimientoAzul.add(sucursalAzulA);
		sucursalesEstablecimientoAzul.add(sucursalAzulB);
		
		Establecimiento establecimientoAzul = new Establecimiento("EstablecimientoAzul", sucursalesEstablecimientoAzul, beneficiosPorcentajesBajos);
				
		List<Beneficio> beneficios = establecimientoAzul.obtenerBeneficios();
		
		Assert.assertEquals(2, beneficios.size());
		Assert.assertEquals(beneficio10PorcientoClassic, beneficios.get(0));
		Assert.assertEquals(beneficio30PorcientoPremium, beneficios.get(1));
	}
}
