package com.tower.tower.mapper;

import com.tower.tower.bean.TowerReport;


public interface TowerReportMapper {

	
	public int checkTowerExist(int towerid);
	
	public int upateTowerReport(TowerReport towerReport);
	
	public int insertTowerReport(TowerReport towerReport);

}
