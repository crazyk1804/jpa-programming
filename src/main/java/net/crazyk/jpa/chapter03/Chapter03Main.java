package net.crazyk.jpa.chapter03;

import net.crazyk.jpa.chapter01.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Chapter03Main {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

	public static Member createDetachedMember(String id, String username) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Member member = new Member();
		member.setId(id);
		member.setUsername(username);
		em.persist(member);
		tx.commit();
		em.close();

		return member;
	}

	public static void mergeMember(Member member) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Member mergeMember = em.merge(member);
		tx.commit();

		System.out.println(String.format("member = %s", member.getUsername()));
		System.out.println(String.format("mergeMember = %s", member.getUsername()));
		System.out.println(String.format("em contains member = %s", em.contains(member)));
		System.out.println(String.format("em contains mergeMember = %s", em.contains(mergeMember)));

		System.out.println(String.format("member and mergeMember are same? => [%b]", member == mergeMember));

		em.close();
	}

	public static void deleteMember() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Member member = em.find(Member.class, "memberA");
		em.remove(member);
		tx.commit();
		em.close();
	}

	public static void main(String...args) {
		System.out.println("=============================== HE L LO ===============================");

		Member member = null;
		try {
			member = createDetachedMember("memberA", "회원1");
			member.setUsername("회원명변경");
			mergeMember(member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			deleteMember();
		}

		System.out.println("/////////////////////////////// ~ BYE ~ ///////////////////////////////");
	}
}
