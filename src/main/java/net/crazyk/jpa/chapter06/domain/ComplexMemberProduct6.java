package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;

@Entity
@IdClass(ComplexMemberProductId.class) // 복합키는 식별자 클래스를 별도로 만들어야 한다.
public class ComplexMemberProduct6 {
	@Id
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private ComplexMember6 member;
	@Id
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private ComplexProduct6 product;

	private int orderAmount;

	public ComplexMember6 getMember() {
		return member;
	}

	public void setMember(ComplexMember6 member) {
		this.member = member;
	}

	public ComplexProduct6 getProduct() {
		return product;
	}

	public void setProduct(ComplexProduct6 product) {
		this.product = product;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
}
