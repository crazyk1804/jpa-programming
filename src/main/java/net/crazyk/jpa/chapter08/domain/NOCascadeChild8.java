package net.crazyk.jpa.chapter08.domain;

import javax.persistence.*;

@Entity
public class NOCascadeChild8 {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private NOCascadeParent8 parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NOCascadeParent8 getParent() {
		return parent;
	}

	public void setParent(NOCascadeParent8 parent) {
		if(this.parent!=null)
			this.parent.getChildren().remove(this);

		this.parent = parent;
		this.parent.getChildren().add(this);
	}
}
