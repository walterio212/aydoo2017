package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ColegioElectoral {

	private ArrayList<Candidato> candidatos;
	private ArrayList<Provincia> provincias;
	private ArrayList<Partido> partidos;
	private ArrayList<PartidoPorProvincia> partidosPorProvincia;
	
	public ColegioElectoral(ArrayList<Candidato> candidatos, ArrayList<Provincia> provincias, ArrayList<Partido> partidos){
		this.candidatos = candidatos;
		this.provincias = provincias;
		this.partidos = partidos;
		this.cargarPartidosPorProvincia();
	}
	
	public void sumarVotoCandidato(String nombreCandidato, String provinciaDelVotante){
		Candidato candidato = this.buscarCandidatoPorNombre(nombreCandidato);
		Provincia provincia = this.buscarProvinciaPorNombre(provinciaDelVotante);
		
		candidato.sumarVoto();
		provincia.sumarVoto();
		sumarVotoPartidoProvincia(candidato.obtenerPartido().obtenerNombre(), provinciaDelVotante);
	}
	
	public Partido obtenerPartidoConMasVotos(String nombreProvincia){
		PartidoPorProvincia partidoPorProvinciaConMasVotos = null;
		int cantMax = 0;
		
		for(int i = 0; i < this.partidosPorProvincia.size(); i++){
			PartidoPorProvincia partidoPorProvincia = this.partidosPorProvincia.get(i);
			
			if(partidoPorProvincia.obtenerProvincia().obtenerNombre() == nombreProvincia && partidoPorProvincia.obtenerCantidadDeVotos() > cantMax){
				cantMax = partidoPorProvincia.obtenerCantidadDeVotos();
				partidoPorProvinciaConMasVotos = partidoPorProvincia;
			}
		}
		
		return partidoPorProvinciaConMasVotos.obtenerPartido();
	}
	
	public Candidato obtenerCandidatoConMasVotos(){
		Candidato candidato = null;
		int cantMax = 0;
		
		for(int i = 0; i < this.candidatos.size(); i++){
			if(this.candidatos.get(i).obtenerCantidadDeVotos() > cantMax){
				candidato = this.candidatos.get(i);
				cantMax = candidato.obtenerCantidadDeVotos();
			}
		}
		
		return candidato;
	}
	
	private Candidato buscarCandidatoPorNombre(String nombre){
		Candidato candidato = null;
		for(int i = 0; i < this.candidatos.size(); i++){
			if(this.candidatos.get(i).obtenerNombre() == nombre){
				candidato = this.candidatos.get(i); 
			}
		}
		
		return candidato;
	}
	
	private Provincia buscarProvinciaPorNombre(String nombre){

		Provincia provincia = null;
		for(int i = 0; i < this.provincias.size(); i++){
			if(this.provincias.get(i).obtenerNombre() == nombre){
				provincia = this.provincias.get(i); 
			}
		}
		
		return provincia;
	}
	
	private void cargarPartidosPorProvincia(){
		this.partidosPorProvincia = new ArrayList<PartidoPorProvincia>();
		for(int i = 0; i < this.provincias.size(); i++){
			for(int j = 0; j < this.partidos.size(); j++){
				Provincia provincia = this.provincias.get(i);
				Partido partido = this.partidos.get(j);
				PartidoPorProvincia partidoPorProvincia = new PartidoPorProvincia(provincia, partido);
				this.partidosPorProvincia.add(partidoPorProvincia);
			}
		}
	}
	
	private void sumarVotoPartidoProvincia(String nombrePartido, String nombreProvincia){
		for(int i = 0; i < this.partidosPorProvincia.size(); i++){
			PartidoPorProvincia partidoPorProvincia = partidosPorProvincia.get(i);
			Provincia provincia = partidoPorProvincia.obtenerProvincia();
			Partido partido = partidoPorProvincia.obtenerPartido();
			if(partido.obtenerNombre() == nombrePartido && provincia.obtenerNombre() == nombreProvincia){
				partidoPorProvincia.sumarVoto();
			}			
		}
	}	
}
