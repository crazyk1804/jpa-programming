package net.crazyk.jpa.chapter08.domain.real;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorColumn(name="DTYPE")
public class Item8 extends BaseEntity8 {
	@Id @GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	private String name;
	private int price;
	private int stockQuantity;
	@ManyToMany(mappedBy = "items")
	private List<Category8> categories;

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

	public List<Category8> getCategories() {
		return categories;
	}

	public void setCategories(List<Category8> categories) {
		this.categories = categories;
	}
}
