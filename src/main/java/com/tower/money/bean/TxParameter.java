package com.tower.money.bean;

public class TxParameter {
	
	//手机号
	private String usertele;
	
	//姓名
	private String username;
	
	//用户城市
	private Integer usercity=0;
	
	//用户城市
	private Integer userdistrict=0;
	
	//用户区域
	private Integer userarea=0;
	
	//用户级别
	private Integer userlevel =0;
	
	//用户类型
	private Integer usertype =0;
	
	//体现状态
	private Integer state =-2;

	//站址名称
	private String towername;
	
	//站址编号
	private String towerno;
	
	
	public String getUsertele() {
		return usertele;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(Integer userdistrict) {
		this.userdistrict = userdistrict;
	}

	public Integer getUserarea() {
		return userarea;
	}

	public void setUserarea(Integer userarea) {
		this.userarea = userarea;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public String getTowerno() {
		return towerno;
	}

	public void setTowerno(String towerno) {
		this.towerno = towerno;
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
	
	

	
	
	
}

