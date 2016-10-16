package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_utente;
	private String nome;
	private String cognome;
	private String codFisc;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "u", cascade = CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> prestiti;

	@ManyToMany (fetch = FetchType.EAGER, mappedBy="utenti", cascade = CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Biblioteca> biblioteche;
	
	public Utente(){
		this.nome="";
		this.cognome="";
		this.codFisc="";
		this.prestiti=new HashSet<Prestito>();
		this.biblioteche=new HashSet<Biblioteca>();
	}
	public Utente(String nome, String cognome, String codFisc) {
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc=codFisc;
		this.prestiti=new HashSet<Prestito>();
		this.biblioteche=new HashSet<Biblioteca>();
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
	public Set<Prestito> getPrestiti() {
		return prestiti;
	}
	public void setPrestiti(Set<Prestito> prestiti) {
		this.prestiti = prestiti;
	}
	public void addPrestito(Prestito p){
		this.prestiti.add(p);
	}
	public void removePrestito(Prestito p){
		this.prestiti.remove(p);
	}
	public Set<Biblioteca> getBiblioteche() {
		return biblioteche;
	}
	public void setBiblioteche(Set<Biblioteca> biblioteche) {
		this.biblioteche = biblioteche;
	}
	public void addBiblioteca(Biblioteca b){
		this.biblioteche.add(b);
	}
	
	
}
