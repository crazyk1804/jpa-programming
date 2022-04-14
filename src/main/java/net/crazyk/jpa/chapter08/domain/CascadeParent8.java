package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CascadeParent8 {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.PERSIST)
	private List<CascadeChild8> children = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CascadeChild8> getChildren() {
		return children;
	}

	public void setChildren(List<CascadeChild8> children) {
		this.children = children;
	}
}
