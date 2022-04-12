package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
@IdClass(IdentifyingIDClassGrandChildId7.class)
public class IdentifyingIDClassGrandChild7 {
	@Id @Column(name="GRAND_CHILD_ID")
	private String id;
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID"),
		@JoinColumn(name = "CHILD_ID")
	})
	private IdentifyingIDClassChild7 child;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentifyingIDClassChild7 getChild() {
		return child;
	}

	public void setChild(IdentifyingIDClassChild7 child) {
		this.child = child;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
