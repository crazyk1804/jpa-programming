package net.crazyk.jpa.chapter08;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter08.domain.EagerMember8;
import net.crazyk.jpa.chapter08.domain.EagerTeam8;
import net.crazyk.jpa.chapter08.domain.ProxyMember8;
import net.crazyk.jpa.chapter08.domain.ProxyTeam8;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Proxy extends WithTX {

	void setProxyModel() {
		txt(em -> {
			ProxyTeam8 team = new ProxyTeam8();
			team.setTeamId("team1");
			team.setName("TEAM 1");

			ProxyMember8 member = new ProxyMember8();
			member.setId("member1");
			member.setUsername("MEMBER 1");
			member.setTeam(team);

			Arrays.asList(team, member).forEach(em::persist);
		});
	}

	void setEagerModel() {
		txt(em -> {
			EagerTeam8 team = new EagerTeam8();
			team.setId("team1");
			team.setName("Eager Team");

			EagerMember8 member = new EagerMember8();
			member.setId("member1");
			member.setUsername("Eager Member");
			member.setTeam(team);

			Arrays.asList(team, member).forEach(em::persist);
		});
	}

	@BeforeAll
	void before() {
		setProxyModel();
		setEagerModel();
	}

	@Test @Order(1)
	void proxySampelFind() {
		txt(em -> {
			ProxyMember8 member = em.find(ProxyMember8.class, "member1");
			ProxyTeam8 team = member.getTeam();
			System.out.printf("MEMBER NAME: %s\n", member.getUsername());
			System.out.printf("TEAM NAME: %s\n", team.getName());
		});
	}

	@Test @Order(2)
	void proxySampleFind2() {
		txt(em -> {
			ProxyMember8 member = em.find(ProxyMember8.class, "member1");
			System.out.printf("MEMBER NAME: %s\n", member.getUsername());
		});
	}

	@Test @Order(3)
	void eagerTest() {
		txt(em -> {
			EagerMember8 member = em.find(EagerMember8.class, "member1");
			EagerTeam8 team = member.getTeam();
			System.out.println(team.getName());
		});
	}
}
