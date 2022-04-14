package net.crazyk.jpa.chapter10;

import net.crazyk.jpa.chapter10.domain.JQAddress10;
import net.crazyk.jpa.chapter10.domain.JQMember10;
import net.crazyk.jpa.chapter10.domain.JQOrder10;
import net.crazyk.jpa.chapter10.domain.JQTeam10;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPQLTest extends PrerequisiteTest{
	@Test @Order(1)
	void typeQueryTest() {
		txt(em -> {
			TypedQuery<JQMember10> query = em.createQuery("select m from JQMember10 m", JQMember10.class);
			query.getResultList().forEach(m -> System.out.printf("MEMBER = %s\n", m.getUsername()));
		});
	}

	@Test @Order(2)
	void queryTest() {
		txt(em -> {
			em.createQuery("select m.username, m.age from JQMember10 m").getResultList().forEach(r -> {
				Object[] result = (Object[])r;
				System.out.printf("USERNAME = %s, AGE = %d\n", result[0], result[1]);
			});
		});
	}

	@Test @Order(3)
	void namedParameterTest() {
		txt(em -> {
			String username = "MEMBER 1";
			TypedQuery<JQMember10> query = em
				.createQuery("select m from JQMember10 m where m.username = :username", JQMember10.class);
			query.setParameter("username", username).getResultList().forEach(m -> {
				System.out.printf("USERNAME = %s\n", m.getUsername());
			});
		});
	}

	@Test @Order(4)
	void positionalParameterTest() {
		txt(em -> {
			String username = "MEMBER 2";
			TypedQuery<JQMember10> query = em
				.createQuery("select m from JQMember10 m where m.username = ?1", JQMember10.class);
			query.setParameter(1, username).getResultList().forEach(m -> {
				System.out.printf("USERNAME = %s\n", m.getUsername());
			});
		});
	}

	@Test @Order(5)
	/**
	 * select 절에 조회대상 지정하는 짓거리를 프로젝션이라 한다.
	 */
	void projectionBasicTest() {
		txt(em -> {
			em.createQuery("select m from JQMember10 m", JQMember10.class).getResultList()
				.forEach(m -> System.out.printf("USERNAME = %s\n", m.getUsername()));

			em.createQuery("select m.team from JQMember10 m", JQTeam10.class).getResultList()
				.forEach(t -> System.out.printf("TEAM NAME = %s\n", t.getName()));

			em.createQuery("select o.address from JQOrder10 o where o.id < 200", JQAddress10.class)
				.getResultList().forEach(a -> {
					System.out.printf("ORDER CITY: %s\n", a.getCity());
				});

			// 스칼라 타입
			em.createQuery("select m.username from JQMember10 m", String.class)
				.getResultList().forEach(System.out::println);
		});
	}


}
