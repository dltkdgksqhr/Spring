package com.ezfarm.com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezfarm.com.dto.board.BoardRequestDto;
import com.ezfarm.com.dto.board.BoardResponseDto;
import com.ezfarm.com.entity.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final BoardRepository boardRepository;
	
	@Transactional
	public int save(BoardRequestDto boardSaveDto) {
		return boardRepository.save(boardSaveDto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List <BoardResponseDto> findAll() {
	  return boardRepository.findAll().stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}
	
	public BoardResponseDto findById(int id) {
		return new BoardResponseDto(boardRepository.findById(id).get());
	}
	
	public int updateBoard(BoardRequestDto boardRequestDto) {
		return boardRepository.updateBoard(boardRequestDto);
	}
	
	public void deleteById(int id) {
	  boardRepository.deleteById(id);
	}

}
