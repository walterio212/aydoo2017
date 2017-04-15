package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class LibreriaTest {

	private Revista barcelonaSuscripcionAnual;
	private Revista elGraficoIndividual;
	private Libro elHobbit;
	private ArticuloDeLibreria lapicera;
	private Periodico pagina12;	
	
	@Before
	public void Inicializar(){
		this.barcelonaSuscripcionAnual = new Revista("Barcelona", 20, 2, true, false);
		this.elGraficoIndividual = new Revista("El Grafico", 30, 1, false, true);		
		this.elHobbit = new Libro("El Hobbit", 50);
		this.lapicera = new ArticuloDeLibreria("Lapicera", 5);
		this.pagina12 = new Periodico("Pagina 12", 12, 30, false, true);
	}
	
	@Test
	public void VenderUnLibroDosArtLibreriaYUnPeriodicoDeberiaDar92coma1(){
		Cliente cliente = new Cliente("Juan", "Direccion1");
		
		Libreria libreria = new Libreria();
		
		libreria.realizarVenta(cliente, Mes.Agosto, this.elHobbit, 1);
		libreria.realizarVenta(cliente, Mes.Agosto, this.lapicera, 2);
		libreria.realizarVenta(cliente, Mes.Agosto, this.elGraficoIndividual, 1);
		
		double precioAgosto = libreria.calcularMontoACobrar(cliente, Mes.Agosto);
		
		Assert.assertEquals(92.1, precioAgosto, 0.01);
	}
	
	@Test
	public void VenderSuscripcionAnualRevistaBArcelonaYPeriodicoDevuelve44(){
		Cliente cliente = new Cliente("Maria", "Direccion2");
		
		Libreria libreria = new Libreria();
		
		libreria.realizarVenta(cliente, Mes.Enero, this.barcelonaSuscripcionAnual, 1);
		libreria.realizarVenta(cliente, Mes.Enero, this.pagina12, 1);
		
		double precioEnero = libreria.calcularMontoACobrar(cliente, Mes.Enero);
		
		Assert.assertEquals(44, precioEnero, 0.01);
	}
}
