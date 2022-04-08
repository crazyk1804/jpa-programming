package net.crazyk.jpa.chapter05.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DuplexTeam5 {
	public DuplexTeam5() {}
	public DuplexTeam5(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name="team_id")
	private String id;
	private String name;
	@OneToMany(mappedBy="team")
	private List<DuplexMember5> members = new ArrayList<>();

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

	public List<DuplexMember5> getMembers() {
		return members;
	}

	public void setMembers(List<DuplexMember5> members) {
		this.members = members;
	}
}
