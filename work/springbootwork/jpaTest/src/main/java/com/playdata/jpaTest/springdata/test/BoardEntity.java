package com.playdata.jpaTest.springdata.test;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board")
public class BoardEntity {
	@Id @GeneratedValue
	private Long boardNo;
	private String writer;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;
	private String title;
	private String content;

	public BoardEntity(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardEntity [boardNo=" + boardNo + ", write=" + writer + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", title=" + title + ", content=" + content + "]";
	}

}
