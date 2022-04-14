package net.crazyk.jpa.chapter09.domain.real;

import javax.persistence.*;

@Entity
public class Delivery09 {
	@Id @GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;
	@Embedded
	private Address09 address;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus09 status;
	@OneToOne
	@JoinColumn(name = "ORDER_ID")
	private Order09 order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address09 getAddress() {
		return address;
	}

	public void setAddress(Address09 address) {
		this.address = address;
	}

	public DeliveryStatus09 getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus09 status) {
		this.status = status;
	}

	public Order09 getOrder() {
		return order;
	}

	public void setOrder(Order09 order) {
		this.order = order;
	}
}
