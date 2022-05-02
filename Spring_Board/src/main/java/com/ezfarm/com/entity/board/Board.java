package com.ezfarm.com.entity.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.ezfarm.com.entity.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Entity(name="board")
public class Board extends BaseTimeEntity {
	  @Id
	  @Column(name="id")
	  @GeneratedValue(strategy=GenerationType.SEQUENCE)
	  @SequenceGenerator(name = "id2_Sequence", sequenceName = "id2_seq", allocationSize=1)
	  private int id;
	  private String title;
	  private String content;
	  private int readCnt;
	  private String registerId;
	  
	 @Builder 
	public Board(int id, String title, String content, int readCnt, String registerId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCnt = readCnt;
		this.registerId = registerId;
	}
	  
	  
	  

}
