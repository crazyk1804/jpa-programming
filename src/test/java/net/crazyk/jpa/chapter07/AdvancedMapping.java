package net.crazyk.jpa.chapter07;

import net.crazyk.jpa.WithTX;
import net.crazyk.jpa.chapter07.domain.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdvancedMapping extends WithTX {
	@Test @Order(1)
	void IDClassSaveTest() {
		txt(em -> {
			IDClassParent7 parent = new IDClassParent7("id1", "id2");
			parent.setName("PARENT NAME");
			em.persist(parent);
		});
	}

	@Test @Order(2)
	void IDClassFindTest() {
		txt(em -> {
			IDClassParentId7 parentId = new IDClassParentId7("id1", "id2");
			IDClassParent7 parent = em.find(IDClassParent7.class, parentId);
			System.out.println(parent.getName());
		});
	}

	@Test @Order(3)
	void embeddedIDSaveTest() {
		txt(em -> {
			EmbeddedIDParent7 parent = new EmbeddedIDParent7(
				new EmbeddedIDParentID7("id1", "id2")
			);
			parent.setName("EMBEDDED PARENT");
			em.persist(parent);
		});
	}

	@Test @Order(4)
	void mebeddedIDFindTest() {
		txt(em -> {
			EmbeddedIDParent7 parent = em.find(EmbeddedIDParent7.class, new EmbeddedIDParentID7("id1", "id2"));
			System.out.println(parent.getName());
		});
	}

	@Test @Order(5)
	void identifyingOTOSaveTest() {
		txt(em -> {
			IdentifyingOTOBoard7 board = new IdentifyingOTOBoard7();
			board.setTitle("TITLE");

			IdentifyingOTOBoardDetail7 detail = new IdentifyingOTOBoardDetail7();
			detail.setContent("CONTENT");
			detail.setBoard(board);

			em.persist(board);
			em.persist(detail);
		});
	}
}
