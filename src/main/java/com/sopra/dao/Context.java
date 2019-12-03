package com.sopra.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Context {   // SINGLETON
	
	private Logger LOGGER0 = LogManager.getLogger(Context.class.getName());
	private static Logger LOGGER = LogManager.getLogger(Context.class.getName());
	
	private static Context instance;
	private EntityManagerFactory emf;

	private Context() {
		LOGGER0.debug("Creation d'un persistence manager");
		emf = 	Persistence.createEntityManagerFactory("contactmanagement");
	}

	public static Context getInstance() {
		if(instance == null) {
			instance = new Context();
		}
		LOGGER.debug("Récupération singleton");
		return instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}



}
