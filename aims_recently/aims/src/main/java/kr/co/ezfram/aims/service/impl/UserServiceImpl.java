package kr.co.ezfram.aims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ezfram.aims.mapper.RoleMapper;
import kr.co.ezfram.aims.mapper.UserMapper;
import kr.co.ezfram.aims.service.UserService;
import kr.co.ezfram.aims.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	RoleMapper roleMapper;
	
	
	@Transactional
	@Override
	public void insertUser(UserVo userVo) {
		userMapper.insertUser(userVo);
		roleMapper.insertRolesByUserSeq(userVo);
	}

	@Override
	public UserVo selectUserById(String userId) {
		return userMapper.selectUserById(userId);
	}

	@Override
	public List<UserVo> selectUserList(UserVo userVo) {
		return userMapper.selectUserList(userVo);
	}
	
	@Override
	public void updateUser(UserVo userVo) {
		userMapper.updateUser(userVo);
	}
	
	
	
	
	
}
