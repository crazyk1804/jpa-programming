package net.crazyk.jpa.chapter06.domain;

import java.io.Serializable;

public class ComplexMemberProductId implements Serializable {
	private String member;
	private String product;

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
}
