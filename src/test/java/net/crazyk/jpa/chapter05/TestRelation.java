package net.crazyk.jpa.chapter05;

import net.crazyk.jpa.TestTemplate;
import net.crazyk.jpa.chapter05.domain.DuplexMember5;
import net.crazyk.jpa.chapter05.domain.DuplexTeam5;
import net.crazyk.jpa.chapter05.domain.Member5;
import net.crazyk.jpa.chapter05.domain.Team5;
import org.junit.jupiter.api.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRelation extends TestTemplate {
	DuplexTeam5 theTeam = null;

	@BeforeAll
	void before() {
		after();
		tx(() -> {
			theTeam = new DuplexTeam5("dt1", "dteam1");
			em.persist(theTeam);

			Arrays.asList("dm1", "dm2", "dm3").forEach(mid -> {
				DuplexMember5 m = new DuplexMember5(mid, String.format(
					"dmember_%s", mid
				));
				m.setTeam(theTeam);
				em.persist(m);
			});
		});
		/**
		 * em에 persist를 해서 영속상태라고 해도 그 하위 객체에서 상위객체를 지정한다고 해서
		 * 알아서 자식으로 넣어주는 처리까지는 되지 않는다.
		 * em을 같은 인스턴스로 사용하는 한 해당 개체는 그 상태가 유지되므로
		 * em을 새로 만들거나 해당 개체를 detach해서 상태를 다시 로드할 수 있도록 해주는 처리가 필요하다
		 * */
		em.detach(theTeam);
	}

//	@AfterAll
	void after() {
		tx(() -> {
			em.createQuery("select t from Team5 t", Team5.class)
				.getResultList().forEach(t -> em.remove(t));

			em.createQuery("select m from Member5 m", Member5.class)
				.getResultList().forEach(m -> em.remove(m));
		});
	}

	@Test @Order(1)
	void testSave() {
		System.out.println(1);
		tx(() -> {
			Team5 team1 = new Team5("team", "팀1");
			em.persist(team1);

			Member5 m1 = new Member5("member1", "회원1");
			m1.setTeam(team1);
			em.persist(m1);

			Member5 m2 = new Member5("member2", "회원2");
			m2.setTeam(team1);
			em.persist(m2);
		});
	}

	@Test @Order(2)
	void jpqlJoinTest() {
		System.out.println(2);
		tx(() -> {
			String jpql = "select m from Member5 m join m.team t where t.name = :teamName";
			em.createQuery(jpql, Member5.class)
				.setParameter("teamName", "팀1")
				.getResultList().forEach(m -> {
					System.out.println(String.format(
						"[query] member.username = %s", m.getUsername()
					));
				});
		});
	}

	@Test @Order(3)
	void jpqlChangeRelation() {
		System.out.println(3);
		tx(() -> {
			Team5 team = new Team5("team2", "팀2");
			em.persist(team);

			Member5 member = em.find(Member5.class, "member1");
			member.setTeam(team);
		});
	}

	@Test @Order(4)
	void jpqlDeleteRealation() {
		System.out.println(4);
		tx(() -> {
			Member5 member = em.find(Member5.class, "member1");
			member.setTeam(null);
		});
	}

	@Test @Order(5)
	void duplexRelation() {
		tx(() -> {
			DuplexTeam5 team = em.find(DuplexTeam5.class, "dt1");
			System.out.println(String.format("TEAM IS THE TEAM? %b", team == theTeam));
			List<DuplexMember5> members = team.getMembers();
			members.forEach(m -> {
				System.out.println(String.format("member.username = %s", m.getUserName()));
			});
			em.createQuery("select m from DuplexMember5 m", DuplexMember5.class)
				.getResultList().forEach(m -> {
					System.out.println(String.format("TEAM ID: %s", m.getTeam().getId()));
				});
		});
	}
}
