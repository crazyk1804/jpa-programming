package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class ProxyMember8 {
	@Id
	private String id;
	private String username;
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private ProxyTeam8 team;

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

	public ProxyTeam8 getTeam() {
		return team;
	}

	public void setTeam(ProxyTeam8 team) {
		this.team = team;
	}
}
