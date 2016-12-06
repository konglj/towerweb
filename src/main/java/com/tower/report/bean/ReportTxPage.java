package com.tower.report.bean;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserType;

public class ReportTxPage extends BasePage {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ReportTx> reportTxs = new ArrayList< ReportTx>();

	private ReportTxParameter parameter = new ReportTxParameter();
	
	private List<UserType> userTypes=new ArrayList<UserType>();
	
	private List<UserLevel> userLevels=new ArrayList<UserLevel>();

	
	
	




	public List<ReportTx> getReportTxs() {
		return reportTxs;
	}



	public void setReportTxs(List<ReportTx> reportTxs) {
		this.reportTxs = reportTxs;
	}



	public ReportTxParameter getParameter() {
		return parameter;
	}



	public void setParameter(ReportTxParameter parameter) {
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
