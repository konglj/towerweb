package com.tower.common.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dict {

	public Dict(){}
	
	public Dict (String dictname,int province){
		this.dictname=dictname;
		this.province=province;
	}
	private int id;
	
	private String dictname;

	private int province;
	
	private List<Map<String,String>> dicMaps=new ArrayList<Map<String,String>>();
	
	private Map<String,String> mapInfo=new HashMap<String, String>();;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}
	

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public List<Map<String, String>> getDicMaps() {
		return dicMaps;
	}

	public void setDicMaps(List<Map<String, String>> dicMaps) {
		this.dicMaps = dicMaps;
	}

	public Map<String, String> getMapInfo() {
		if(dicMaps==null||dicMaps.size()==0)
			return null;
		for (Map<String,String> map : dicMaps) {
			mapInfo.put(map.get("dictinfo").toString(), map.get("dictvalue"));
		}
		return mapInfo;
	}

	public void setMapInfo(Map<String, String> mapInfo) {
		this.mapInfo = mapInfo;
	}
	
	
	
	
	
	
}
