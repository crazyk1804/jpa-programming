package net.crazyk.jpa.chapter08.domain.real;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category8 {
	@Id @GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;
	private String name;
	@ManyToMany
	@JoinTable(
		name = "CATEGORY_ITEM_8",
		joinColumns = @JoinColumn(name = "CATEGORY_ID"),
		inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)
	private List<Item8> items;

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

	public List<Item8> getItems() {
		return items;
	}

	public void setItems(List<Item8> items) {
		this.items = items;
	}
}
