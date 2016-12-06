package com.tower.analysis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tower.common.bean.BasePage;

public class OrderAnalysisPage  extends BasePage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 *派单分析
	 */
	private List<Map<String,Object>> planOrderAnalysis=new ArrayList<Map<String,Object>>();

	
	private String towername;
	
	private Integer towercity;
	
	private Integer towerdistrict;
	
	private Integer towerarea;
	
	private Integer towerlevel;

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

	public Integer getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(Integer towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public Integer getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(Integer towerarea) {
		this.towerarea = towerarea;
	}

	public Integer getTowerlevel() {
		return towerlevel;
	}

	public void setTowerlevel(Integer towerlevel) {
		this.towerlevel = towerlevel;
	}

	
	
	

}
