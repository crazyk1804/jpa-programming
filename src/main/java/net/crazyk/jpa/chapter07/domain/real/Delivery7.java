package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;

@Entity
public class Delivery7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;
	private String city;
	private String street;
	private String zipcode;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus7 status;
	@OneToOne(mappedBy = "delivery")
	private Order7 order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public DeliveryStatus7 getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus7 status) {
		this.status = status;
	}

	public Order7 getOrder() {
		return order;
	}

	public void setOrder(Order7 order) {
		this.order = order;
	}
}
