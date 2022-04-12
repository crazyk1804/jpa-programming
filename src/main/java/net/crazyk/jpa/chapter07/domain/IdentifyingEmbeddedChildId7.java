package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IdentifyingEmbeddedChildId7 implements Serializable {
	private String parentId;
	@Column(name="CHILD_ID")
	private String id;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
