package kr.co.ezfram.aims.service;

import java.util.List;

import kr.co.ezfram.aims.vo.UserVo;

public interface UserService {
	
	public void insertUser(UserVo userVo);
	
	public UserVo selectUserById(String userId);
	
	public List<UserVo> selectUserList(UserVo userVo);
	
	public void updateUser(UserVo userVo);
}
