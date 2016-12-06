package com.tower.user.bean;

import java.util.List;

import com.tower.order.bean.Order;

public class UserInfo {
	
	private int id;
	
	private String wxid;
	
	private String  wxname;
	
	private String  username;
	
	private String  wxheadimg;
	
	private int  usersex;
	
	private String usertele;
	
	private int userold;
	
	private int userbusiness;
	
	private String userbusinessname;
	
	private int userarea;
	
	private int userdistrict;
	
	private int usercity;
	
	private String usercompany;
	
	private int userlevel;
	
	private int userstate;
	
	private int usertype;
	
	private int usertjid;
	
	private String usertjname;
	
	
	private String cityname;
	
	private String districtname;
	
	private String areaname;
	

	
	private String levelname;
	
	private String typename;
	
	private String statename;
	
	private String sexname;
	
	private String addtime;
	
	private String userbz="";
	
	private int ordercount;
	
	private int succcount;
	
	private int ingcount;
	
	private int failcount;
	
	private int cancelcount;
	
	private int score;
	
	private int exp;
	
	private int userverifystate;
	
	private int userteamtype;
	
	private String userteamimg;
	
	private String verifystatename;
	
	private String teamtypename;
	
	private String userteamimage;
	
	private String userwintype;
	
	private String userwintime;
	
	private int pdcount;
	
	List <Order> orderinfos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getWxname() {
		return wxname;
	}

	public void setWxname(String wxname) {
		this.wxname = wxname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWxheadimg() {
		return wxheadimg;
	}

	public void setWxheadimg(String wxheadimg) {
		this.wxheadimg = wxheadimg;
	}

	public int getUsersex() {
		return usersex;
	}

	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public int getUserold() {
		return userold;
	}

	public void setUserold(int userold) {
		this.userold = userold;
	}

	public int getUserbusiness() {
		return userbusiness;
	}

	public void setUserbusiness(int userbusiness) {
		this.userbusiness = userbusiness;
	}

	public int getUserarea() {
		return userarea;
	}

	public void setUserarea(int userarea) {
		this.userarea = userarea;
	}

	public String getUsercompany() {
		return usercompany;
	}

	public void setUsercompany(String usercompany) {
		this.usercompany = usercompany;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}

	public int getUserstate() {
		return userstate;
	}

	public void setUserstate(int userstate) {
		this.userstate = userstate;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getUsertjid() {
		return usertjid;
	}

	public void setUsertjid(int usertjid) {
		this.usertjid = usertjid;
	}

	public String getUsertjname() {
		return usertjname;
	}

	public void setUsertjname(String usertjname) {
		this.usertjname = usertjname;
	}


	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getSexname() {
		return sexname;
	}

	public void setSexname(String sexname) {
		this.sexname = sexname;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public int getSucccount() {
		return succcount;
	}

	public void setSucccount(int succcount) {
		this.succcount = succcount;
	}

	public int getIngcount() {
		return ingcount;
	}

	public void setIngcount(int ingcount) {
		this.ingcount = ingcount;
	}

	public int getFailcount() {
		return failcount;
	}

	public void setFailcount(int failcount) {
		this.failcount = failcount;
	}

	public int getCancelcount() {
		return cancelcount;
	}

	public void setCancelcount(int cancelcount) {
		this.cancelcount = cancelcount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	

	public List<Order> getOrderinfos() {
		return orderinfos;
	}

	public void setOrderinfos(List<Order> orderinfos) {
		this.orderinfos = orderinfos;
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

	public int getUserteamtype() {
		return userteamtype;
	}

	public void setUserteamtype(int userteamtype) {
		this.userteamtype = userteamtype;
	}

	public String getUserteamimg() {
		return userteamimg;
	}

	public void setUserteamimg(String userteamimg) {
		this.userteamimg = userteamimg;
	}

	public String getVerifystatename() {
		return verifystatename;
	}

	public void setVerifystatename(String verifystatename) {
		this.verifystatename = verifystatename;
	}

	public String getTeamtypename() {
		return teamtypename;
	}

	public void setTeamtypename(String teamtypename) {
		this.teamtypename = teamtypename;
	}

	public String getUserbusinessname() {
		return userbusinessname;
	}

	public void setUserbusinessname(String userbusinessname) {
		this.userbusinessname = userbusinessname;
	}

	public String getUserteamimage() {
		return userteamimage;
	}

	public void setUserteamimage(String userteamimage) {
		this.userteamimage = userteamimage;
	}

	public String getUserwintype() {
		return userwintype;
	}

	public void setUserwintype(String userwintype) {
		this.userwintype = userwintype;
	}

	public String getUserwintime() {
		return userwintime;
	}

	public void setUserwintime(String userwintime) {
		this.userwintime = userwintime;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public int getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(int userdistrict) {
		this.userdistrict = userdistrict;
	}

	public int getUsercity() {
		return usercity;
	}

	public void setUsercity(int usercity) {
		this.usercity = usercity;
	}

	public int getPdcount() {
		return pdcount;
	}

	public void setPdcount(int pdcount) {
		this.pdcount = pdcount;
	}
	
	

	
	
	
	
}
