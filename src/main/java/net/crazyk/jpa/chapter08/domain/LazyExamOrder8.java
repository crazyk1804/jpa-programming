package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class LazyExamOrder8 {
	@Id @GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private LazyExamMember8 member;
	@ManyToOne(fetch = FetchType.EAGER)
	private LazyExamProduct8 product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LazyExamMember8 getMember() {
		return member;
	}

	public void setMember(LazyExamMember8 member) {
		this.member = member;
	}

	public LazyExamProduct8 getProduct() {
		return product;
	}

	public void setProduct(LazyExamProduct8 product) {
		this.product = product;
	}
}
