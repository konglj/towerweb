package com.tower.analysis.mapper;

import java.util.List;
import java.util.Map;

import com.tower.analysis.bean.UserAnalysis;
import com.tower.analysis.bean.UserAnalysisPage;

public interface UserAnalysisMapper {

	public List<UserAnalysis> getUserAnalysis(UserAnalysisPage userAnalysisPage);
	
	public int getUserAnalysisCount(UserAnalysisPage userAnalysisPage);
	
	public List<Map<String,Object>> getDcUserAnalysis(UserAnalysisPage userAnalysisPage);
	
	public List<Map<String,Object>> getUserSourceAnalysis(UserAnalysisPage userAnalysisPage);
	
}
