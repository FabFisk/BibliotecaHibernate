package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_libro;
	private String titolo;
	private String autore;
	private String serialNum;
	private int copieTot;
	private int copieDisp;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "l", cascade = CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Prestito> prestiti;
	
	@ManyToMany (fetch = FetchType.EAGER, mappedBy="libri", cascade = CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Biblioteca> biblioteche;
	
	public Libro(){
		this.titolo = "";
		this.autore = "";
		this.serialNum = "";
		this.copieTot = 0;
		this.copieDisp = 0;
		this.prestiti=new HashSet<Prestito>();
		this.biblioteche=new HashSet<Biblioteca>();
	}

	public Libro(String titolo, String autore, String serialNum, int copie) {
		this.titolo = titolo;
		this.autore = autore;
		this.serialNum = serialNum;
		this.copieTot = copie;
		this.copieDisp = copie;
		this.prestiti=new HashSet<Prestito>();
		this.biblioteche=new HashSet<Biblioteca>();
	}

	public long getId_libro() {
		return id_libro;
	}

	public void setId_libro(long id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public int getCopieTot() {
		return copieTot;
	}

	public void setCopieTot(int copieTot) {
		this.copieTot = copieTot;
	}

	public int getCopieDisp() {
		return copieDisp;
	}

	public void setCopieDisp(int copieDisp) {
		this.copieDisp = copieDisp;
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
