package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(IDClassParentId7.class)
public class IDClassParent7 {
	@Id @Column(name="PARENT_ID1")
	private String id1;
	@Id @Column(name="PARENT_ID2")
	private String id2;
	private String name;

	public IDClassParent7() {}
	public IDClassParent7(String id1, String id2) {
		this.id1 = id1;
		this.id2 = id2;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
