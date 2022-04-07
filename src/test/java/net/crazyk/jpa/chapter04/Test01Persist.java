package net.crazyk.jpa.chapter04;

import net.crazyk.jpa.chapter04.domain.Member4;
import net.crazyk.jpa.chapter04.domain.RoleType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test01Persist {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction tx = em.getTransaction();
	@FunctionalInterface
	interface JPATask { void toTask(); }
	@FunctionalInterface
	interface JPANewTask{ void doTask(Member4 m); }

	@BeforeAll
	void beforeAll() {

	}

	@AfterAll
	void afterAll() {

	}

	void job(JPATask task) {
		try {
			tx.begin();
			task.toTask();
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
	}
	void newJob(JPANewTask task) {
		try {
			tx.begin();
			Member4 m = new Member4();
			task.doTask(m);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
	}

	@Test
	void nonamaePersist() {
		job(() -> {
			Member4 member = new Member4();
			member.setId("wjdwogml qhwlQkfrh tlvek");
			em.persist(member);
		});
	}

	@Test
	void namePersist() {
		job(() -> {
			Member4 member = new Member4();
			member.setId("wjdwogml qhwlQkfrh tlvek");
			member.setUsername("qhwlaos");
			em.persist(member);
		});
	}

	@Test
	void uniqueViolation() {
		// 이름과 나이 같은걸로 2개 insert (unique)
		job(() -> {
			Member4 m1 = new Member4();
			Member4 m2 = new Member4();
			m1.setId("wjdwogml qhwlQkfrh tlvek");
			m1.setUsername("qhwlaos");
			m1.setAge(40);
			m2.setId("wjdwogml qhwlQkfrh tlvek!!");
			m2.setUsername("qhwlaos");
			m2.setAge(40);
			Arrays.asList(m1, m2).forEach(m -> em.persist(m));
		});
	}

	@Test
	void typeTest() {
		newJob(m -> {
			m.setId("wjdwogml qhwlQkfrh tlvek!!");
			m.setUsername("qhwlaos");
			m.setRoleType(RoleType.ADMIN);
			em.persist(m);
		});

	}
}
