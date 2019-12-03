package com.sopra;

import javax.persistence.EntityManager;

import com.sopra.dao.Context;

public class EntryContact {

	public static void main(String[] args) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		try {
			em.getTransaction().begin(); 

			
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
