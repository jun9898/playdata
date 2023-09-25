package com.playdata.erp.board;

import java.sql.Date;

public class BoardDTO {
	private String  board_no;
	private String  id;
	private Date  write_date;
	private String title;
	private String content;
	private String category;

	public BoardDTO() {
//		System.out.println("기본생성자****************************************************************************************************************");
	}

	public BoardDTO(String board_no, String id, Date write_date, String title, String content, String category) {
		super();
		this.board_no = board_no;
		this.id = id;
		this.write_date = write_date;
		this.title = title;
		this.content = content;
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_no=" + board_no + ", id=" + id + ", write_date=" + write_date + ", title=" + title
				+ ", content=" + content + ", category=" + category + "]";
	}

	public String getBoard_no() {
//		System.out.println("getBoard_no===============================");
		return board_no;
	}

	public void setBoard_no(String board_no) {
//		System.out.println("setBoard_no===============================");
		this.board_no = board_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
