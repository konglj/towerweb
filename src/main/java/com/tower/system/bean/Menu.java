package com.tower.system.bean;

import java.util.List;

public class Menu {
	
	private int id;
	
	private String menuname;
	
	private String  menuurl;
	
	private int parentid;
	
	private int sort;
	
	private String icon;
	
	private int province;
	
	private List<Menu> childmenus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public List<Menu> getChildmenus() {
		return childmenus;
	}

	public void setChildmenus(List<Menu> childmenus) {
		this.childmenus = childmenus;
	}
	
	

}
