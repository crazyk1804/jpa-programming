package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;

@Entity
public class OrderItem7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	private int orderPrice;
	private int count;
	@ManyToOne @JoinColumn(name = "ORDER_ID")
	private Order7 order;
	@ManyToOne @JoinColumn(name = "ITEM_ID")
	private Item7 item;

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

	public Order7 getOrder() {
		return order;
	}

	public void setOrder(Order7 order) {
		if(this.order!=null)
			this.order.getOrderItems().remove(this);

		this.order = order;
		if(!order.getOrderItems().contains(this))
			order.getOrderItems().add(this);
	}

	public Item7 getItem() {
		return item;
	}

	public void setItem(Item7 item) {
		this.item = item;
	}
}
