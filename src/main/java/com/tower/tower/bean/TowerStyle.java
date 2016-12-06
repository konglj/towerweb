package com.tower.tower.bean;

import java.util.List;

public class TowerStyle {

	private int id;
	
	private String name;
	
	private String image;
	
	private List<TowerType> types;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TowerType> getTypes() {
		return types;
	}

	public void setTypes(List<TowerType> types) {
		this.types = types;
	}
	
	
	
	
}
