package com.tower.analysis.mapper;

import java.util.List;
import java.util.Map;

import com.tower.analysis.bean.TowerAnalysis;
import com.tower.analysis.bean.TowerAnalysisPage;

public interface TowerAnalysisMapper {

	/**
	 * 站址活跃
	 * @param towerAnalysisPage
	 * @return
	 */
	public List<TowerAnalysis> getTowers(TowerAnalysisPage towerAnalysisPage);
	
	/**
	 * 站址活跃数量
	 * @param towerAnalysisPage
	 * @return
	 */
	public int getTowersCount(TowerAnalysisPage towerAnalysisPage);
	
	
	/**
	 * 站址活跃导出
	 * @param towerAnalysisPage
	 * @return
	 */
	public List<Map<String,Object>> getDcTowers(TowerAnalysisPage towerAnalysisPage);
	
	
	/**
	 * 站址状态
	 * @param towerAnalysisPage
	 * @return
	 */
	public List<Map<String,Object>> getTowerStates(TowerAnalysisPage towerAnalysisPage);
	
}
