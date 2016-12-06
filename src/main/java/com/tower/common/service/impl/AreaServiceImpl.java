package com.tower.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.common.bean.Area;
import com.tower.common.bean.City;
import com.tower.common.bean.District;
import com.tower.common.bean.Province;
import com.tower.common.mapper.AreaMapper;
import com.tower.common.service.AreaService;
import com.tower.system.bean.SysUser;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	@Override
	public List<Province> getProvices(Map<String,Object> map) {
	
		return areaMapper.getProvices(map);
	}

	@Override
	public List<City> getCitys(Map<String, Object> map) {
	
		return areaMapper.getCitys(map);
	}

	@Override
	public List<District> getDistricts(Map<String, Object> map) {
	
		return areaMapper.getDistricts(map);
	}

	@Override
	public List<Area> getAreas(Map<String, Object> map) {
	
		return areaMapper.getAreas(map);
	}

	@Override
	public List<Area> getAreas(int disid,List<Area> areas) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("district", disid);
		map.put("adminareas", areas);
		return getAreas(map);
	}

	@Override
	public List<District> getDistricts(int cityid, SysUser sysUser) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("cityid", cityid);
		map.put("sysUser", sysUser);
		return getDistricts(map);
	}

	
	
}
