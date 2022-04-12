package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class IdentifyingEmbeddedGrandChild7 {
	@EmbeddedId
	private IdentifyingEmbeddedGrandChildId7 id;
	@MapsId("child") @ManyToOne
	@JoinColumns({
		@JoinColumn(name="PARENT_ID"), @JoinColumn(name="CHILD_ID")
	})
	private IdentifyingEmbeddedChild7 child;
	private String name;

	public IdentifyingEmbeddedGrandChildId7 getId() {
		return id;
	}

	public void setId(IdentifyingEmbeddedGrandChildId7 id) {
		this.id = id;
	}

	public IdentifyingEmbeddedChild7 getChild() {
		return child;
	}

	public void setChild(IdentifyingEmbeddedChild7 child) {
		this.child = child;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
