package com.tower.analysis.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.analysis.bean.TowerAnalysisPage;
import com.tower.analysis.bean.UserAnalysisPage;
import com.tower.analysis.service.TowerAnalysisService;
import com.tower.analysis.service.UserAnalysisService;
import com.tower.common.bean.DataTable;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerLevel;
import com.tower.tower.service.TowerService;
import com.tower.user.service.UserService;

@Controller
@RequestMapping("/analysis/user")
public class UserAnalysisWeb {

	@Autowired
	private UserAnalysisService userAnalysisService;
	
	
	@RequestMapping("/user")
	public ModelAndView getUserAnalysisPage(HttpServletRequest request,UserAnalysisPage userAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		
		AreaUtil.getUserAreaParamer(userAnalysisPage, sysUser,true);
		
		return new ModelAndView("/analysis/"+province+"/user_analysis","userAnalysisPage",userAnalysisPage);
	}
	
	@RequestMapping("/get_users")
	@ResponseBody
	public Object getUserAnalysis(HttpServletRequest request,UserAnalysisPage userAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		userAnalysisPage.setSysUser(sysUser);
		AreaUtil.getUserAreaParamer(userAnalysisPage, sysUser,true);
		userAnalysisPage.setUserAnalysis(userAnalysisService.getUserAnalysis(userAnalysisPage));
		DataTable table = new DataTable(userAnalysisPage.sEcho,
				userAnalysisPage.getPagerowtotal(), userAnalysisPage.getPagerowtotal(),
				userAnalysisPage.getUserAnalysis());
		return ResultUtil.responseSuccessMsg(table);
	}
	
	

	@RequestMapping("/usersource")
	public ModelAndView getUserSourceAnalysisPage(HttpServletRequest request,UserAnalysisPage userAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		
		AreaUtil.getUserAreaParamer(userAnalysisPage, sysUser,true);
		
		return new ModelAndView("/analysis/"+province+"/usersource_analysis","userAnalysisPage",userAnalysisPage);
	}
	
	@RequestMapping("/get_usersources")
	@ResponseBody
	public Object getUserSourceAnalysis(HttpServletRequest request,UserAnalysisPage userAnalysisPage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		userAnalysisPage.setSysUser(sysUser);
		AreaUtil.getUserAreaParamer(userAnalysisPage, sysUser,true);
		userAnalysisPage.setUserSourceAnalysis(userAnalysisService.getUserSourceAnalysis(userAnalysisPage));
		DataTable table = new DataTable(userAnalysisPage.sEcho,
				userAnalysisPage.getPagerowtotal(), userAnalysisPage.getPagerowtotal(),
				userAnalysisPage.getUserSourceAnalysis());
		return ResultUtil.responseSuccessMsg(table);
	}
	
	
}
