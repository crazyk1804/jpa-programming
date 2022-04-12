package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class JOINTableOTOParent7 {
	@Id @GeneratedValue
	@Column(name="PARENT_ID")
	private Long id;
	private String name;

	@OneToOne
	@JoinTable(
		name = "JOT_OTO_PARENT_CHILD",
		joinColumns = @JoinColumn(name="PARENT_ID"),
		inverseJoinColumns = @JoinColumn(name="CHILD_ID")
	)
	private JOINTableOTOChild7 child;

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

	public JOINTableOTOChild7 getChild() {
		return child;
	}

	public void setChild(JOINTableOTOChild7 child) {
		this.child = child;
	}
}
