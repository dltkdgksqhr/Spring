package kr.co.ezfram.aims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezfram.aims.mapper.RoleMapper;
import kr.co.ezfram.aims.service.RoleService;
import kr.co.ezfram.aims.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<RoleVo> selectRoles() {
		return roleMapper.selectRoles();
	}	
	
}
