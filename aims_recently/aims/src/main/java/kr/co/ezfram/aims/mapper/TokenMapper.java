package kr.co.ezfram.aims.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ezfram.aims.vo.TokenVo;

@Mapper
@Repository
public interface TokenMapper {
	
	public TokenVo selectRefreshToken(String id);

	public int updateRefreshToken(TokenVo tokenVo);
	
}
