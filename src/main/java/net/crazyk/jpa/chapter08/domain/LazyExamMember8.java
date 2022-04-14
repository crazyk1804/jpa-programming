package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LazyExamMember8 {
	@Id
	private String id;
	private String username;
	private Integer age;

	@ManyToOne(fetch = FetchType.EAGER)
	private LazyExamTeam8 team;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	private List<LazyExamOrder8> orders = new ArrayList<>();

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LazyExamTeam8 getTeam() {
		return team;
	}

	public void setTeam(LazyExamTeam8 team) {
		this.team = team;
	}

	public List<LazyExamOrder8> getOrders() {
		return orders;
	}

	public void setOrders(List<LazyExamOrder8> orders) {
		this.orders = orders;
	}
}
