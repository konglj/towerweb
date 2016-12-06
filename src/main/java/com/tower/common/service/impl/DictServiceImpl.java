package com.tower.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.common.bean.Dict;
import com.tower.common.mapper.DictMapper;
import com.tower.common.service.DictService;

@Service
public class DictServiceImpl implements DictService{

	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public Dict getDict(Dict dict) {
		return dictMapper.getDict(dict);
	}

}
