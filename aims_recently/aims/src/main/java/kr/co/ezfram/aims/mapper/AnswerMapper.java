package kr.co.ezfram.aims.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ezfram.aims.vo.AnswerVo;
import kr.co.ezfram.aims.vo.TokenVo;

@Mapper
@Repository
public interface AnswerMapper {
	
	public AnswerVo selectAnswer(String id);

	public int insertAnswer(AnswerVo answerVo);
	
}
