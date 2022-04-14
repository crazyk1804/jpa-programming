package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrphanParent8 {
	@Id
	private String id;
	@OneToMany(mappedBy = "parent", orphanRemoval = true)
	private List<OrphanChild8> children = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<OrphanChild8> getChildren() {
		return children;
	}

	public void setChildren(List<OrphanChild8> children) {
		this.children = children;
	}
}
