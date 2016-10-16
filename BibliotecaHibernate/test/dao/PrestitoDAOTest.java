package dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Biblioteca;
import model.Libro;
import model.Prestito;
import model.Utente;

public class PrestitoDAOTest {

	static PrestitoDAO pDAO;
	static Prestito p;
	static Biblioteca b;
	static Utente u;
	static Libro l;
	
	@BeforeClass
	public static void SetUp() {
		pDAO = new PrestitoDAO();
		p = new Prestito(u, l, b, new Date(), new Date());
		pDAO.createPrestito(p);
		b = new Biblioteca("Test");
		u = new Utente("aaa", "aaa", "aa001");
		l = new Libro("bbb", "bbb", "bb001", 2);
		BibliotecaDAO bDAO = new BibliotecaDAO();
		UtenteDAO uDAO = new UtenteDAO();
		LibroDAO lDAO = new LibroDAO();
		bDAO.createBiblioteca(b);
		uDAO.createUtente(u);
		lDAO.createLibro(l);
		assertNotNull(pDAO);
	}
	
	@Test
	public void createPrestito(){
		Prestito p = new Prestito(u, l, b, new Date(), new Date());
		boolean token = pDAO.createPrestito(p);
		assertTrue(token);
	}
	
	@Test
	public void readPrestito(){
		Prestito p1 = pDAO.readPrestito(1);
		assertEquals(p.getId_prestito(), p1.getId_prestito());
	}
	
	@Test
	public void deletePrestito(){
		Prestito p1 = pDAO.readPrestito(5);
		boolean token = pDAO.deletePrestito(p1);
		assertTrue(token);		
	}
	
	@AfterClass
	public static void tearDown(){
		boolean token = pDAO.deletePrestito(p);
		assertTrue(token);
	}

}
