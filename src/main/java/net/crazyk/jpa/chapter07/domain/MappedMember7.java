package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Entity;

@Entity
public class MappedMember7 extends MappedBaseEntity7 {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
