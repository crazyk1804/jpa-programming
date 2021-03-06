package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class EagerMember8 {
	@Id @Column(name = "MEMBER_ID")
	private String id;
	private String username;
	// inner join을 위한 nullable 설정
	// optional = false로 대체 가능
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_ID", nullable = false)
	private EagerTeam8 team;

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

	public EagerTeam8 getTeam() {
		return team;
	}

	public void setTeam(EagerTeam8 team) {
		this.team = team;
	}
}
