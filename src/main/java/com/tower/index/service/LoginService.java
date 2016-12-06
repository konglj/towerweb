package com.tower.index.service;

import java.util.Map;

import com.tower.system.bean.SysUser;


public interface LoginService {
	
	    //用户登录验证
		public SysUser login(Map<String,Object> map);

}
