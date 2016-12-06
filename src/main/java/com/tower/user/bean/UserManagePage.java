package com.tower.user.bean;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;

public class UserManagePage extends BasePage {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UserInfo> userInfos=new ArrayList<UserInfo>();
	
	private UserInfo userinfo=new UserInfo();
	
	private List<UserMoney> userMoneys=new ArrayList<UserMoney>();
	
	private UserMoney userMoney=new UserMoney();
	
	private UserParameter parameter=new UserParameter();
	
	private List<UserLevel> userLevels=new ArrayList<UserLevel>();
	
	private List<UserType> userTypes=new ArrayList<UserType>();

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public List<UserMoney> getUserMoneys() {
		return userMoneys;
	}

	public void setUserMoneys(List<UserMoney> userMoneys) {
		this.userMoneys = userMoneys;
	}

	public UserMoney getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(UserMoney userMoney) {
		this.userMoney = userMoney;
	}

	public UserParameter getParameter() {
		return parameter;
	}

	public void setParameter(UserParameter parameter) {
		this.parameter = parameter;
	}

	public List<UserLevel> getUserLevels() {
		return userLevels;
	}

	public void setUserLevels(List<UserLevel> userLevels) {
		this.userLevels = userLevels;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}
	
	
	
	
	
	
	
	
	
	
}
