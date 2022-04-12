package net.crazyk.jpa.chapter07.domain;

import java.io.Serializable;

/**
 * ID클래스는 Serializable 상속해야 하며 equals와 hashCode 구현해야 함
 * 여기는 귀찮아서 안함
 */
public class IDClassParentId7 implements Serializable {
	private String id1;
	private String id2;

	public IDClassParentId7() {}
	public IDClassParentId7(String id1, String id2) {
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
}
