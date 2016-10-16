package model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Prestito {
	
	@ManyToOne
	private Utente u;
	@ManyToOne
	private Libro l;
	private Date dataPrestito;
	private Date dataScadenza;
	private Date dataRestituzione;
	
	public Prestito(){}
	public Prestito(Utente u, Libro l, Date dataPrestito, Date dataScadenza){
		this.u=u;
		this.l=l;
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
	
	

}
