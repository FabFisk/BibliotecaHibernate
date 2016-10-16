package service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GestioneTest {
	
	static Gestione g;
	
	@BeforeClass
	public static void setUp(){
		g = new Gestione();
		assertNotNull(g);
	}

	@Test
	public void registraLibro() {
		g.registraLibro();
		fail("Not yet implemented");
	}
	
	@Test
	public void registraUtente() {
		g.registraUtente();
		fail("Not yet implemented");
	}
	
	@Test
	public void prestaLibro() {
		g.prestaLibro();
		fail("Not yet implemented");
	}
	
	@Test
	public void restituisciLibro() {
		g.restituisciLibro;
		fail("Not yet implemented");
	}



}
