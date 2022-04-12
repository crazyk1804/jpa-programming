package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	@OneToMany(mappedBy = "member")
	private List<Order7> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Order7> getOrders() {
		return orders;
	}

	public void setOrders(List<Order7> orders) {
		this.orders = orders;
	}
}
