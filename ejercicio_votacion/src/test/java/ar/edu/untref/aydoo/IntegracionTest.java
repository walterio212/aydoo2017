package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

public class IntegracionTest {

	@Test
    public void sumarVotoCandidatosOk()
    {
		ArrayList<Candidato> candidatos = new ArrayList<>();
		ArrayList<Provincia> provincias = new ArrayList<>();
		ArrayList<Partido> partidos = new ArrayList<>();
		
		Provincia provinciaA = new Provincia("ProvinciaA");
		Provincia provinciaB = new Provincia("ProvinciaB");
		Provincia provinciaC = new Provincia("ProvinciaC");
		Provincia provinciaD = new Provincia("ProvinciaD");
		
		provincias.add(provinciaA);
		provincias.add(provinciaB);
		provincias.add(provinciaC);
		provincias.add(provinciaD);
		
		Partido partidoRojo = new Partido("Rojo");
		Partido partidoAzul = new Partido("Azul");

		partidos.add(partidoRojo);
		partidos.add(partidoAzul);
		
		Candidato candidatoRojo = new Candidato("CandidatoRojo", partidoRojo);
		Candidato candidatoAzul = new Candidato("CandidatoAzul", partidoAzul);
		
		candidatos.add(candidatoRojo);
		candidatos.add(candidatoAzul);
		
        ColegioElectoral target = new ColegioElectoral(candidatos, provincias, partidos);
        
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaB");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaC");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaD");
        
        Candidato candidatoConMasVotos = target.obtenerCandidatoConMasVotos();
        
        Assert.assertEquals(3, candidatoRojo.obtenerCantidadDeVotos());
        Assert.assertEquals(2, candidatoAzul.obtenerCantidadDeVotos());
        Assert.assertEquals("CandidatoRojo", candidatoConMasVotos.obtenerNombre());
    }
	
	@Test
    public void obtenerPartidoConMasVotosEnProvinciaADevuelveRojo()
    {
		ArrayList<Candidato> candidatos = new ArrayList<>();
		ArrayList<Provincia> provincias = new ArrayList<>();
		ArrayList<Partido> partidos = new ArrayList<>();
		
		Provincia provinciaA = new Provincia("ProvinciaA");
		Provincia provinciaB = new Provincia("ProvinciaB");
		Provincia provinciaC = new Provincia("ProvinciaC");
		Provincia provinciaD = new Provincia("ProvinciaD");
		
		provincias.add(provinciaA);
		provincias.add(provinciaB);
		provincias.add(provinciaC);
		provincias.add(provinciaD);
		
		Partido partidoRojo = new Partido("Rojo");
		Partido partidoAzul = new Partido("Azul");

		partidos.add(partidoRojo);
		partidos.add(partidoAzul);
		
		Candidato candidatoRojo = new Candidato("CandidatoRojo", partidoRojo);
		Candidato candidatoAzul = new Candidato("CandidatoAzul", partidoAzul);
		
		candidatos.add(candidatoRojo);
		candidatos.add(candidatoAzul);
		
        ColegioElectoral target = new ColegioElectoral(candidatos, provincias, partidos);
        
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaB");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaC");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaD");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaB");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaB");
        
        Partido partidoConMasVotosEnProvB = target.obtenerPartidoConMasVotos("ProvinciaB");
        
        Assert.assertEquals(5, candidatoRojo.obtenerCantidadDeVotos());
        Assert.assertEquals(2, candidatoAzul.obtenerCantidadDeVotos());
        Assert.assertEquals("Rojo", partidoConMasVotosEnProvB.obtenerNombre());
    }
	
	@Test
    public void obtenerCandidatoConMasVotosDevuelveRojo()
    {
		ArrayList<Candidato> candidatos = new ArrayList<>();
		ArrayList<Provincia> provincias = new ArrayList<>();
		ArrayList<Partido> partidos = new ArrayList<>();
		
		Provincia provinciaA = new Provincia("ProvinciaA");
		Provincia provinciaB = new Provincia("ProvinciaB");
		Provincia provinciaC = new Provincia("ProvinciaC");
		Provincia provinciaD = new Provincia("ProvinciaD");
		
		provincias.add(provinciaA);
		provincias.add(provinciaB);
		provincias.add(provinciaC);
		provincias.add(provinciaD);
		
		Partido partidoRojo = new Partido("Rojo");
		Partido partidoAzul = new Partido("Azul");

		partidos.add(partidoRojo);
		partidos.add(partidoAzul);
		
		Candidato candidatoRojo = new Candidato("CandidatoRojo", partidoRojo);
		Candidato candidatoAzul = new Candidato("CandidatoAzul", partidoAzul);
		
		candidatos.add(candidatoRojo);
		candidatos.add(candidatoAzul);
		
        ColegioElectoral target = new ColegioElectoral(candidatos, provincias, partidos);
        
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaA");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaB");
        target.sumarVotoCandidato("CandidatoAzul", "ProvinciaC");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaD");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaB");
        target.sumarVotoCandidato("CandidatoRojo", "ProvinciaB");

        Candidato candidatoConMasVotos = target.obtenerCandidatoConMasVotos();
        
        Assert.assertEquals(5, candidatoRojo.obtenerCantidadDeVotos());
        Assert.assertEquals(2, candidatoAzul.obtenerCantidadDeVotos());
        Assert.assertEquals("CandidatoRojo", candidatoConMasVotos.obtenerNombre());
    }
}
