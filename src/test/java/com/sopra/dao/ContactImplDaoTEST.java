package com.sopra.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sopra.model.Contact;

public class ContactImplDaoTEST {
	
	ContactImplDao cdao = new ContactImplDao();
	
	@Test
	public void testFindAll() {
		cdao.insert(new Contact("Bonhomme1", "nom1"));
		List<Contact> contacts = cdao.findAll();
		Assert.assertTrue("empty", contacts.size() >= 1 );
	}

	@Test
	public void testFindByKey() {
		cdao.insert(new Contact("Bonhomme1", "nom1"));
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(cdao.findAll().get(0));
		Assert.assertTrue("empty", contacts.size() == 1 );	
	}

	@Test
	public void testInsert() {
		List<Contact> contactsB = cdao.findAll();
		cdao.insert(new Contact("Pepito", "Caramba"));
		List<Contact> contactsA = cdao.findAll();
		Assert.assertTrue("empty - not inserted", ((contactsA.size() - contactsB.size()) == 1 ));
	}

	@Test
	public void testUpdate() {
		cdao.insert(new Contact("Pepito", "Caramba"));
		Contact c1 = cdao.findAll().get(0);
		c1.setLastname("Hey Caramba!");
		Contact cmerged = cdao.update(c1);	
		Assert.assertTrue("not updated", cmerged.getLastname().equals("Hey Caramba!"));
	}

	@Test
	public void testDeleteByKey() {
		cdao.insert(new Contact("Bonhomme1", "nom1"));
		int sizeB = cdao.findAll().size();
		cdao.deleteByKey(cdao.findAll().get(0).getId());
		int sizeA = cdao.findAll().size();
		Assert.assertTrue("empty - not deleted ("+(sizeB-sizeA)+")", sizeB-sizeA == 1);
	}

}
