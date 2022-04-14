package net.crazyk.jpa.chapter09.domain.real;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category09 {
	@Id @GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "PARENT_CATEGORY_ID")
	private Category09 parent;
	@OneToMany(mappedBy = "parent")
	private List<Category09> children;
	@ManyToMany(mappedBy = "categories")
	private List<Item09> items;

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

	public Category09 getParent() {
		return parent;
	}

	public void setParent(Category09 parent) {
		this.parent = parent;
	}

	public List<Category09> getChildren() {
		return children;
	}

	public void setChildren(List<Category09> children) {
		this.children = children;
	}

	public List<Item09> getItems() {
		return items;
	}

	public void setItems(List<Item09> items) {
		this.items = items;
	}
}
