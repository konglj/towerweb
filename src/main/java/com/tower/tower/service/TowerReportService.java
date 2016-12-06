package com.tower.tower.service;

import com.tower.tower.bean.TowerReport;

public interface TowerReportService {

	
	public int checkTowerExist(int towerid);
	
	public int upateTowerReport(TowerReport towerReport);
	
	public int insertTowerReport(TowerReport towerReport);

}
