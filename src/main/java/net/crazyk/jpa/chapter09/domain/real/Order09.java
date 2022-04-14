package net.crazyk.jpa.chapter09.domain.real;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order09 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus09 status;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member09 member;
	@OneToMany(mappedBy = "order")
	private List<OrderItem09> orderItems;

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

	public OrderStatus09 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus09 status) {
		this.status = status;
	}

	public Member09 getMember() {
		return member;
	}

	public void setMember(Member09 member) {
		this.member = member;
	}

	public List<OrderItem09> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem09> orderItems) {
		this.orderItems = orderItems;
	}
}
