package model;

import java.util.HashSet;
import java.util.Set;

public class Utente {
	
	private long id_utente;
	private String nome;
	private String cognome;
	private String codFisc;
	private Set<Libro> prestiti;

	
	public Utente(){
		this.nome="";
		this.cognome="";
		this.codFisc="";
		this.prestiti=new HashSet<Libro>();
	}
	public Utente(String nome, String cognome, String codFisc) {
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc=codFisc;
		this.prestiti=new HashSet<Libro>();
	}

	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodFisc(){
		return codFisc;
	}
	public void setCodFisc(String codFisc){
		this.codFisc=codFisc;
	}	
	public Set<Libro> getPrestiti() {
		return prestiti;
	}
	public void setPrestiti(Set<Libro> prestiti) {
		this.prestiti = prestiti;
	}
	public void addPrestito(Libro l){
		this.prestiti.add(l);
	}
}
