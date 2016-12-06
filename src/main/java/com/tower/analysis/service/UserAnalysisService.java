package com.tower.analysis.service;

import java.util.List;
import java.util.Map;

import com.tower.analysis.bean.UserAnalysis;
import com.tower.analysis.bean.UserAnalysisPage;

public interface UserAnalysisService {

	public List<UserAnalysis> getUserAnalysis(UserAnalysisPage userAnalysisPage);
	
	
	public List<Map<String,Object>> getDcUserAnalysis(UserAnalysisPage userAnalysisPage);
	
	public List<Map<String,Object>> getUserSourceAnalysis(UserAnalysisPage userAnalysisPage);
}
