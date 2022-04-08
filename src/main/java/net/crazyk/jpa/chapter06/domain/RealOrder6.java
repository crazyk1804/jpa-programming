package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RealOrder6 {
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private RealOrderStatus6 status;
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private RealMember6 member;
	@OneToOne
	@JoinColumn(name="DELIVERY_ID")
	private RealDelivery6 delivery;

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

	public RealOrderStatus6 getStatus() {
		return status;
	}

	public void setStatus(RealOrderStatus6 status) {
		this.status = status;
	}

	public RealMember6 getMember() {
		return member;
	}

	public void setMember(RealMember6 member) {
		if(this.member!=null)
			this.member.getOrders().remove(this);

		this.member = member;
		member.getOrders().add(this);
	}

	public RealDelivery6 getDelivery() {
		return delivery;
	}

	public void setDelivery(RealDelivery6 delivery) {
		if(this.delivery!=null) {
			delivery.setOrder(null);
		}
		this.delivery = delivery;
		delivery.setOrder(this);
	}
}
