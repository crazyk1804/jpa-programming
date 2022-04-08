package net.crazyk.jpa.chapter05.domain;

import javax.persistence.*;

@Entity
public class RealOrderItem5 {
	@Id @GeneratedValue
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	private int orderPrice;
	private int count;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ORDER_ID")
	private RealOrder5 order;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ITEM_ID")
	private RealItem5 item;

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

	public RealOrder5 getOrder() {
		return order;
	}

	public void setOrder(RealOrder5 order) {
		if(this.order!=null) {
			this.order.getOrderItems().remove(this);
		}
		this.order = order;
		order.getOrderItems().add(this);
	}

	public RealItem5 getItem() {
		return item;
	}

	public void setItem(RealItem5 item) {
		this.item = item;
	}
}
