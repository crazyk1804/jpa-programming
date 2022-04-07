package net.crazyk.jpa.chapter04.domain;

import javax.persistence.*;

@Entity
@SequenceGenerator(
	name = "BOARD_SEQ_GENERATOR",
	sequenceName = "BOARD_SEQ",
	initialValue = 1,
	allocationSize = 1
)
public class Board4 {
	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="BOARD_SEQ_GENERATOR")
	private long id;

}
