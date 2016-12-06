package com.tower.common.bean;


public class Area {
	
	public Area(){
		
	}
	public Area(int areaid,String areaname){
		this.id=areaid;
		this.areaid=areaid;
		this.areaname=areaname;
	}

	private int id;
	
	private String areaname;
	
	private int areaid;
	
	private int disid;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public int getDisid() {
		return disid;
	}

	public void setDisid(int disid) {
		this.disid = disid;
	}
	
	
	
}
