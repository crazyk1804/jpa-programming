package net.crazyk.jpa.chapter05.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team5 {
	public Team5() {

	}

	public Team5(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name = "TEAM_ID")
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
