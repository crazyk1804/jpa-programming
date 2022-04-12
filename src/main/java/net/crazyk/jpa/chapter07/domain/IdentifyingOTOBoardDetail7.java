package net.crazyk.jpa.chapter07.domain;

import javax.persistence.*;

@Entity
public class IdentifyingOTOBoardDetail7 {
	@Id
	private Long boardId;
	@MapsId @OneToOne
	@JoinColumn(name="BOARD_ID")
	private IdentifyingOTOBoard7 board;
	private String content;

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public IdentifyingOTOBoard7 getBoard() {
		return board;
	}

	public void setBoard(IdentifyingOTOBoard7 board) {
		this.board = board;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
