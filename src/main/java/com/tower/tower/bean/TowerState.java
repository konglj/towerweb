package com.tower.tower.bean;

public class TowerState {

	public TowerState(){
		
	}
	public TowerState(String name,int state) {
		this.state=state;
		this.name=name;
	}
	private int state;
	
	private String name;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
