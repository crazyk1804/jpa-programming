package net.crazyk.jpa.chapter07.domain;

import java.io.Serializable;

public class IdentifyingIDClassChildId7 implements Serializable {
	private String parent;
	private String id;

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
