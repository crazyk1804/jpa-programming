package net.crazyk.jpa.chapter08;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter08.domain.real.Delivery8;
import net.crazyk.jpa.chapter08.domain.real.Order8;
import net.crazyk.jpa.chapter08.domain.real.OrderItem8;

public class Chapter08Main extends WithTX {
	public static void main(String...args) {
		txt(em -> {
			Delivery8 delivery = new Delivery8();
			OrderItem8 orderItem1 = new OrderItem8();
			OrderItem8 orderItem2 = new OrderItem8();

			Order8 order = new Order8();
			order.setDelivery(delivery);
			order.addOrderItem(orderItem1);
			order.addOrderItem(orderItem2);
			em.persist(order);
		});
	}
}
