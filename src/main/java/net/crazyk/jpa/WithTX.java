package net.crazyk.jpa;

import jdk.nashorn.internal.objects.annotations.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WithTX {
	@FunctionalInterface
	public interface Task {
		void doTask(EntityManager em);
	}

	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");

	public static void tx(Task task) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			task.doTask(em);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public static void tx(Task task, boolean isTalkative) {
		if(!isTalkative) {
			tx(task);
			return;
		}

		System.out.println("================================ JOB START ================================");
		tx(task);
		System.out.println("//////////////////////////////// JOB's END ////////////////////////////////");
	}

	public static void txt(Task task) {
		tx(task, true);
	}

}
