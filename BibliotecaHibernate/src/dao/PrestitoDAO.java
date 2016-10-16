package dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Libro;
import model.Prestito;
import model.Utente;
import utility.DataUtility;
import utility.HibernateUtil;

public class PrestitoDAO {

	//1- Create
	public boolean createPrestito(Prestito p) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Prestito p1 = convertUtilSQL(p);
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(p1);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	private Prestito convertUtilSQL(Prestito p) {
		Date utilDataPrestito = p.getDataPrestito();
		Date utilDataScadenza = p.getDataScadenza();
		java.sql.Date prestito = DataUtility.utilDateToSqlDate(utilDataPrestito);
		java.sql.Date scadenza = DataUtility.utilDateToSqlDate(utilDataScadenza);
		p.setDataPrestito(prestito);
		p.setDataScadenza(scadenza);
		return p;
	}
	
	private Prestito convertUtilSQL2(Prestito p) {	
		Date utilDataRestituzione = p.getDataRestituzione();
		java.sql.Date restituzione = DataUtility.utilDateToSqlDate(utilDataRestituzione);
		p.setDataRestituzione(restituzione);
		return p;
	}
	
	//2- Read
	
	public Prestito readPrestito(long id_p){
		Prestito p = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			p = session.get(Prestito.class, id_p);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return p;
	}
	
	public Prestito readPrestito(Utente u, Libro l){
		Prestito p = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Prestito where u_id_utente=:utenteInserito and l_id_libro=:libroInserito");
			query.setLong("utenteInserito", u.getId_utente());
			query.setLong("libroInserito", l.getId_libro());
			p = (Prestito) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return p;
	}
	
	//3- Update
	public boolean updatePrestito(Prestito p){
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Prestito p1 = convertUtilSQL2(p);
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(p1);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	//4- Delete
	public boolean deletePrestito(Prestito p) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(p);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
