package dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Libro;

public class LibroDAOTest {

	static LibroDAO lDAO;
	static Libro l;
	
	@BeforeClass
	public static void SetUp() {
		lDAO = new LibroDAO();
		l = new Libro("BBB", "BBB", "BB001", 1);
		lDAO.createLibro(l);
		assertNotNull(lDAO);
	}
	
	@Test
	public void createBiblioteca(){
		Libro l = new Libro("AAA", "AAA", "AA001", 1);
		boolean token = lDAO.createLibro(l);
		assertTrue(token);
	}
	
	@Test
	public void readBiblioteca(){
		Libro l1 = lDAO.readLibro(1);
		assertEquals(l.getId_libro(), l1.getId_libro());
	}
	
	@Test
	public void updateBiblioteca(){
		Libro l1 = lDAO.readLibro(1);
		l1.setTitolo("CCC");
		boolean token = lDAO.updateLibro(l1);
		assertTrue(token);	
	}
	
	@Test
	public void deleteBiblioteca(){
		Libro l1 = lDAO.readLibro(2);
		boolean token = lDAO.deleteLibro(l1);
		assertTrue(token);		
	}
	
	@AfterClass
	public static void tearDown(){
		boolean token = lDAO.deleteLibro(l);
		assertTrue(token);
	}

}
