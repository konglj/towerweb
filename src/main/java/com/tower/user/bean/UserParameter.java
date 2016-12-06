package com.tower.user.bean;

public class UserParameter {
	
	private String usertele;
	
	private String username;
	
	
	private int userarea;
	
	private int userdistrict;
	
	private int usercity;
	
	private int userlevel =0;
	
	private int usertype =0;
	
	private int userstate = -1;
	
    private String fromdate;
	
	private String todate;
	
	private String userbz;
	
	private int userverifystate=-1;
	
	private int userteamimage=-1;

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

	public int getUserarea() {
		return userarea;
	}

	public void setUserarea(int userarea) {
		this.userarea = userarea;
	}

	public int getUsercity() {
		return usercity;
	}

	public void setUsercity(int usercity) {
		this.usercity = usercity;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getUserstate() {
		return userstate;
	}

	public void setUserstate(int userstate) {
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

	public String getUserbz() {
		return userbz;
	}

	public void setUserbz(String userbz) {
		this.userbz = userbz;
	}

	public int getUserverifystate() {
		return userverifystate;
	}

	public void setUserverifystate(int userverifystate) {
		this.userverifystate = userverifystate;
	}

	public int getUserteamimage() {
		return userteamimage;
	}

	public void setUserteamimage(int userteamimage) {
		this.userteamimage = userteamimage;
	}

	public int getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(int userdistrict) {
		this.userdistrict = userdistrict;
	}

	
	
	
}
