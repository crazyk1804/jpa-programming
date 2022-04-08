package net.crazyk.jpa.chapter05.domain;

import net.crazyk.jpa.chapter04.domain.RealOrderStatus4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class RealOrder5 {
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private RealOrderStatus5 status;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID")
	private RealMember5 member;
	@OneToMany(mappedBy="order")
	private List<RealOrderItem5> orderItems = new ArrayList<>();

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

	public RealOrderStatus5 getStatus() {
		return status;
	}

	public void setStatus(RealOrderStatus5 status) {
		this.status = status;
	}

	public RealMember5 getMember() {
		return member;
	}

	public void setMember(RealMember5 member) {
		// EntityManager가 같은 인스턴스일때
		// 한쪽 관계만 정리하면 다른쪽에서 불일치 될 수도 있다.
		if(this.member!=null) {
			this.member.getOrders().remove(this);
		}
		member.getOrders().add(this);
		this.member = member;
	}

	public List<RealOrderItem5> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<RealOrderItem5> orderItems) {
		this.orderItems = orderItems;
	}
}
