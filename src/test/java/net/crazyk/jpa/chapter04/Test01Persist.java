package net.crazyk.jpa.chapter04;

import net.crazyk.jpa.TestTemplate;
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
public class Test01Persist extends TestTemplate {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction tx = em.getTransaction();
	@FunctionalInterface
	interface JPANewTask{ void doTask(Member4 m); }

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

	@BeforeAll
	void beforeAll() {

	}

	@AfterAll
	void afterAll() {

	}


	@Test
	void nonamaePersist() {
		tx(() -> {
			Member4 member = new Member4();
			member.setId("anjfkrh gkfwl ahfmrpTek");
			em.persist(member);
		});
	}

	@Test
	void namePersist() {
		tx(() -> {
			Member4 member = new Member4();
			member.setId("anjfkrh gkfwl ahfmrpTek");
			member.setUsername("johndoe");
			em.persist(member);
		});
	}

	@Test
	void uniqueViolation() {
		// 이름과 나이 같은걸로 2개 insert (unique)
		tx(() -> {
			Member4 m1 = new Member4();
			Member4 m2 = new Member4();
			m1.setId("anjfkrh gkfwl ahfmrpTek");
			m1.setUsername("johndoe");
			m1.setAge(40);
			m2.setId("anjfkrh gkfwl ahfmrpTek!!");
			m2.setUsername("johndoe");
			m2.setAge(40);
			Arrays.asList(m1, m2).forEach(m -> em.persist(m));
		});
	}

	@Test
	void typeTest() {
		newJob(m -> {
			m.setId("anjfkrh gkfwl ahfmrpTek!!");
			m.setUsername("johndoe");
			m.setRoleType(RoleType.ADMIN);
			em.persist(m);
		});

	}
}
