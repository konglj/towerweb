package com.tower.analysis.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpServerConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.analysis.bean.TowerAnalysisPage;
import com.tower.analysis.service.TowerAnalysisService;
import com.tower.common.bean.DataTable;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerLevel;
import com.tower.tower.service.TowerService;

@Controller
@RequestMapping("/analysis/tower")
public class TowerAnalysisWeb {

	@Autowired
	private TowerAnalysisService towerAnalysisService;
	
	@Autowired
	private TowerService  towerService;
	
	@RequestMapping("/tower")
	public ModelAndView getTowerAnalysisPage(HttpServletRequest request,TowerAnalysisPage towerAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		
		List<TowerLevel> towerLevels=towerService.getTowerLevels(sysUser.getProvince());
		towerAnalysisPage.setTowerLevels(towerLevels);
		
		AreaUtil.getTowerAreaParamer(towerAnalysisPage, sysUser,true);
		
		return new ModelAndView("/analysis/"+province+"/tower_analysis","towerAnalysisPage",towerAnalysisPage);
	}
	
	@RequestMapping("/get_towers")
	@ResponseBody
	public Object getTowerAnalysis(HttpServletRequest request,TowerAnalysisPage towerAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		towerAnalysisPage.setSysUser(sysUser);
	
		towerAnalysisService.getTowers(towerAnalysisPage);
		DataTable table = new DataTable(towerAnalysisPage.sEcho,
				towerAnalysisPage.getPagerowtotal(), towerAnalysisPage.getPagerowtotal(),
				towerAnalysisPage.getTowerAnalysis());

		return ResultUtil.responseSuccessMsg(table);
		
	}
	
	@RequestMapping("/towerstate")
	public ModelAndView getTowerStateAnalysisPage(HttpServletRequest request,TowerAnalysisPage towerAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		return new ModelAndView("/analysis/"+province+"/towerstate_analysis","towerAnalysisPage",towerAnalysisPage);
	}
	
	@RequestMapping("/get_towerstates")
	@ResponseBody
	public Object getTowerStateAnalysis(HttpServletRequest request,TowerAnalysisPage towerAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		towerAnalysisPage.setSysUser(sysUser);
	
		towerAnalysisService.getTowerStates(towerAnalysisPage);
		DataTable table = new DataTable(towerAnalysisPage.sEcho,
				towerAnalysisPage.getPagerowtotal(), towerAnalysisPage.getPagerowtotal(),
				towerAnalysisPage.getTowerStateAnalysis());
		return ResultUtil.responseSuccessMsg(table);
		
	}
}
