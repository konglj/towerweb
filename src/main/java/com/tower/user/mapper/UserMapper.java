package com.tower.user.mapper;

import java.util.List;
import java.util.Map;

import com.tower.user.bean.UserInfo;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserManagePage;
import com.tower.user.bean.UserMoney;
import com.tower.user.bean.UserType;


public interface UserMapper {
	
	public List<UserInfo> getUserInfos(UserManagePage usermanagepage);
	
	public int getUserInfosCount(UserManagePage usermanagepage);
	
	public List<UserMoney> getUserMoneys(UserManagePage usermanagepage);
	
	public int getUserMoneysCount(UserManagePage usermanagepage);
	
	public UserInfo getUserDetail(int userid);
	
	public int updateuserstate(Map<String,Object> map);
	
	public int updateusertype(Map<String,Object> map);
	
	public int updateUserBz(Map<String,Object> map);
	
	public int updateUserLevel(Map<String,Object> map);
	
	public List<UserType> getUserTypes();
	
	public List<UserLevel> getUserLevels(int province);
	
	public UserInfo getUpdateUserInfo(int userid);
	
	public int updateUserMoney(UserMoney userMoney);
	
	public UserMoney getUserMoney(int userid);
	
	public Integer getUserLevel(int userid);
}
