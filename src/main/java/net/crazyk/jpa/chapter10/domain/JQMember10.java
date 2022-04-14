package net.crazyk.jpa.chapter10.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JQMember10 {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String username;
	private int age;
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private JQTeam10 team;
	@OneToMany(mappedBy = "member")
	private List<JQOrder10> orders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public JQTeam10 getTeam() {
		return team;
	}

	public void setTeam(JQTeam10 team) {
		this.team = team;
	}

	public List<JQOrder10> getOrders() {
		return orders;
	}

	public void setOrders(List<JQOrder10> orders) {
		this.orders = orders;
	}
}
