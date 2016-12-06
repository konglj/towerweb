package com.tower.report.bean;

public class ReportOrderParameter {


	private String username;

	private String usertele;


	private String towername;

	private Integer towercity=0;
	
	private Integer towerarea=0;
	
	private Integer towerdistrict=0;

	private String towercityname;

	

	private String towerareaname;

	private Integer towerstate=-1;

	private String fromdate;
	
	private String todate;
	
	private Integer iseffect=-1;

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

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public Integer getTowercity() {
		return towercity;
	}

	public void setTowercity(Integer towercity) {
		this.towercity = towercity;
	}

	public String getTowercityname() {
		return towercityname;
	}

	public void setTowercityname(String towercityname) {
		this.towercityname = towercityname;
	}

	public Integer getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(Integer towerarea) {
		this.towerarea = towerarea;
	}

	public String getTowerareaname() {
		return towerareaname;
	}

	public void setTowerareaname(String towerareaname) {
		this.towerareaname = towerareaname;
	}

	public Integer getTowerstate() {
		return towerstate;
	}

	public void setTowerstate(Integer towerstate) {
		this.towerstate = towerstate;
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

	public void setTowerdistrict(Integer towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public void setIseffect(Integer iseffect) {
		this.iseffect = iseffect;
	}

	public int getIseffect() {
		return iseffect;
	}

	public void setIseffect(int iseffect) {
		this.iseffect = iseffect;
	}

	public int getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(int towerdistrict) {
		this.towerdistrict = towerdistrict;
	}
	
	
	

	
	
	
	
}


