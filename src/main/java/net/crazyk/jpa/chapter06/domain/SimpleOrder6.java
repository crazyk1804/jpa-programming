package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;

@Entity
public class SimpleOrder6 {
	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	private int orderAmount;
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private SimpleMember6 member;
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private SimpleProduct6 product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public SimpleMember6 getMember() {
		return member;
	}

	public void setMember(SimpleMember6 member) {
		this.member = member;
	}

	public SimpleProduct6 getProduct() {
		return product;
	}

	public void setProduct(SimpleProduct6 product) {
		this.product = product;
	}
}
