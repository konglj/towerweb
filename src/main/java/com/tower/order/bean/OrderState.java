package com.tower.order.bean;

public class OrderState {
	
     private int id;
	
	private int state;
	
	private String imgsrc;
	
	private String statename;
	
	private int iseffect;
	
	private int isearch;
	
	private int successstate;
	
	private int errorstate;
	
	private int towerrelease;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}
	
}
