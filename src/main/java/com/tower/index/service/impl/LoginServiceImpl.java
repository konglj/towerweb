package com.tower.index.service.impl;

import java.util.ArrayList;
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
import com.tower.common.util.StrUtil;
import com.tower.index.service.LoginService;
import com.tower.system.bean.SysUser;
import com.tower.system.mapper.SysMapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SysMapper sysMapper;

	@Autowired
	private AreaMapper areaMapper;

	private List<Province> getProvinces(String province){
		List<Province> provinces=null;
		Map<String,Object> map=new HashMap<String, Object>();
		if (!StrUtil.isNullOrEmpty(province)) {
			String[] ids = province.split(",");
			map.put("provinces", ids);
			provinces = areaMapper.getProvices(map);
		}
		return provinces;
	}
	
	private List<City> getCitys(String city){
		List<City> citys=null;
		Map<String,Object> map=new HashMap<String, Object>();
		if (!StrUtil.isNullOrEmpty(city)) {
			String[] ids = city.split(",");
			map.put("citys", ids);
			citys = areaMapper.getCitys(map);
		}
		return citys;
	}
	
	private List<District> getDistricts(String district){
		List<District> districts=null;
		Map<String,Object> map=new HashMap<String, Object>();
		if (!StrUtil.isNullOrEmpty(district)) {
			String[] ids = district.split(",");
			map.put("districts", ids);
			districts = areaMapper.getDistricts(map);
		}
		return districts;
	}
	
	private List<Area> getAreas(String area){
		List<Area> areas=null;
		Map<String,Object> map=new HashMap<String, Object>();
		if (!StrUtil.isNullOrEmpty(area)) {
			String[] ids = area.split(",");
			map.put("areas", ids);
			areas = areaMapper.getAreas(map);
		}
		return areas;
	}
	
	// 用户登录验证
	public SysUser login(Map<String, Object> map) {
		SysUser sysUser = new SysUser();
		sysUser = sysMapper.getSysUserInfoByPwd(map);
		if (sysUser == null || sysUser.getId() == 0)
			return null;
		sysMapper.updateUserDlTime(sysUser.getId());
		map = new HashMap<String, Object>();
		//sysUser.setProvinces(this.getProvinces(sysUser.getProvince()));
		sysUser.setCitys(this.getCitys(sysUser.getCity()));
		switch (sysUser.getArealevel()) {
		case 1: // 省、市、区、街道
			break;
		case 2: // 市、区
			sysUser.setAreas(this.getAreas(sysUser.getArea()));
			sysUser.setDistricts(this.getDistricts(sysUser.getDistrict()));
			break;
		case 3: // 区、街道
			sysUser.setDistricts(this.getDistricts(sysUser.getDistrict()));
			sysUser.setAreas(this.getAreas(sysUser.getArea()));
			break;
		case 4: // 街道
			break;

		default:
			break;
		}

		return sysUser;
	}

}
