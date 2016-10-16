package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Biblioteca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_biblioteca;
	private String nome;
	@ManyToMany
	private Set<Utente> utenti;
	@ManyToMany
	private Set<Libro> libri;
	private Set<Prestito> prestiti;
	
	public Biblioteca(){
		this.nome="";
		this.utenti=new HashSet<Utente>();
		this.libri=new HashSet<Libro>();
		this.prestiti=new HashSet<Prestito>();
	}

	public Biblioteca(String nome) {
		this.nome = nome;
		this.utenti=new HashSet<Utente>();
		this.libri=new HashSet<Libro>();
		this.prestiti=new HashSet<Prestito>();
	}

	public long getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(long id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Set<Utente> utenti) {
		this.utenti = utenti;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}

	public Set<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}
	
	public void addUtente(Utente u){
		this.utenti.add(u);
	}
	
	public void addLibro(Libro l){
		this.libri.add(l);
	}
	
	public void addPrestito(Prestito p){
		this.prestiti.add(p);
	}

}
