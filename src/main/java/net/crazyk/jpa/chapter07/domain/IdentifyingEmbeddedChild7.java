package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class IdentifyingEmbeddedChild7 {
	@EmbeddedId
	private IdentifyingEmbeddedChildId7 id;
	@MapsId("parentId") @ManyToOne
	@JoinColumn(name="PARENT_ID")
	public IdentifyingEmbeddedParent7 parent;
}
