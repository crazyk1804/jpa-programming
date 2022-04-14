package net.crazyk.jpa.chapter08;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter08.domain.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

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

	void setLazyModel() {
		txt(em -> {
			LazyTeam8 team = new LazyTeam8();
			team.setId("team1");
			team.setName("LAZY TEAM");
			LazyMember8 member = new LazyMember8();
			member.setId("member1");
			member.setUsername("LAZY MEMBER");
			member.setTeam(team);

			Arrays.asList(team, member).forEach(em::persist);
		});
	}

	void setLazyExamModel() {
		txt(em -> {
			LazyExamProduct8 product = new LazyExamProduct8();
			product.setId("product1");
			product.setName("LE PRODUCT");

			LazyExamTeam8 team = new LazyExamTeam8();
			team.setId("team1");
			team.setName("LE TEAM");

			LazyExamMember8 member = new LazyExamMember8();
			member.setId("member1");
			member.setUsername("LE MEMBER");
			member.setTeam(team);

			LazyExamOrder8 order = new LazyExamOrder8();
			order.setMember(member);
			order.setProduct(product);

			LazyExamOrder8 otherOrder = new LazyExamOrder8();
			order.setMember(member);
			order.setProduct(product);

			Arrays.asList(product, team, member, order, otherOrder).forEach(em::persist);
		});
	}

	void setOrphanModel() {
		txt(em -> {
			OrphanParent8 parent = new OrphanParent8();
			OrphanChild8 child1 = new OrphanChild8();
			OrphanChild8 child2 = new OrphanChild8();

			parent.setId("parent1");
			child1.setParent(parent);
			child2.setParent(parent);
			Arrays.asList(parent, child1, child2).forEach(em::persist);
		});
	}

	@BeforeAll
	void before() {
		setProxyModel();
		setEagerModel();
		setLazyModel();
		setLazyExamModel();
		setOrphanModel();
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

	@Test @Order(4)
	void lazyTest() {
		txt(em -> {
			LazyMember8 member = em.find(LazyMember8.class, "member1");
			System.out.println(member.getUsername());
			System.out.println(member.getTeam().getName());
		});
	}

	@Test @Order(5)
	void lazyExamTest() {
		txt(em -> {
			LazyExamMember8 member = em.find(LazyExamMember8.class, "member1");
			List<LazyExamOrder8> orders = member.getOrders();
			System.out.printf("orders = %s\n", orders.getClass().getName());
			System.out.println(orders);
		});
	}

	@Test @Order(6)
	void saveNoCascade() {
		txt(em -> {
			NOCascadeParent8 parent = new NOCascadeParent8();
			NOCascadeChild8 child1 = new NOCascadeChild8();
			NOCascadeChild8 child2 = new NOCascadeChild8();

			child1.setParent(parent);
			child2.setParent(parent);

			Arrays.asList(parent, child1, child2).forEach(em::persist);
//			Arrays.asList(child1, child2).forEach(em::persist); // parent가 영속상태가 아니라서 오류
		});
	}

	@Test @Order(7)
	void saveCascade() {
		txt(em -> {
			CascadeParent8 parent = new CascadeParent8();
			CascadeChild8 child1 = new CascadeChild8();
			CascadeChild8 child2 = new CascadeChild8();

			child1.setParent(parent);
			child2.setParent(parent);
//			em.persist(parent);
			Arrays.asList(child1, child2).forEach(em::persist);
		});
	}

	@Test @Order(8)
	void orphanRemovalTest() {
		txt(em -> {
			OrphanParent8 parent = em.find(OrphanParent8.class, "parent1");
			parent.getChildren().remove(0); // TODO 왜 안지워지는가???
			parent.getChildren().forEach(c -> System.out.println(c.getId()));
			parent.getChildren().clear();	// 이것도 안지워짐.. 기능이 바뀐것인가?
//			em.remove(parent); // 여기서는 다 지우는데!

//			OrphanChild8 child1 = parent.getChildren().get(0);
//			child1.setParent(null);
		});
	}
}
