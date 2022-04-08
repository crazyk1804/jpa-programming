package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RealCategory6 {
	@Id @GeneratedValue
	@Column(name="CATEGORY_ID")
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name="PARENT_ID")
	private RealCategory6 parent;
	@OneToMany(mappedBy="parent")
	private List<RealCategory6> children = new ArrayList<>();
	@ManyToMany
	@JoinTable(
		name="REAL_ITEM_CATEGORY",
		joinColumns = @JoinColumn(name="ITEM_ID"),
		inverseJoinColumns = @JoinColumn(name="CATEGORY_ID")
	)
	private List<RealItem6> items = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RealCategory6 getParent() {
		return parent;
	}

	public void setParent(RealCategory6 parent) {
		this.parent = parent;
	}

	public List<RealCategory6> getChildren() {
		return children;
	}

	public void setChildren(List<RealCategory6> children) {
		this.children = children;
	}

	public List<RealItem6> getItems() {
		return items;
	}

	public void setItems(List<RealItem6> items) {
		this.items = items;
	}

	public void addChildCategory(RealCategory6 child) {
		this.children.add(child);
		child.setParent(this);
	}
}
