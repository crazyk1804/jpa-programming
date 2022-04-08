package net.crazyk.jpa.chapter06.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SimpleMember6 {
	@Id @Column(name="MEMBER_ID")
	private String id;
	private String username;
	@OneToMany(mappedBy = "member")
	private List<SimpleOrder6> orders = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SimpleOrder6> getOrders() {
		return orders;
	}

	public void setOrders(List<SimpleOrder6> orders) {
		this.orders = orders;
	}

	public void addOrder(SimpleOrder6 order) {
		this.orders.add(order);
		order.setMember(this);
	}
}
