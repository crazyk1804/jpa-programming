package net.crazyk.jpa.chapter07.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * IDClas 와 마찬가지로 Serializable 구현
 */
@Embeddable
public class EmbeddedIDParentID7 implements Serializable {
	public EmbeddedIDParentID7() {}
	public EmbeddedIDParentID7(String id1, String id2) {
		this.id1 = id1;
		this.id2 = id2;
	}

	@Column(name="PARENT_ID1")
	private String id1;
	@Column(name="PARENT_ID2")
	private String id2;

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
