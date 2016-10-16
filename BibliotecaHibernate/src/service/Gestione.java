package service;

import dao.*;
import model.*;

public class Gestione {
	
	private BibliotecaDAO bDAO = new BibliotecaDAO();
	private UtenteDAO uDAO = new UtenteDAO();
	private LibroDAO lDAO = new LibroDAO();
	private PrestitoDAO pDAO = new PrestitoDAO();

	public boolean registraLibro(Biblioteca b, String titolo, String autore, String serial, int copie) {
		boolean token = false;
		Libro l = lDAO.readLibro(titolo, autore);
		if(l!=null){
			l.setCopieTot(l.getCopieTot()+copie);
			l.setCopieDisp(l.getCopieDisp()+copie);
			token = true;
		}else{
			l = new Libro(titolo, autore, serial, copie);
			l.addBiblioteca(b);
			lDAO.createLibro(l);
			b.addLibro(l);
			bDAO.updateBiblioteca(b);	
			token = true;
		}
		return token;	
	}

	public Utente registraUtente(Biblioteca b, String nome, String cognome, String codFisc) throws UtenteGiaEsiste {
		Utente u = uDAO.readUtente(nome, cognome);
		if(u==null){
			throw new UtenteGiaEsiste();
		}
		u = new Utente(nome, cognome, codFisc);
		u.addBiblioteca(b);
		uDAO.createUtente(u);
		b.addUtente(u);
		bDAO.updateBiblioteca(b);	
		return u;	
	}

	public boolean prestaLibro(Biblioteca b, Utente u, Libro l) {
		boolean token = false;
		
		
		
		return token;	
	}

	public boolean restituisciLibro(Biblioteca b, Utente u, Libro l) {
		boolean token = false;
		
		
		
		return token;	
	}

}
