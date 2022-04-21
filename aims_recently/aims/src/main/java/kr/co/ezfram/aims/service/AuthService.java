package kr.co.ezfram.aims.service;

import kr.co.ezfram.aims.vo.TokenVo;

public interface AuthService {
	
	public TokenVo selectRefreshToken(String id);
	
	public int updateRefreshToken(TokenVo tokenVo);
	
}
