package com.tower.report.bean;

public class ReportTxParameter {
	
	private String usertele;
	
	private String username;
	
	private Integer userarea=0;
	
	private Integer userdistrict=0;
	
	private Integer usercity=0;
	
	private Integer userlevel = 0;
	
	private Integer usertype =0;
	

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserarea() {
		return userarea;
	}

	public void setUserarea(Integer userarea) {
		this.userarea = userarea;
	}

	public Integer getUsercity() {
		return usercity;
	}

	public void setUsercity(Integer usercity) {
		this.usercity = usercity;
	}

	public Integer getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(Integer userdistrict) {
		this.userdistrict = userdistrict;
	}

	
}
