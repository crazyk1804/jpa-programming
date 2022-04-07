package net.crazyk.jpa.chapter04;

import net.crazyk.jpa.chapter01.domain.Member;
import net.crazyk.jpa.chapter04.domain.Member4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Chapter04Main {
	@FunctionalInterface
	interface Task {
		void doTask();
	}
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction tx = em.getTransaction();

	public static void job(Task task) {
		try {
			tx.begin();
			task.doTask();
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

	public static void main(String...args) {



	}
}
