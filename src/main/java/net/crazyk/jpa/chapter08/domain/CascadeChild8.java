package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class CascadeChild8 {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private CascadeParent8 parent;

	public CascadeParent8 getParent() {
		return parent;
	}

	public void setParent(CascadeParent8 parent) {
		if(this.parent!=null)
			this.parent.getChildren().remove(this);

		this.parent = parent;
		this.parent.getChildren().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
