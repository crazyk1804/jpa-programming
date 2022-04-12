package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Entity;

@Entity
public class MappedSeller7 extends MappedBaseEntity7 {
	private String shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
}
