package com.tower.user.service;

import java.util.List;
import java.util.Map;

import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserInfo;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserManagePage;
import com.tower.user.bean.UserMoney;
import com.tower.user.bean.UserType;


public interface UserService {

	

	public List<UserInfo> getUserInfos(UserManagePage usermanagepage);
	
	
	public List<UserMoney> getUserMoneys(UserManagePage usermanagepage);
	
	
	public UserInfo getUserDetail(int userid);
	
	public int updateuserstate(Map<String,Object> map);
	
	public int updateusertype(Map<String,Object> map);
	
	public int updateUserBz(Map<String,Object> map);
	
	public int updateUserLevle(Map<String,Object> map);
	
	public List<UserType> getUserTypes();
	
	public List<UserLevel> getUserLevels(int province);

	public UserInfo getUpdateUserInfo(int userid);
	
	public int updateUserMoney(UserMoney userMoney,SysUser sysUser);
	
}
