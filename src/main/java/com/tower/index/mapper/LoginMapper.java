package com.tower.index.mapper;

import com.tower.system.bean.SysUser;



public interface LoginMapper {

	//用户登录验证
	public SysUser checkSysUserLogin(SysUser sysuser);
	
	//更新用户的最后登录时间
	public int updateUserLastTime(int userid);
	
	//修改用户密码
	public int updateUserPassword(SysUser sysuser);
	
	//修改用户信息
	public int updateUserInfo(SysUser sysuser);
}
