package com.tower.report.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.bean.DataTable;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.order.bean.OrderState;
import com.tower.order.service.OrderService;
import com.tower.report.bean.ReportOrderPage;
import com.tower.report.bean.ReportTxPage;
import com.tower.report.bean.ReportUserPage;
import com.tower.report.service.ReportService;
import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserType;
import com.tower.user.service.UserService;

@Controller
@RequestMapping("/report")
public class ReportWeb {
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/order")
	public ModelAndView getReportOrders(HttpServletRequest request,
			ReportOrderPage reportOrderPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		
		List<OrderState> orderStates=orderService.getOrderStates(province);
		reportOrderPage.setOrderStates(orderStates);
		
		AreaUtil.getTowerAreaParamer(reportOrderPage, sysUser, true);
		
		return new ModelAndView("/report/"+province+"/order_report");
	}
	
	
	@RequestMapping("/get_orders")
	@ResponseBody
	public Object  getOrders(HttpServletRequest request,
			ReportOrderPage reportOrderPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		reportOrderPage.setSysUser(sysUser);
		reportService.getReportOrders(reportOrderPage);
		
		DataTable table = new DataTable(reportOrderPage.sEcho,
				reportOrderPage.getPagerowtotal(), reportOrderPage.getPagerowtotal(),
				reportOrderPage.getOrders());

		return ResultUtil.responseSuccessMsg(table);
	}
	
	
	@RequestMapping("/user")
	public ModelAndView getReportUsers(HttpServletRequest request,
			ReportUserPage reportUserPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		
		List<UserLevel> userLevels=userService.getUserLevels(province);
		reportUserPage.setUserLevels(userLevels);
		
		List<UserType> userTypes=userService.getUserTypes();
		reportUserPage.setUserTypes(userTypes);
		
		AreaUtil.getUserAreaParamer(reportUserPage, sysUser, true);
		return new ModelAndView("/report/"+province+"/user_report","reportUserPage",reportUserPage);
	}
	
	@RequestMapping("/get_users")
	@ResponseBody
	public Object  getUsers(HttpServletRequest request,
			ReportUserPage reportUserPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		reportUserPage.setSysUser(sysUser);
		reportService.getReportUsers(reportUserPage);
		
		DataTable table = new DataTable(reportUserPage.sEcho,
				reportUserPage.getPagerowtotal(), reportUserPage.getPagerowtotal(),
				reportUserPage.getReportUsers());

		return ResultUtil.responseSuccessMsg(table);
	}
	
	@RequestMapping("/tx")
	public ModelAndView getReportTx(HttpServletRequest request,
			ReportTxPage reportTxPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		
		List<UserLevel> userLevels=userService.getUserLevels(province);
		reportTxPage.setUserLevels(userLevels);
		
		List<UserType> userTypes=userService.getUserTypes();
		reportTxPage.setUserTypes(userTypes);
		
		AreaUtil.getUserAreaParamer(reportTxPage, sysUser, true);
		
		return new ModelAndView("/report/"+province+"/tx_report","reportTxPage",reportTxPage);
	}
	
	@RequestMapping("/get_txs")
	@ResponseBody
	public Object  getTxs(HttpServletRequest request,
			ReportTxPage reportTxPage) {
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		reportTxPage.setSysUser(sysUser);
		reportService.getReportTxs(reportTxPage);
		
		DataTable table = new DataTable(reportTxPage.sEcho,
				reportTxPage.getPagerowtotal(), reportTxPage.getPagerowtotal(),
				reportTxPage.getReportTxs());

		return ResultUtil.responseSuccessMsg(table);
	}
}
