//package dao;
//
//import static org.junit.Assert.*;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import model.Prestito;
//
//public class PrestitoDAOTest {
//
//	static PrestitoDAO pDAO;
//	static Prestito p;
//	
//	@BeforeClass
//	public static void SetUp() {
//		pDAO = new PrestitoDAO();
//		p = new Prestito(u, l, b, date, date);
//		pDAO.createPrestito(p);
//		assertNotNull(pDAO);
//	}
//	
//	@Test
//	public void createPrestito(){
//		Prestito p = new Prestito(u, l, b, date, date);
//		boolean token = pDAO.createPrestito(p);
//		assertTrue(token);
//	}
//	
//	@Test
//	public void readPrestito(){
//		Prestito p1 = pDAO.readPrestito(1);
//		assertEquals(p.getId_prestito(), p1.getId_prestito());
//	}
//	
//	@Test
//	public void updatePrestito(){
//		Prestito p1 = pDAO.readPrestito(1);
//		p1.setDataScadenza(dataScadenza);
//		boolean token = pDAO.updatePrestito(p1);
//		assertTrue(token);	
//	}
//	
//	@Test
//	public void deletePrestito(){
//		Prestito p1 = pDAO.readPrestito(2);
//		boolean token = pDAO.deletePrestito(p1);
//		assertTrue(token);		
//	}
//	
//	@AfterClass
//	public static void tearDown(){
//		boolean token = pDAO.deletePrestito(p);
//		assertTrue(token);
//	}
//
//}
