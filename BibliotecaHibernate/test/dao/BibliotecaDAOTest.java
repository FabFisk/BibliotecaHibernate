package dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Biblioteca;

public class BibliotecaDAOTest {

	static BibliotecaDAO bDAO;
	static Biblioteca b;
	
	@BeforeClass
	public static void SetUp() {
		bDAO = new BibliotecaDAO();
		b = new Biblioteca("Test");
		bDAO.createBiblioteca(b);
		assertNotNull(bDAO);
	}
	
	@Test
	public void createBiblioteca(){
		Biblioteca b = new Biblioteca("Polito");
		boolean token = bDAO.createBiblioteca(b);
		assertTrue(token);
	}
	
	@Test
	public void readBiblioteca(){
		Biblioteca b1 = bDAO.readBiblioteca(1);
		assertEquals(b.getId_biblioteca(), b1.getId_biblioteca());
	}
	
	@Test
	public void updateBiblioteca(){
		Biblioteca b1 = bDAO.readBiblioteca(1);
		b1.setNome("Test2");
		boolean token = bDAO.updateBiblioteca(b1);
		assertTrue(token);	
	}
	
	@Test
	public void deleteBiblioteca(){
		Biblioteca b1 = bDAO.readBiblioteca(2);
		boolean token = bDAO.deleteBiblioteca(b1);
		assertTrue(token);		
	}
	
	@AfterClass
	public static void tearDown(){
		boolean token = bDAO.deleteBiblioteca(b);
		assertTrue(token);
	}
	

}
