package kr.co.ezfram.aims.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezfram.aims.mapper.TokenMapper;
import kr.co.ezfram.aims.service.LoginService;
import kr.co.ezfram.aims.vo.TokenVo;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
    private TokenMapper tokenMapper;
	
	
	@Override
	public TokenVo selectRefreshToken(String id) {
		return tokenMapper.selectRefreshToken(id);
	}

	@Override
	public int updateRefreshToken(TokenVo tokenVo) {
		return tokenMapper.updateRefreshToken(tokenVo);
	}
	
}
