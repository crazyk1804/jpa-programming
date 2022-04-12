package net.crazyk.jpa.chapter07.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddedIDParent7 {
	public EmbeddedIDParent7() {}
	public EmbeddedIDParent7(EmbeddedIDParentID7 id) {
		this.id = id;
	}

	@EmbeddedId
	private EmbeddedIDParentID7 id;
	private String name;

	public EmbeddedIDParentID7 getId() {
		return id;
	}

	public void setId(EmbeddedIDParentID7 id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
