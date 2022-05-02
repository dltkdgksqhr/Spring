package com.ezfarm.com.dto.board;

import com.ezfarm.com.entity.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {

	private int id;
	private String title;
	private String content;
	private String registerId;
	
	public Board toEntity() {
		return Board.builder()
		.title(title)
		.content(content)
		.registerId(registerId)
		.build();
	}
	
}
