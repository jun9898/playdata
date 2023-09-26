package com.playdata.erp.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardFileDTO {
	private String boardno;
	private String originalFilename;
	private String storeFilename;
	private String boardfileorder;
	
}
