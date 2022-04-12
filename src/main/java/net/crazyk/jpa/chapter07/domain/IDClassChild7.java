package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class IDClassChild7 {
	@Id
	private String id;
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
		@JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
	})
	private IDClassParent7 parent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IDClassParent7 getParent() {
		return parent;
	}

	public void setParent(IDClassParent7 parent) {
		this.parent = parent;
	}
}
