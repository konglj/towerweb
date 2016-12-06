package com.tower.system.service.impl;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.system.bean.SysUser;
import com.tower.system.mapper.SysMapper;
import com.tower.system.service.SysService;

@Service
public class SysServiceImpl implements SysService {

	@Autowired
	private SysMapper sysMapper;
	
	@Override
	public SysUser getSysUserInfoByPwd(Map<String, Object> map) {
		return sysMapper.getSysUserInfoByPwd(map);
	}

	@Override
	public int updatePwd(Map<String, Object> map) {
		
		return sysMapper.updatePwd(map);
	}

	@Override
	public int updateSysUserInfo(Map<String,Object> map) {
		
		return sysMapper.updateSysUserInfo(map);
	}

	@Override
	public int insertSysUser(SysUser sysUser) {
		
		return sysMapper.insertSysUser(sysUser);
	}

	@Override
	public int delSysUser(int id) {
		
		return sysMapper.delSysUser(id);
	}

	@Override
	public int updateUserDlTime(int id) {
		
		return sysMapper.updateUserDlTime(id);
	}

}
