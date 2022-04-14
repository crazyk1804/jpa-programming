package net.crazyk.jpa.chapter10;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter01.domain.Member;
import net.crazyk.jpa.chapter10.domain.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PrerequisiteTest extends WithTX {
	int getRandomIndex(List<?> list) {
		return (int)(Math.random() * list.size());
	}

	void setMembers() {
		txt(em -> {
			List<JQTeam10> teams = Arrays.asList(new JQTeam10(), new JQTeam10(), new JQTeam10());
			teams.forEach(t -> {
				t.setName(String.format("TEAM %d", teams.indexOf(t)));
				em.persist(t);
			});

			for(int i=1 ; i<=10 ; i++) {
				JQMember10 member = new JQMember10();
				member.setUsername(String.format("MEMBER %d", i));
				member.setAge(i);
				member.setTeam(teams.get((int) (Math.random() * teams.size())));
				em.persist(member);
			}
		});
	}

	void setProducts() {
		txt(em -> {
			for(int i=1 ; i<=100 ; i++) {
				JQProduct10 product = new JQProduct10();
				product.setName(String.format("PRODUCT %d", i));
				product.setPrice(100 * i);
				product.setStockAmount(i);
				em.persist(product);
			}
		});
	}

	void setOrders() {
		List<String> zips = Arrays.asList("000", "111", "222");
		Map<String, String> cityMap = zips.stream()
			.collect(Collectors.toMap(zip -> zip, zip -> "CITY " + zip));


		txt(em -> {
			List<JQMember10> members = em
				.createQuery("select m from JQMember10 m", JQMember10.class).getResultList();
			List<JQProduct10> products = em
				.createQuery("select p from JQProduct10 p", JQProduct10.class).getResultList();

			for(int i=1 ; i<50 ; i++) {
				JQOrder10 order = new JQOrder10();
				int idx = (int) (Math.random() * cityMap.size());
				JQAddress10 address = new JQAddress10();
				address.setZipcode(zips.get(idx));
				address.setCity(cityMap.get(zips.get(idx)));
				address.setStreet(String.format("STREET #%s", zips.get(idx)));
				order.setAddress(address);
				order.setOrderAmount(i);
				order.setMember(members.get(getRandomIndex(members)));
				order.setProduct(products.get(getRandomIndex(products)));
				em.persist(order);
			}
		});
	}

	@BeforeAll
	void setData() {
		setMembers();
		setProducts();
		setOrders();
//		txt(em -> {
//			List<String> list = Arrays.asList("JJH", "BJ");
//			list.forEach(n -> {
//				JPQLMember10 member = new JPQLMember10();
//				member.setId(String.format("member%d", list.indexOf(n)));
//				member.setUsername(n);
//				em.persist(member);
//			});
//		});
	}

//	@Test @Order(1)
//	void findJPQLMember() {
//		txt(em -> {
//			String jpql = "select m from JPQLMember10 m where m.username = 'BJ'";
//			em.createQuery(jpql, JPQLMember10.class)
//				.getResultList().forEach(m -> System.out.println(m.getUsername()));
//		});
//	}
//
//	@Test @Order(2)
//	void findCriteriaMember() {
//		txt(em -> {
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<JPQLMember10> query = cb.createQuery(JPQLMember10.class);
//			Root<JPQLMember10> m = query.from(JPQLMember10.class);
//
//			CriteriaQuery<JPQLMember10> cq = query
//				.select(m).where(cb.equal(m.get("username"), "BJ"));
//			em.createQuery(cq).getResultList().forEach(member -> System.out.println(member.getUsername()));
//		});
//	}
//
//	@Test @Order(3)
//	void findCriteriaMemberViaMetaModel() {
//		txt(em -> {
//			CriteriaBuilder builder = em.getCriteriaBuilder();
//			CriteriaQuery<JPQLMember10> query = builder.createQuery(JPQLMember10.class);
//			Root<JPQLMember10> root = query.from(JPQLMember10.class);
//
//			em.createQuery(query
//				.select(root)
////				.where(builder.equal(root.get(JPQLMember10_.username), "BJ")) // 오류나는데 아직 설명이 없다
//			).getResultList().forEach(member -> System.out.println(member.getUsername()));
//		});
//	}
//
//	@Test @Order(4)
//	void findQDSLMember() {
//		txt(em -> {
////			JPAQuery queyr = new JPAQuery(em); // todo 라이브러리 준비 안됐다
//		});
//	}
//
//	@Test @Order(5)
//	void findNativeMember() {
//		txt(em -> {
//			String sql = new StringBuilder()
//				.append("SELECT				MEMBER_ID	")
//				.append("		,			NAME	")
//				.append("FROM				JPQLMEMBER10	")
//				.append("WHERE				NAME = 'BJ'	").toString();
//			List list = em.createNativeQuery(sql, JPQLMember10.class).getResultList();
//			list.forEach(m -> {
//				JPQLMember10 member = (JPQLMember10) m;
//				System.out.println(member.getUsername());
//			});
//
//		});
//	}
}
