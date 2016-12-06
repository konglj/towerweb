package com.tower.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.common.bean.Score;
import com.tower.common.mapper.ScoreMapper;
import com.tower.common.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	@Override
	public int insertScore(Score score) {
		return scoreMapper.insertScore(score);
	}

	
}
