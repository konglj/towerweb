package com.tower.analysis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.analysis.bean.UserAnalysis;
import com.tower.analysis.bean.UserAnalysisPage;
import com.tower.analysis.mapper.UserAnalysisMapper;
import com.tower.analysis.service.UserAnalysisService;

@Service
public class UserAnalysisServiceImpl implements UserAnalysisService {

	@Autowired
	private UserAnalysisMapper userAnalysisMapper;
	
	@Override
	public List<UserAnalysis> getUserAnalysis(UserAnalysisPage userAnalysisPage) {
		int count=userAnalysisMapper.getUserAnalysisCount(userAnalysisPage);
		List<UserAnalysis> userAnalysis=userAnalysisMapper.getUserAnalysis(userAnalysisPage);
		userAnalysisPage.setPagerowtotal(count);
		userAnalysisPage.setUserAnalysis(userAnalysis);
		return userAnalysis;
	}


	@Override
	public List<Map<String, Object>> getDcUserAnalysis(
			UserAnalysisPage userAnalysisPage) {
		
		return userAnalysisMapper.getDcUserAnalysis(userAnalysisPage);
	}

	@Override
	public List<Map<String, Object>> getUserSourceAnalysis(
			UserAnalysisPage userAnalysisPage) {
		
		return userAnalysisMapper.getUserSourceAnalysis(userAnalysisPage);
	}

}
