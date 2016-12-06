package com.tower.analysis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.analysis.bean.TowerAnalysis;
import com.tower.analysis.bean.TowerAnalysisPage;
import com.tower.analysis.mapper.TowerAnalysisMapper;
import com.tower.analysis.service.TowerAnalysisService;

@Service
public class TowerAnalysisServiceImpl implements TowerAnalysisService {

	@Autowired
	private TowerAnalysisMapper towerAnalysisMapper;
	
	@Override
	public List<TowerAnalysis> getTowers(
			TowerAnalysisPage towerAnalysisPage) {
		int count=towerAnalysisMapper.getTowersCount(towerAnalysisPage);
		List<TowerAnalysis> towerAnalysis=towerAnalysisMapper.getTowers(towerAnalysisPage);
		towerAnalysisPage.setPagerowtotal(count);
		towerAnalysisPage.setTowerAnalysis(towerAnalysis);
		return towerAnalysis;
	}

	@Override
	public List<Map<String, Object>> getDcTowers(
			TowerAnalysisPage towerAnalysisPage) {
		return towerAnalysisMapper.getDcTowers(towerAnalysisPage);
	}

	@Override
	public List<Map<String, Object>> getTowerStates(
			TowerAnalysisPage towerAnalysisPage) {
		List<Map<String,Object>> list=towerAnalysisMapper.getTowerStates(towerAnalysisPage);
		towerAnalysisPage.setTowerStateAnalysis(list);
		return list ;
	}

}
