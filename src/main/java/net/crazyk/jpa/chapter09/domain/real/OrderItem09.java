package net.crazyk.jpa.chapter09.domain.real;

import javax.persistence.*;

@Entity
public class OrderItem09 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	private int orderPrice;
	private int count;
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order09 order;
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item09 item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Order09 getOrder() {
		return order;
	}

	public void setOrder(Order09 order) {
		this.order = order;
	}

	public Item09 getItem() {
		return item;
	}

	public void setItem(Item09 item) {
		this.item = item;
	}
}
