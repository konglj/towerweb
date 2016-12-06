package com.tower.common.util.proj;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.Area;
import com.tower.common.bean.BasePage;
import com.tower.common.bean.City;
import com.tower.common.bean.District;
import com.tower.common.bean.Province;
import com.tower.system.bean.SysUser;

public class AreaUtil {

	public static String all_name = "全部";

	public static int all_code = 0;

	private static void setLevel2(SysUser sysUser, List<City> citys,
			List<District> districts,boolean all) {
		if (sysUser.getCitys() == null || sysUser.getCitys().size() == 0) {
			return;
		}
		citys.addAll(sysUser.getCitys());
		City city = citys.get(0);
		if (sysUser.getDistricts() == null)
			return;
		//districts = new ArrayList<District>();
		

		if (citys.size() > 1&&all) {
			city = new City(all_code, all_name);
			citys.add(0, city);
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}else{
			for (District district : sysUser.getDistricts()) {
				if (district.getCityid() == city.getCityid())
					districts.add(district);

			}
		}

		if (districts.size() > 1&&all) {
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}

	}

	private static void setLevel3(SysUser sysUser, List<District> districts,
			List<Area> areas,boolean all) {

		if (sysUser.getDistricts() == null
				|| sysUser.getDistricts().size() == 0) {
			return;
		}
		districts.addAll(sysUser.getDistricts());
		if(districts.size()>1 &&all){
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}else{
			District district = districts.get(0);
			if (sysUser.getAreas() == null)
				return;
			// areas=new ArrayList<Area>();
			for (Area area : sysUser.getAreas()) {
				if (district.getDisid() == area.getDisid())
					areas.add(area);
			}
		}
		if ((areas.size() > 1||areas.size()==0)&&all) {
			Area area = new Area(all_code, all_name);
			areas.add(0, area);
		}

	}
	
	
	
	private static void setUserLevel2(SysUser sysUser, List<City> citys,
			List<District> districts,boolean all) {
		if (sysUser.getCitys() == null || sysUser.getCitys().size() == 0) {
			return;
		}
		citys.addAll(sysUser.getCitys());
		City city = citys.get(0);
		if (sysUser.getDistricts() == null)
			return;
		//districts = new ArrayList<District>();
		
	

		if (citys.size() > 1&&all) {
			city = new City(all_code, all_name);
			citys.add(0, city);
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}else{
			for (District district : sysUser.getDistricts()) {
				if (district.getCityid() == city.getCityid())
					districts.add(district);

			}
		}

		if (districts.size() > 1&&all) {
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}

	}

	private static void setUserLevel3(SysUser sysUser, List<District> districts,boolean all) {

		if (sysUser.getDistricts() == null
				|| sysUser.getDistricts().size() == 0) {
			return;
		}
		districts.addAll(sysUser.getDistricts());
		if(districts.size()>1 &&all){
			District district = new District(all_code, all_name);
			districts.add(0, district);
		}

	}

	
	

	private static void setSelectAreas(SysUser sysUser,
			List<Province> provinces, List<City> citys,
			List<District> districts, List<Area> areas,boolean all) {
		int level = sysUser.getArealevel();
		switch (level) {
		case 1: // 省、市、区、街道
			break;
		case 2: // 市、区
			setLevel2(sysUser, citys, districts,all);
			break;
		case 3: // 区、街道
			setLevel3(sysUser, districts, areas,all);
			break;
		case 4: // 街道
			break;
		default:
			break;
		}
	}

	
	private static void setSelectUserAreas(SysUser sysUser,
			 List<City> citys,
			List<District> districts,boolean all) {
		int level = sysUser.getUserarealevel();
		switch (level) {
		case 1: // 省、市、区、街道
			break;
		case 2: // 市、区
			setUserLevel2(sysUser, citys, districts,all);
			break;
		case 3: // 区、街道
			setUserLevel3(sysUser, districts,all);
			break;
		case 4: // 街道
			break;
		default:
			break;
		}
	}
	
	public static void getTowerAreaParamer(BasePage basePage,
			SysUser sysUser,boolean all) {
		setSelectAreas(sysUser, basePage.getParamerProvinces(),
				basePage.getParamerCitys(), basePage.getParamerDistricts(),
				basePage.getParamerAreas(),all);
	}
	/*
	public static void getTowerAreaParamer(OrderPage orderPage,
			SysUser sysUser,boolean all) {
		setSelectAreas(sysUser, orderPage.getParamerProvinces(),
				orderPage.getParamerCitys(), orderPage.getParamerDistricts(),
				orderPage.getParamerAreas(),all);
	}
	*/
	
	public static void getUserAreaParamer(BasePage basePage,
			SysUser sysUser,boolean all) {
		setSelectUserAreas(sysUser,
				basePage.getUserParamerCitys(), basePage.getUserParamerDistricts(),all);
	}
}
