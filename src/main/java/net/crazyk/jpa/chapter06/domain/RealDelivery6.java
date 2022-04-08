package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;

@Entity
public class RealDelivery6 {
	@Id @GeneratedValue
	@Column(name="DELIVERY_ID")
	private Long id;
	private String city;
	private String street;
	private String zipcode;
	@Enumerated(EnumType.STRING)
	private RealDeliveryStatus6 status;
	@OneToOne(mappedBy="delivery")
	private RealOrder6 order;

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

	public RealDeliveryStatus6 getStatus() {
		return status;
	}

	public void setStatus(RealDeliveryStatus6 status) {
		this.status = status;
	}

	public RealOrder6 getOrder() {
		return order;
	}

	public void setOrder(RealOrder6 order) {
		this.order = order;
	}
}
