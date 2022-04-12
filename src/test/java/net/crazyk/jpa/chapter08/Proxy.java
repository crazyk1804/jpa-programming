package net.crazyk.jpa.chapter08;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter08.domain.ProxyMember8;
import net.crazyk.jpa.chapter08.domain.ProxyTeam8;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Proxy extends WithTX {
	@BeforeAll
	void before() {
		txt(em -> {
			ProxyTeam8 team = new ProxyTeam8();
			team.setTeamId("team1");
			team.setName("TEAM 1");
			em.persist(team);

			ProxyMember8 member = new ProxyMember8();
			member.setId("member1");
			member.setUsername("MEMBER 1");
			member.setTeam(team);
			em.persist(member);

//			Arrays.asList(team, member).forEach(em::persist);
		});
	}

	@Test
	void proxySampelFind() {
		txt(em -> {
			ProxyMember8 member = em.find(ProxyMember8.class, "member1");
			ProxyTeam8 team = member.getTeam();
			System.out.printf("MEMBER NAME: %s\n", member.getUsername());
			System.out.printf("TEAM NAME: %s\n", team.getName());
		});
	}

	@Test
	void proxySampleFind2() {
		txt(em -> {
			ProxyMember8 member = em.find(ProxyMember8.class, "member1");
			System.out.printf("MEMBER NAME: %s\n", member.getUsername());
		});
	}
}
