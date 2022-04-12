package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class JOINTableMTOParent7 {
	@Id @GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	private String name;
	@OneToMany(mappedBy = "parent")
	private List<JOINTableMTOChild7> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JOINTableMTOChild7> getChildren() {
		return children;
	}

	public void setChildren(List<JOINTableMTOChild7> children) {
		this.children = children;
	}
}
