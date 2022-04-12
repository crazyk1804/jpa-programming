package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
@IdClass(IdentifyingIDClassChildId7.class)
public class IdentifyingIDClassChild7 {
	@Id @Column(name="CHILD_ID")
	private String id;
	@Id
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private IdentifyingIDClassParent7 parent;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentifyingIDClassParent7 getParent() {
		return parent;
	}

	public void setParent(IdentifyingIDClassParent7 parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
