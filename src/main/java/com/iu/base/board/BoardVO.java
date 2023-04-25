package com.iu.base.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	
		private Long num;
		@NotBlank
		@Size(min = 5, max=20)
		private String title;
		
		private String contents;
		@NotBlank
		private String writer;
		private Date regDate;
		private Long hit;
		private List<BoardFileVO> boardFileVOs;
		private SubVO subVO;
//		private String [] names;
		private List<String> names;
}
