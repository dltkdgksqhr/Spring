package kr.co.ezfram.aims.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import kr.co.ezfram.aims.elastic.ElasticResultMap;
import kr.co.ezfram.aims.vo.AnswerVo;
import kr.co.ezfram.aims.vo.QuestionVo;
import kr.co.ezfram.aims.vo.TokenVo;

public interface QnaService {
	
	public AnswerVo selectAnswer(AnswerVo answerVo);

	public void insertAnswer(AnswerVo answerVo);
	
	public QuestionVo selectQuestion(QuestionVo questionVo);
	
	public List<QuestionVo> selectQuestionList(QuestionVo questionVo);

	public void insertQuestionOpinion(QuestionVo QuestionVo);
	
	public void updateQuestionOpinion(QuestionVo QuestionVo);
	
	public ElasticResultMap getPdfParagraphResult(String question);
	
	public ElasticResultMap getArticleParagraphResult(String question);
	
	public ElasticResultMap getGuideParagraphResult(String question);
	
	public List<HashMap<String, Object>> getMrcResultMapList(String token, String question, List<Map<String, Object>> paragraphList, String searchType) throws Exception ;
	
	public List<Map<String, Object>> getAiadDocList(List<HashMap<String, Object>> mrcMapList) throws Exception;
	
	public List<Map<String, Object>> getRankedParagraphList(List<Map<String, Object>> paragraphSources);

	List<Map<String, Object>> getParagraphResultByDocId(List<Map<String, Object>> rankedMapList, String question) throws InterruptedException, ExecutionException;
	
	
	
	//public TokenVo selectRefreshToken(String id);
	
	//public int updateRefreshToken(TokenVo tokenVo);
	
}
