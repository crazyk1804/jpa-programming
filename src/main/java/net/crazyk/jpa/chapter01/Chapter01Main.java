package net.crazyk.jpa.chapter01;

import net.crazyk.jpa.chapter01.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Chapter01Main {
	public static void logic(EntityManager em) {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("동한");
		member.setAge(41);

		em.persist(member);
		member.setAge(20);

		Member findMember = em.find(Member.class, id);
		System.out.println(String.format(
			"findMember = %s, age = %d",
			findMember.getUsername(),
			findMember.getAge()
		));

		List<Member> members = em.createQuery("select m from Member m", Member.class)
			.getResultList();
		System.out.println(String.format("members.size = %d", members.size()));

		em.remove(member);
	}

	public static void main(String... args) {
		System.out.println("=============================== HELLO ===============================");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		System.out.println("/////////////////////////////// BYE ~ ///////////////////////////////");
	}
}
