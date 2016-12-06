package com.tower.report.bean;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserType;

public class ReportUserPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ReportUser> reportUsers = new ArrayList< ReportUser>();

	private ReportUserParameter parameter = new ReportUserParameter();
	
	private List<UserType> userTypes=new ArrayList<UserType>();
	
	private List<UserLevel> userLevels=new ArrayList<UserLevel>();

	

	public List<ReportUser> getReportUsers() {
		return reportUsers;
	}

	public void setReportUsers(List<ReportUser> reportUsers) {
		this.reportUsers = reportUsers;
	}

	public ReportUserParameter getParameter() {
		return parameter;
	}

	public void setParameter(ReportUserParameter parameter) {
		this.parameter = parameter;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	public List<UserLevel> getUserLevels() {
		return userLevels;
	}

	public void setUserLevels(List<UserLevel> userLevels) {
		this.userLevels = userLevels;
	}
	
	
	
	


}
