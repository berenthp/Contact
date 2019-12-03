package com.sopra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sopra.dao.Context;
import com.sopra.model.Contact;

public class ContactImplDao implements ContactDAO {
	
	private Logger LOGGER0 = LogManager.getLogger(Context.class.getName());
	
	EntityManager em = Context.getInstance().getEmf().createEntityManager();
	
	@Override
	public List<Contact> findAll() {
		LOGGER0.info("Ceci est la méthode findAll(); =)");
		Query q = em.createQuery("from Contact");
		return q.getResultList();
	}

	@Override
	public Contact findByKey(Integer id) {
		LOGGER0.info("Ceci est la méthode findByKey(); =S");
		return em.find(Contact.class, id);
	}

	@Override
	public Contact insert(Contact obj) {
		LOGGER0.info("Ceci est la méthode insert(); <><");
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return obj;	
	}

	@Override
	public Contact update(Contact obj) {
		LOGGER0.info("Ceci est la méthode update(); <3");
		Contact c = null;
		try {
			em.getTransaction().begin();
			c = em.merge(obj);
			//			em.persist(a);  PAS NECESSAIRE ????
			em.getTransaction().commit();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return c;
	}

	@Override
	public void deleteByKey(Integer Key) {
		LOGGER0.info("Ceci est la méthode deleteByKey(); ^^");
		Contact c = em.find(Contact.class,  Key);
		try {
			em.getTransaction().begin();
			if(c != null) {
				em.remove(c);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
