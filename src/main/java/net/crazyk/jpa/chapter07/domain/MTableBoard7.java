package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
@Table(name = "MTABLE_BOARD_7")
@SecondaryTable(
	name = "MTABLE_BOARD_DETAIL7",
	pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID")
)
public class MTableBoard7 {
	@Id @GeneratedValue
	@Column(name = "BOARD_ID")
	private Long id;
	private String title;
	@Column(table = "MTABLE_BOARD_DETAIL7")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
