package com.playdata.booterp.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("boardfile")
public class BoardFileDTO {
	private String board_no;
	private String originalFilename;
	private String storeFilename;
	private String boardFileorder;
	
}
