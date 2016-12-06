package com.tower.common.bean;

import java.util.List;

public class District {
	
	public District(){
		
	}
	
	public District(int disid,String disname){
		this.id=0;
		this.disid=0;
		this.disname=disname;
	}
	

	private int id;
	
	private int disid;
	
	private String disname;
	
	private int cityid;

	private List<Area> areas;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisid() {
		return disid;
	}

	public void setDisid(int disid) {
		this.disid = disid;
	}

	public String getDisname() {
		return disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
	
	
	
	
}
