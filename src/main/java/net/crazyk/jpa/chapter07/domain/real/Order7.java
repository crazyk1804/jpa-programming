package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus7 status;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member7 member;
	@OneToOne
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery7 delivery;
	@OneToMany(mappedBy = "order")
	private List<OrderItem7> orderItems = new ArrayList<>();

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

	public OrderStatus7 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus7 status) {
		this.status = status;
	}

	public Member7 getMember() {
		return member;
	}

	public void setMember(Member7 member) {
		if(this.member != null) {
			member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}

	public Delivery7 getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery7 delivery) {
		if(this.delivery!=null)
			this.delivery.setOrder(null);
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	public List<OrderItem7> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem7> orderItems) {
		this.orderItems = orderItems;
	}
}
