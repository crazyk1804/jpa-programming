package net.crazyk.jpa.chapter10.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JPQLMember10 {
	@Id @Column(name = "MEMBER_ID")
	private String id;
	@Column(name = "NAME")
	private String username;

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
}
