package net.crazyk.jpa.chapter06.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RealItem6 {
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	private String name;
	private int price;
	private int stockQuantity;
	@ManyToMany(mappedBy="items")
	private List<RealCategory6> categories = new ArrayList<>();

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<RealCategory6> getCategories() {
		return categories;
	}

	public void setCategories(List<RealCategory6> categories) {
		this.categories = categories;
	}
}
