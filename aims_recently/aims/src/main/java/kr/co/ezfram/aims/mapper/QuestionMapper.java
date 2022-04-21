package kr.co.ezfram.aims.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ezfram.aims.vo.AnswerVo;
import kr.co.ezfram.aims.vo.QuestionVo;
import kr.co.ezfram.aims.vo.TokenVo;

@Mapper
@Repository
public interface QuestionMapper {
	
	public QuestionVo selectQuestion(String userId);
	
	public List<QuestionVo> selectQuestionList(QuestionVo questionVo);

	public void insertQuestionOpinion(QuestionVo QuestionVo);
	
	public void updateQuestionOpinion(QuestionVo QuestionVo);
	
}
