package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JOINTableMTMParent7 {
	@Id @GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	private String name;
	@ManyToMany
	@JoinTable(
		name = "JOINTableMTMParentChild7",
		joinColumns = @JoinColumn(name = "PARENT_ID"),
		inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
	)
	private List<JOINTableMTMChild7> children = new ArrayList<>();

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

	public List<JOINTableMTMChild7> getChildren() {
		return children;
	}

	public void setChildren(List<JOINTableMTMChild7> children) {
		this.children = children;
	}
}
