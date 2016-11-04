package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// Do stuff...

        UserProfile userProfile = new UserProfile();

        userProfile.setFirstName("FN");

        UserContact contact1 = new UserContact();
        contact1.setName("A");
        contact1.setUserProfile(userProfile);

        UserContact contact2 = new UserContact();
        contact2.setName("B");
        contact2.setUserProfile(userProfile);

        List<UserContact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);

        userProfile.setUserContacts(contacts);


        entityManager.persist(userProfile);


		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
