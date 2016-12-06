package com.tower.common.service;

import java.util.List;
import java.util.Map;

import com.tower.common.bean.Area;
import com.tower.common.bean.City;
import com.tower.common.bean.District;
import com.tower.common.bean.Province;
import com.tower.system.bean.SysUser;

public interface AreaService {

	/**
	 * 获取所有的省
	 * @return
	 */
	public List<Province> getProvices(Map<String,Object> map);
	
	/**
	 * 获取的城市
	 * @return
	 */
	public List<City> getCitys(Map<String,Object> map);
	
	
	/**
	 * 获取的区
	 * @return
	 */
	public List<District> getDistricts(Map<String,Object> map);
	
	/**
	 * 获取的区
	 * @return
	 */
	public List<District> getDistricts(int cityid,SysUser sysUser);
	
	/**
	 * 获取街道
	 * @return
	 */
	public List<Area> getAreas(Map<String,Object> map);
	
	
	/**
	 * 获取的街道
	 * @return
	 */
	public  List<Area> getAreas(int disid,List<Area> areas);
	
	
}
