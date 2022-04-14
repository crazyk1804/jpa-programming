package net.crazyk.jpa.chapter09;

import net.crazyk.jpa.chapter09.domain.ValueTypeAddress9;
import net.crazyk.jpa.chapter09.domain.ValueTypeMember9;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static net.crazyk.jpa.WithTX.txt;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValueTypeTest {
	@Test
	void valueTypeMemberSaveTest() {
		txt(em -> {
			ValueTypeMember9 member = new ValueTypeMember9();
			member.setHomeAddress(new ValueTypeAddress9("CITY", "RED STREET", "588"));
			member.getFavoriteFoods().add("PSY");
			member.getFavoriteFoods().add("BLJ");
			member.getAddressHistory().add(new ValueTypeAddress9("What", "the", "FUCK"));
			member.getAddressHistory().add(new ValueTypeAddress9("Suck", "my", "balls"));
			em.persist(member);
		});
	}
}
