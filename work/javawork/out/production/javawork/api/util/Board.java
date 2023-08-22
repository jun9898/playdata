package api.util;

import java.util.Date;

public class Board {
	private int boardNo;
	private String writer, title, contents;
	private int hit;
	private Date date;
	public Board() {
		// TODO Auto-generated constructor stub
	}
		
	//insert용
	public Board(int boardNo, String writer, String title, String contents) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}

	//select용
	public Board(int boardNo, String writer, String title, String contents, int hit, Date date) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.hit = hit;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", hit=" + hit + ", date=" + date + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
