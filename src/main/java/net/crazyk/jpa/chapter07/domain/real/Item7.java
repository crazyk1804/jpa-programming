package net.crazyk.jpa.chapter07.domain.real;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item7 extends BaseEntity7 {
	@Id @GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	private String name;
	private int price;
	private int stockQuantity;
	@ManyToMany
	@JoinTable(
		name = "CATEGORY_ITEM_7",
		joinColumns = @JoinColumn(name = "ITEM_ID"),
		inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
	)
	private List<Category7> categories;

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

	public List<Category7> getCategories() {
		return categories;
	}

	public void setCategories(List<Category7> categories) {
		this.categories = categories;
	}
}
