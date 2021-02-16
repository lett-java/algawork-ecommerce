package com.algaworks.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EntityManagerTest {

	protected static EntityManagerFactory entityManagerFactory;

	protected EntityManager entityManager;

	@BeforeClass
	public static void setPpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}

	@Before
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void tearDown() {
		entityManager.close();
	}

	public void persistirEntidade(Object entidade) {
		entityManager.getTransaction().begin();
		entityManager.persist(entidade);
		entityManager.getTransaction().commit();

		entityManager.clear();
	}

	public void persistirEntidades(Object entidade1, Object entidade2) {
		entityManager.getTransaction().begin();
		entityManager.persist(entidade1);
		entityManager.persist(entidade2);
		entityManager.getTransaction().commit();

		entityManager.clear();
	}

	public void removerEntidade(Object entidade) {
		entityManager.getTransaction().begin();
		entityManager.remove(entidade);
		entityManager.getTransaction().commit();

		entityManager.clear();
	}

}
