package com.tower.tower.bean;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;


public class TowersPage extends BasePage {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Tower> towers=new ArrayList<Tower>();
	
	private Tower tower=new Tower();
	
	private Integer towerstate=-1;
	
	private String fromdate;
	
	private String todate;
	
	private String towername;
	
	private Integer towerstyle=0;
	
	private Integer towertype=0;
	
	private Integer towercreatetype=0;//上海
	
	private Integer towervisible=-1;
	
	private Integer towerlevel;
	
	private Integer towersource;//1 未上架  0 添加
	
	
	private List<TowerState> towerStates=new ArrayList<TowerState>();
	
	private List<TowerCreateType> towerCreateTypes=new ArrayList<TowerCreateType>();
	
	private List<TowerStyle> towerStyles=new ArrayList<TowerStyle>();
	
	private List<TowerLevel> towerLevels=new ArrayList<TowerLevel>();
	
	private List<TowerStore> towerStores=new ArrayList<TowerStore>();
	
	private List<TowerType> towerTypes=new ArrayList<TowerType>();
	
	

	public List<Tower> getTowers() {
		return towers;
	}

	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}

	public Integer getTowerstate() {
		return towerstate;
	}

	public void setTowerstate(Integer towerstate) {
		this.towerstate = towerstate;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public Integer getTowerstyle() {
		return towerstyle;
	}

	public void setTowerstyle(Integer towerstyle) {
		this.towerstyle = towerstyle;
	}

	public Integer getTowertype() {
		return towertype;
	}

	public void setTowertype(Integer towertype) {
		this.towertype = towertype;
	}

	public Integer getTowercreatetype() {
		return towercreatetype;
	}

	public void setTowercreatetype(Integer towercreatetype) {
		this.towercreatetype = towercreatetype;
	}

	public Integer getTowervisible() {
		return towervisible;
	}
	public void setTowervisible(Integer towervisible) {
		this.towervisible = towervisible;
	}

	
	
	
	public Integer getTowerlevel() {
		return towerlevel;
	}

	public void setTowerlevel(Integer towerlevel) {
		this.towerlevel = towerlevel;
	}

	public List<TowerState> getTowerStates() {
		return towerStates;
	}

	public void setTowerStates(List<TowerState> towerStates) {
		this.towerStates = towerStates;
	}

	public List<TowerCreateType> getTowerCreateTypes() {
		return towerCreateTypes;
	}

	public void setTowerCreateTypes(List<TowerCreateType> towerCreateTypes) {
		this.towerCreateTypes = towerCreateTypes;
	}

	public List<TowerStyle> getTowerStyles() {
		return towerStyles;
	}

	public void setTowerStyles(List<TowerStyle> towerStyles) {
		this.towerStyles = towerStyles;
	}

	public List<TowerLevel> getTowerLevels() {
		return towerLevels;
	}

	public void setTowerLevels(List<TowerLevel> towerLevels) {
		this.towerLevels = towerLevels;
	}

	public Integer getTowersource() {
		return towersource;
	}

	public void setTowersource(Integer towersource) {
		this.towersource = towersource;
	}

	public List<TowerStore> getTowerStores() {
		return towerStores;
	}

	public void setTowerStores(List<TowerStore> towerStores) {
		this.towerStores = towerStores;
	}

	public List<TowerType> getTowerTypes() {
		return towerTypes;
	}

	public void setTowerTypes(List<TowerType> towerTypes) {
		this.towerTypes = towerTypes;
	}
	
	


	
	
	
	
	
	
	
	
	
	
}
