package model;

public class Libro {
	
	private long id_libro;
	private String titolo;
	private String autore;
	private String serialNum;
	private int copieTot;
	private int copieDisp;
	
	public Libro(){
		this.titolo = "";
		this.autore = "";
		this.serialNum = "";
		this.copieTot = 0;
		this.copieDisp = 0;
	}

	public Libro(String titolo, String autore, String serialNum, int copie) {
		this.titolo = titolo;
		this.autore = autore;
		this.serialNum = serialNum;
		this.copieTot = copie;
		this.copieDisp = copie;
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
	
	
	

}
