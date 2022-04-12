package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "categories")
	private List<Item7> items;

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

	public List<Item7> getItems() {
		return items;
	}

	public void setItems(List<Item7> items) {
		this.items = items;
	}
}
