package net.crazyk.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestTemplate {
	protected EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
	protected EntityManager em = factory.createEntityManager();
	protected EntityTransaction tx = em.getTransaction();
	@FunctionalInterface
	protected interface JPATask { void toTask(); }

	protected void tx(JPATask task) {
		System.out.println("================================ JOB START ================================");
		try {
			tx.begin();
			task.toTask();
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
		System.out.println("//////////////////////////////// JOB's END ////////////////////////////////");
	}
}
