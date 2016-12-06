package com.tower.analysis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tower.common.bean.BasePage;

public class UserAnalysisPage  extends BasePage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserAnalysis> userAnalysis=new ArrayList<UserAnalysis>();
	
	private List<Map<String,Object>> userSourceAnalysis=new ArrayList<Map<String,Object>>();

	private String username;
	
	private String usertele;
	
	private Integer usercity;
	
	private Integer userdistrict;
	
	private Integer sourceid;
	
	private Integer infoid;
	
	public List<UserAnalysis> getUserAnalysis() {
		return userAnalysis;
	}

	public void setUserAnalysis(List<UserAnalysis> userAnalysis) {
		this.userAnalysis = userAnalysis;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public Integer getUsercity() {
		return usercity;
	}

	public void setUsercity(Integer usercity) {
		this.usercity = usercity;
	}

	public Integer getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(Integer userdistrict) {
		this.userdistrict = userdistrict;
	}

	public Integer getSourceid() {
		return sourceid;
	}

	public void setSourceid(Integer sourceid) {
		this.sourceid = sourceid;
	}

	public Integer getInfoid() {
		return infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}

	public List<Map<String, Object>> getUserSourceAnalysis() {
		return userSourceAnalysis;
	}

	public void setUserSourceAnalysis(List<Map<String, Object>> userSourceAnalysis) {
		this.userSourceAnalysis = userSourceAnalysis;
	}
	
	
	
	

}
