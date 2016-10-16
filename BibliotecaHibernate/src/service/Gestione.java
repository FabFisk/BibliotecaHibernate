package service;

import java.util.Calendar;
import java.util.Date;

import dao.*;
import model.*;
import utility.*;

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
			lDAO.createLibro(l);
			l.addBiblioteca(b);
			lDAO.updateLibro(l);
			b.addLibro(l);
			bDAO.updateBiblioteca(b);	
			token = true;
		}
		return token;	
	}

	public Utente registraUtente(Biblioteca b, String nome, String cognome, String codFisc) throws UtenteGiaEsiste {
		Utente u = uDAO.readUtente(nome, cognome);
		if(u!=null){
			throw new UtenteGiaEsiste();
		}
		u = new Utente(nome, cognome, codFisc);
		uDAO.createUtente(u);
		u.addBiblioteca(b);
		uDAO.updateUtente(u);
		b.addUtente(u);
		bDAO.updateBiblioteca(b);	
		return u;	
	}

	public boolean prestaLibro(Biblioteca b, Utente u, Libro l) {
		boolean token = false;
		if(u!=null && l!=null && u.getNumeroPrestiti()<3 && l.getCopieDisp()>0){
			Date today = new Date();
			Date scadenza = setScadenza(today);			
			Prestito p = new Prestito(u, l, b, today, scadenza);
			pDAO.createPrestito(p);
			u.addPrestito(p);
			b.addPrestito(p);
			l.addPrestito(p);
			l.setCopieDisp(l.getCopieDisp()-1);
			uDAO.updateUtente(u);
			bDAO.updateBiblioteca(b);
			lDAO.updateLibro(l);
			token = true;
		}		
		return token;	
	}

	public boolean restituisciLibro(Biblioteca b, Utente u, Libro l) {
		boolean token = false;
		Prestito p = pDAO.readPrestito(u, l);
		if(u!=null && l!=null && p!=null && p.getDataRestituzione()==null){
			Date today = new Date();
			p.setDataRestituzione(today);
			System.out.println(p.getDataRestituzione());
			u.getPrestiti().remove(p);
			p.setU(null);
			l.getPrestiti().remove(p);
			l.setCopieDisp(l.getCopieDisp()+1);
			pDAO.updatePrestito(p);
			uDAO.updateUtente(u);
			lDAO.updateLibro(l);
			token = true;
		}		
		return token;	
	}
	
	private Date setScadenza(Date today) {
		Calendar cal = DataUtility.utilDateToCalendar(today);
		cal.add(Calendar.DATE, 14);
		Date scadenza = cal.getTime();
		return scadenza;
	}

}
