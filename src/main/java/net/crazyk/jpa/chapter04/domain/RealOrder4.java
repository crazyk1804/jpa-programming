package net.crazyk.jpa.chapter04.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RealOrder4 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	@Column(name = "MEMBER_ID")
	private Long memberId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private RealOrderStatus4 status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public RealOrderStatus4 getStatus() {
		return status;
	}

	public void setStatus(RealOrderStatus4 status) {
		this.status = status;
	}
}
