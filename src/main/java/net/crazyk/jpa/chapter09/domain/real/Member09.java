package net.crazyk.jpa.chapter09.domain.real;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member09 {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	@Embedded
	private Address09 address;
	@OneToMany(mappedBy = "member")
	private List<Order09> orders = new ArrayList<>();

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

	public Address09 getAddress() {
		return address;
	}

	public void setAddress(Address09 address) {
		this.address = address;
	}

	public List<Order09> getOrders() {
		return orders;
	}

	public void setOrders(List<Order09> orders) {
		this.orders = orders;
	}
}
