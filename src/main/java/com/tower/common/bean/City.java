package com.tower.common.bean;

import java.util.List;

public class City {

	public City(){
		
	}
	
	public City(int cityid,String cityname){
		this.id=cityid;
		this.cityid=cityid;
		this.cityname=cityname;
	}
	private int id;
	
	private int cityid;
	
	private String cityname;
	
	private int provinceid;
	
	private int isDirect;//是否为直辖市
	
	private List<District> districts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public int getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(int isDirect) {
		this.isDirect = isDirect;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	
	
}
