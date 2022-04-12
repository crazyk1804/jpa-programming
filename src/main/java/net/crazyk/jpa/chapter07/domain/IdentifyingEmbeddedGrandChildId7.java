package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class IdentifyingEmbeddedGrandChildId7 implements Serializable {
	@Embedded
	private IdentifyingEmbeddedChildId7 child;
	@Column(name="GRAND_CHILD_ID")
	private String id;

	public IdentifyingEmbeddedChildId7 getChild() {
		return child;
	}

	public void setChild(IdentifyingEmbeddedChildId7 child) {
		this.child = child;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
