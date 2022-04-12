package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class JOINTableMTOChild7 {
	@Id @GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;
	private String name;
	@ManyToOne
	@JoinTable(
		name = "JOINTableMTOParentChild7",
		joinColumns = @JoinColumn(name="CHILD_ID"),
		inverseJoinColumns = @JoinColumn(name = "PARENT_ID")
	)
	private JOINTableMTOParent7 parent;

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

	public JOINTableMTOParent7 getParent() {
		return parent;
	}

	public void setParent(JOINTableMTOParent7 parent) {
		this.parent = parent;
	}
}
