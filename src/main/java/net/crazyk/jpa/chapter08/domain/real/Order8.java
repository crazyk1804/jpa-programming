package net.crazyk.jpa.chapter08.domain.real;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order8 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus8 status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member8 member;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery8 delivery;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem8> orderItems = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus8 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus8 status) {
		this.status = status;
	}

	public Member8 getMember() {
		return member;
	}

	public void setMember(Member8 member) {
		this.member = member;
	}

	public Delivery8 getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery8 delivery) {
		this.delivery = delivery;
	}

	public List<OrderItem8> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem8> orderItems) {
		this.orderItems = orderItems;
	}

	public void addOrderItem(OrderItem8 orderItem) {
		if(this.orderItems.contains(orderItem)) return;

		this.orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
}
