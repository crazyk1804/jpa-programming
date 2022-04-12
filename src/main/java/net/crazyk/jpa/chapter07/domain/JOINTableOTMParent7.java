package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class JOINTableOTMParent7 {
	@Id @GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	private String name;

	@OneToMany
	@JoinTable(
		name = "JOINTableOTMParentChild7",
		joinColumns = @JoinColumn(name = "PARENT_ID"),
		inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
	)
	private List<JOINTableOTMChild7> children;

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

	public List<JOINTableOTMChild7> getChildren() {
		return children;
	}

	public void setChildren(List<JOINTableOTMChild7> children) {
		this.children = children;
	}
}
