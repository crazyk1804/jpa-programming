package net.crazyk.jpa.chapter07.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 동일한 컬럼을 반복적으로 사용하게 되는 경우 유용함(FRST_REG_ID, FRST_REG_DT 등)
 */
@MappedSuperclass
public class MappedBaseEntity7 {
	@Id @GeneratedValue
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
