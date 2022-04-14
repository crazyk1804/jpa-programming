package net.crazyk.jpa.chapter10.domain;

import javax.persistence.*;

@Entity
public class JQOrder10 {
	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	private int orderAmount;
	@Embedded
	private JQAddress10 address;
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private JQMember10 member;
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private JQProduct10 product;

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

	public JQAddress10 getAddress() {
		return address;
	}

	public void setAddress(JQAddress10 address) {
		this.address = address;
	}

	public JQMember10 getMember() {
		return member;
	}

	public void setMember(JQMember10 member) {
		this.member = member;
	}

	public JQProduct10 getProduct() {
		return product;
	}

	public void setProduct(JQProduct10 product) {
		this.product = product;
	}
}
