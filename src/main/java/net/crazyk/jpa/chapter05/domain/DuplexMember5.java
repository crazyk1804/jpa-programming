package net.crazyk.jpa.chapter05.domain;

import javax.persistence.*;

@Entity
public class DuplexMember5 {
	public DuplexMember5() {}
	public DuplexMember5(String id, String username) {
		this.id = id;
		this.userName = username;
	}

	@Id
	@Column(name="id")
	private String id;
	private String userName;
	@ManyToOne
	@JoinColumn(name="team_id")
	private DuplexTeam5 team;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public DuplexTeam5 getTeam() {
		return team;
	}

	public void setTeam(DuplexTeam5 team) {
		this.team = team;
	}
}
