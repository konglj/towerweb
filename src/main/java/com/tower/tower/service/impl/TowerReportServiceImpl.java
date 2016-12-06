package com.tower.tower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.tower.bean.TowerReport;
import com.tower.tower.mapper.TowerReportMapper;
import com.tower.tower.service.TowerReportService;

@Service
public class TowerReportServiceImpl implements TowerReportService {

	@Autowired
	private TowerReportMapper towerReportMapper;
	
	@Override
	public int checkTowerExist(int towerid) {
		return towerReportMapper.checkTowerExist(towerid);
	}

	@Override
	public int upateTowerReport(TowerReport towerReport) {
		return towerReportMapper.upateTowerReport(towerReport);
	}

	@Override
	public int insertTowerReport(TowerReport towerReport) {
		return towerReportMapper.insertTowerReport(towerReport);
	}

}
