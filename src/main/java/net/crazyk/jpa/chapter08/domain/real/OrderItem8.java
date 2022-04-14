package net.crazyk.jpa.chapter08.domain.real;

import javax.persistence.*;

@Entity
public class OrderItem8 extends BaseEntity8 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	private int orderPrice;
	private int count;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order8 order;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item8 item;

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

	public Order8 getOrder() {
		return order;
	}

	public void setOrder(Order8 order) {
		this.order = order;
	}

	public Item8 getItem() {
		return item;
	}

	public void setItem(Item8 item) {
		this.item = item;
	}
}
