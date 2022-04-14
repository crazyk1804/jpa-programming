package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class OrphanChild8 {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private OrphanParent8 parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrphanParent8 getParent() {
		return parent;
	}

	public void setParent(OrphanParent8 parent) {
		this.parent = parent;
//		if(this.parent!=null)
//			this.parent.getChildren().remove(this);
//
//		this.parent = parent;
//		this.parent.getChildren().add(this);
	}
}
