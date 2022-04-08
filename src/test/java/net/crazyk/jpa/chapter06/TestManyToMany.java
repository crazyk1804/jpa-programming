package net.crazyk.jpa.chapter06;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter06.domain.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestManyToMany extends WithTX {
	@Test @Order(1)
	void save() {
		tx(em -> {
			Product6 productA = new Product6();
			productA.setId("product1");
			productA.setName("PRODUCT A");
			em.persist(productA);

			Member6 member1 = new Member6();
			member1.setId("member1");
			member1.setUsername("MEMBER A");
			member1.getProducts().add(productA);
			em.persist(member1);
		}, true);
	}

	@Test @Order(2)
	void find() {
		tx(em -> {
			Member6 member = em.find(Member6.class, "member1");
			member.getProducts().forEach(p -> {
				System.out.println("product.name = " + p.getName());
			});
		}, true);
	}

	@Test @Order(3)
	void findInverse() {
		tx(em -> {
			Product6 product = em.find(Product6.class, "product1");
			product.getMembers().forEach(m -> {
				System.out.println("member.name = " + m.getUsername());
			});
		}, true);
	}

	@Test @Order(4)
	void complexSave() {
		tx(em -> {
			ComplexMember6 member = new ComplexMember6();
			member.setId("member1");
			member.setUsername("MEMBER A");
			em.persist(member);

			ComplexProduct6 product = new ComplexProduct6();
			product.setId("product1");
			product.setName("PRODUCT A");
			em.persist(product);

			ComplexMemberProduct6 memberProduct = new ComplexMemberProduct6();
			memberProduct.setMember(member);
			memberProduct.setProduct(product);
			memberProduct.setOrderAmount(2);
			em.persist(memberProduct);
		}, true);
	}

	@Test @Order(5)
	void complexFind() {
		tx(em -> {
			ComplexMemberProductId memberProductId = new ComplexMemberProductId();
			memberProductId.setMember("member1");
			memberProductId.setProduct("product1");
			ComplexMemberProduct6 memberProduct = em.find(ComplexMemberProduct6.class, memberProductId);

			ComplexMember6 member = memberProduct.getMember();
			ComplexProduct6 product = memberProduct.getProduct();
			System.out.println("member = " + member.getUsername());
			System.out.println("product = " + product.getName());
			System.out.println("orderAmount = " + memberProduct.getOrderAmount());
		}, true);
	}

	@Test @Order(6)
	void simpleSave() {
		tx(em -> {
			SimpleMember6 member = new SimpleMember6();
			member.setId("member1");
			member.setUsername("MEMBER A");
			em.persist(member);

			SimpleProduct6 product = new SimpleProduct6();
			product.setId("product1");
			product.setName("PRODUCT A");
			em.persist(product);

			SimpleOrder6 order = new SimpleOrder6();
			order.setMember(member);
			order.setProduct(product);
			order.setOrderAmount(2);
			em.persist(order);
		}, true);
	}

	@Test @Order(7)
	void simpleFind() {
		tx(em -> {
			Long orderId = 1L;
			SimpleOrder6 order = em.find(SimpleOrder6.class, orderId);
			SimpleMember6 member = order.getMember();
			SimpleProduct6 product = order.getProduct();

			System.out.println(member.getUsername());
			System.out.println(product.getName());
		}, true);
	}
}
