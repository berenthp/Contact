package com.sopra;

import javax.persistence.EntityManager;

import com.sopra.dao.ContactImplDao;
import com.sopra.dao.Context;
import com.sopra.model.Contact;

public class EntryContact {

	public static void main(String[] args) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		try {
			em.getTransaction().begin(); 

			ContactImplDao cdao = new ContactImplDao();
			Contact c = new Contact();
			c.setFirstname("Monsieur Rigolo");
			c.setLastname("Trop de Fun");
			cdao.insert(c);

			
			// BLABLABLA
			
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		em.close();
	}

}
