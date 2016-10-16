package dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Utente;

public class UtenteDAOTest {

	static UtenteDAO uDAO;
	static Utente u;
	
	@BeforeClass
	public static void SetUp() {
		uDAO = new UtenteDAO();
		u = new Utente("AAA", "BBB", "AABB");
		uDAO.createUtente(u);
		assertNotNull(uDAO);
	}
	
	@Test
	public void createUtente(){
		Utente u = new Utente("BBB", "AAA", "BBAA");
		boolean token = uDAO.createUtente(u);
		assertTrue(token);
	}
	
	@Test
	public void readUtente(){
		Utente u1 = uDAO.readUtente(1);
		assertEquals(u.getId_utente(), u1.getId_utente());
	}
	
	@Test
	public void updateUtente(){
		Utente u1 = uDAO.readUtente(1);
		u1.setNome("CCC");
		boolean token = uDAO.updateUtente(u1);
		assertTrue(token);	
	}
	
	@Test
	public void deleteUtente(){
		Utente u1 = uDAO.readUtente(2);
		boolean token = uDAO.deleteUtente(u1);
		assertTrue(token);		
	}
	
	@AfterClass
	public static void tearDown(){
		boolean token = uDAO.deleteUtente(u);
		assertTrue(token);
	}

}
