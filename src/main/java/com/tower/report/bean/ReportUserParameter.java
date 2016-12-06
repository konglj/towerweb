package com.tower.report.bean;

public class ReportUserParameter {
	
	private String usertele;
	
	private String username;
	
	private Integer userdistrict;
	
	private Integer userarea;
	
	private Integer usercity;
	
	private Integer userlevel =0;
	
	private Integer usertype = 0;
	
	private Integer userstate = -1;
	
	private String fromdate;
	
	private String todate;

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

	public Integer getUserstate() {
		return userstate;
	}

	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public Integer getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(Integer userdistrict) {
		this.userdistrict = userdistrict;
	}
	
	

	
}
