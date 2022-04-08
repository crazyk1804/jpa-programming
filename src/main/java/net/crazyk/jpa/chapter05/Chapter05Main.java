package net.crazyk.jpa.chapter05;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter05.domain.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Chapter05Main extends WithTX {
	public static void before() {
		tx(em -> {
			RealMember5 member = new RealMember5();
			member.setName("나야나");

			RealItem5 item = new RealItem5();
			item.setName("Product!!");

			RealOrder5 order = new RealOrder5();
			order.setOrderDate(new Date());
			order.setMember(member);
			order.setStatus(RealOrderStatus5.ORDER);

			RealOrderItem5 orderItem = new RealOrderItem5();
			orderItem.setOrder(order);
			orderItem.setItem(item);
			orderItem.setCount(1);
			orderItem.setOrderPrice(item.getPrice() * orderItem.getCount());

			em.persist(member);
			em.persist(item);
			em.persist(order);
			em.persist(orderItem);
		});
	}

	public static void main(String...args) {
		before();
		
		tx(em -> {
			RealOrder5 order = em.createQuery(
				"select o from RealOrder5 o",
					RealOrder5.class
			).getResultList().get(0);
			RealMember5 member = order.getMember();

			System.out.println("주문자: " + member.getName());
			order.getOrderItems().forEach(oi -> {
				System.out.println(String.format(
					"상품: %s, 수량: %d, 결제금액: %d",
					oi.getItem().getName(),
					oi.getCount(),
					oi.getOrderPrice()
				));
			});
		});
	}

}
