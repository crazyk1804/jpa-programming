package net.crazyk.jpa.chapter06.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ComplexMember6 {
	@Id @Column(name="MEMBER_ID")
	private String id;
	private String username;
	@OneToMany(mappedBy="member")
	private List<ComplexMemberProduct6> memberProducts = new ArrayList<>();

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

	public List<ComplexMemberProduct6> getMemberProducts() {
		return memberProducts;
	}

	public void setMemberProducts(List<ComplexMemberProduct6> memberProducts) {
		this.memberProducts = memberProducts;
	}
}
