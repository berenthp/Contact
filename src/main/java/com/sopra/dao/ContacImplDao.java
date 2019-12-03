package com.sopra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sopra.dao.Context;
import com.sopra.model.Contact;

public class ContacImplDao implements ContactDAO {
	EntityManager em = Context.getInstance().getEmf().createEntityManager();
	
	@Override
	public List<Contact> findAll() {
		Query q = em.createQuery("from Contact");
		return q.getResultList();
	}

	@Override
	public Contact findByKey(Integer id) {
		return em.find(Contact.class, id);
	}

	@Override
	public Contact insert(Contact obj) {
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
