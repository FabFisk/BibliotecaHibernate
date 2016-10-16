package service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.BibliotecaDAO;
import dao.LibroDAO;
import dao.UtenteDAO;
import model.Biblioteca;
import model.Libro;
import model.Utente;

public class GestioneTest {
	
	static Gestione g;
	static Biblioteca b;
	static Utente u;
	static Libro l;
	
	@BeforeClass
	public static void setUp(){
		g = new Gestione();
		b = new Biblioteca("Test");
		u = new Utente("aaa", "aaa", "aa001");
		l = new Libro("bbb", "bbb", "bb001", 1);
		BibliotecaDAO bDAO = new BibliotecaDAO();
		UtenteDAO uDAO = new UtenteDAO();
		LibroDAO lDAO = new LibroDAO();
		bDAO.createBiblioteca(b);
		uDAO.createUtente(u);
		lDAO.createLibro(l);
		assertNotNull(g);
		assertNotNull(b);
		assertNotNull(u);
		assertNotNull(l);
	}

	@Test
	public void registraLibro() {
		boolean token = g.registraLibro(b, "titolo", "autore", "serial", 1);
		assertTrue(token);
	}
	
	@Test
	public void registraUtente() {
		Utente u1 = null;
		try {
			u1 = g.registraUtente(b, "nome", "cognome", "cofFisc");
		} catch (UtenteGiaEsiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(u1);
	}
//	
//	@Test
//	public void prestaLibro() {
//		boolean token = g.prestaLibro(b, u, l);
//		assertTrue(token);
//	}
//	
//	@Test
//	public void restituisciLibro() {
//		boolean token = g.restituisciLibro(b, u, l);
//		assertTrue(token);
//	}



}
