package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_prestito;
	@ManyToOne
	private Utente u;
	@ManyToOne
	private Libro l;
	@ManyToOne
	private Biblioteca b;
	private Date dataPrestito;
	private Date dataScadenza;
	private Date dataRestituzione;
	
	public Prestito(){}
	public Prestito(Utente u, Libro l, Biblioteca b, Date dataPrestito, Date dataScadenza){
		this.u=u;
		this.l=l;
		this.b=b;
		this.dataPrestito=dataPrestito;
		this.dataScadenza=dataScadenza;
	}
	public Utente getU() {
		return u;
	}
	public void setU(Utente u) {
		this.u = u;
	}
	public Libro getL() {
		return l;
	}
	public void setL(Libro l) {
		this.l = l;
	}
	public Date getDataPrestito() {
		return dataPrestito;
	}
	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public Date getDataRestituzione() {
		return dataRestituzione;
	}
	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
	public long getId_prestito() {
		return id_prestito;
	}
	public void setId_prestito(long id_prestito) {
		this.id_prestito = id_prestito;
	}
	public Biblioteca getB() {
		return b;
	}
	public void setB(Biblioteca b) {
		this.b = b;
	}
	public void removeU(){
		this.u=null;
	}
	public void removeL(){
		this.l=null;
	}
}
