package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;

@Entity
public class RealOrderItem6 {
	@Id @GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	private int orderPrice;
	private int count;
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private RealOrder6 order;
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private RealItem6 item;

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

	public RealOrder6 getOrder() {
		return order;
	}

	public void setOrder(RealOrder6 order) {
		this.order = order;
	}

	public RealItem6 getItem() {
		return item;
	}

	public void setItem(RealItem6 item) {
		this.item = item;
	}
}
