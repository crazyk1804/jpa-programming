package net.crazyk.jpa.chapter07.domain;

import java.io.Serializable;

public class IdentifyingIDClassGrandChildId7 implements Serializable {
	private IdentifyingIDClassChildId7 child;
	private String id;

	public IdentifyingIDClassChildId7 getChild() {
		return child;
	}

	public void setChild(IdentifyingIDClassChildId7 child) {
		this.child = child;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
