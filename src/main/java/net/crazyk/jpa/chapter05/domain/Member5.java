package net.crazyk.jpa.chapter05.domain;

import javax.persistence.*;

@Entity
public class Member5 {

	public Member5() {}

	public Member5(String id, String username) {
		this.id = id;
		this.username = username;
	}

	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String username;
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team5 team;

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

	public Team5 getTeam() {
		return team;
	}

	public void setTeam(Team5 team) {
		this.team = team;
	}
}
