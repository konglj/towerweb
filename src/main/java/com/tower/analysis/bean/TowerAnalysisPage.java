package com.tower.analysis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tower.common.bean.BasePage;
import com.tower.tower.bean.TowerLevel;

public class TowerAnalysisPage  extends BasePage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<TowerAnalysis> towerAnalysis=new ArrayList<TowerAnalysis>();
	
	private List<Map<String,Object>> towerStateAnalysis=new ArrayList<Map<String,Object>>();
	
	private List<TowerLevel> towerLevels=new ArrayList<TowerLevel>();
	
	private String towername;
	
	private Integer towercity;
	
	private Integer towerdistrict;
	
	private Integer towerarea;
	
	private Integer towerlevel;

	
	
	
	public List<TowerAnalysis> getTowerAnalysis() {
		return towerAnalysis;
	}

	public void setTowerAnalysis(List<TowerAnalysis> towerAnalysis) {
		this.towerAnalysis = towerAnalysis;
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

	
	public List<Map<String, Object>> getTowerStateAnalysis() {
		return towerStateAnalysis;
	}

	public void setTowerStateAnalysis(List<Map<String, Object>> towerStateAnalysis) {
		this.towerStateAnalysis = towerStateAnalysis;
	}

	public List<TowerLevel> getTowerLevels() {
		return towerLevels;
	}

	public void setTowerLevels(List<TowerLevel> towerLevels) {
		this.towerLevels = towerLevels;
	}
	
	
	
	

}
