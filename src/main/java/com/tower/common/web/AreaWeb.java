package com.tower.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tower.common.bean.Area;
import com.tower.common.bean.District;
import com.tower.common.service.AreaService;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;

@Controller
@RequestMapping("/area")
public class AreaWeb {

	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/get_areas")
	@ResponseBody
	public Object getAreas(HttpServletRequest request,int district,int isall){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("district", district);
		map.put("sysUser",sysUser);
		List<Area> areas=areaService.getAreas(map);
		if(areas!=null&&isall>0&&areas.size()>0){
			Area area = new Area(AreaUtil.all_code, AreaUtil.all_name);
			areas.add(0, area);
		}
		return ResultUtil.responseSuccessMsg(areas);
	}
	
	@RequestMapping("/get_districts")
	@ResponseBody
	public Object getDistricts(HttpServletRequest request,int city,int isall){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("city", city);
		map.put("sysUser",sysUser);
		List<District> districts=areaService.getDistricts(map);
		if(districts!=null&&isall>0&&districts.size()>0){
			District district = new District(AreaUtil.all_code, AreaUtil.all_name);
			districts.add(0, district);
		}
		return ResultUtil.responseSuccessMsg(districts);
	}
}
