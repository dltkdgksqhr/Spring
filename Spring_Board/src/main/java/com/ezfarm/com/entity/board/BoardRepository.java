package com.ezfarm.com.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ezfarm.com.dto.board.BoardRequestDto;

public interface BoardRepository extends JpaRepository <Board, Integer> {
	
	String UPDATE_BOARD = "UPDATE board " +
	"SET TITLE = :#{#boardRequestDto.title}, " +
	"CONTENT = :#{#boardRequestDto.content}, " + 
	"UPATE_TIME = SYSDATE " + 
	"WHERE ID = :#{#boardRequestDto.id}";
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	int updateBoard(BoardRequestDto boardRequestDto);


}
