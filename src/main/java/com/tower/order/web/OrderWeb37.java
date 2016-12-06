package com.tower.order.web;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.Config;
import com.tower.common.bean.Dict;
import com.tower.common.mapper.DictMapper;
import com.tower.common.service.DictService;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.TemplateDocUtil;
import com.tower.common.util.proj.DictUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.order.bean.OrderInfo;
import com.tower.order.service.OrderService31;
import com.tower.order.service.OrderService37;
import com.tower.system.bean.SysUser;

@Controller
@RequestMapping("/order/37")
public class OrderWeb37 {

	@Autowired
	private OrderService37 orderService37;
	
	@Autowired
	private DictService dictService;
	@RequestMapping("/order_info_back")
	public ModelAndView getOrderInfoBackPage1() {
		String url = "/order/37/order_info_back";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_delay")
	public ModelAndView getOrderInfoDelay(HttpServletRequest request){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		String url = "/order/37/order_info_delay";
		Dict dict=new Dict(DictUtil.order_delay_day,sysUser.getProvince());
		dict=dictService.getDict(dict);
		Map<String, String> map=new HashMap<String, String>();
		if(dict!=null&&dict.getMapInfo()!=null){
			map=dict.getMapInfo();
		}
		return new ModelAndView(url,"info",map);
	}


	@RequestMapping("/order_info_sh_reject")
	public ModelAndView getOrderInfoRentht() {
		String url = "/order/37/order_info_sh_reject";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_sh")
	public ModelAndView getOrderInfoThreeht() {
		String url = "/order/37/order_info_sh";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_firstfee_apply")
	public ModelAndView getOrderInfoFirstFeeApply() {
		String url = "/order/37/order_info_firstfee_apply";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_endfee_apply")
	public ModelAndView getOrderInfoFirstEndApply() {
		String url = "/order/37/order_info_endfee_apply";
		return new ModelAndView(url);
	}
	
	
	
	@RequestMapping("/order_info_sh_firstfee")
	public ModelAndView getOrderInfoFeeApply() {
		String url = "/order/37/order_info_sh_firstfee";
		return new ModelAndView(url);
	}
	
	
	@RequestMapping("/order_info_sh_endfee")
	public ModelAndView getOrderInfoShEndFee() {
		String url = "/order/37/order_info_sh_endfee";
		return new ModelAndView(url);
	}

	@RequestMapping("/order_info_pj")
	public ModelAndView getOrderPjPageUrl(HttpServletRequest request){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		return new ModelAndView("/order/"+province+"/order_info_pj");
		
	}
	
	/**
	 * 交单后的审核处理
	 * @param request
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("/sh_order_jd")
	@ResponseBody
	public Object updateOrderShJd(HttpServletRequest request, OrderInfo orderInfo){
		
		SysUser sysUser =SessionUtil.getUserFromSession(request);

		int count = 0;
		try {
			
			count = orderService37.updateJd(orderInfo,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("审核处理失败！");

		return ResultUtil.responseSuccessMsg("审核处理成功！");
	}
	

	


	@RequestMapping("/update_firstfee_apply")
	@ResponseBody
	public Object updateFirstFeeApply(HttpServletRequest request, OrderInfo orderInfo) {
		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("提交处理失败！");

		SysUser sysUser =SessionUtil.getUserFromSession(request);

		int count = 0;
		try {
			orderInfo.setShresult(1);
			count = orderService37.updateFistFeeApply(orderInfo,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("提交处理失败！");

		return ResultUtil.responseSuccessMsg("提交处理成功");
	}

	
	@RequestMapping("/update_sh_firstfee")
	@ResponseBody
	public Object updateShFirstFee(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("审核处理失败");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService37.updateFistFeeSh(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("审核处理失败");

		return ResultUtil.responseSuccessMsg("审核处理成功");
	}
	
	

	@RequestMapping("/update_endfee_apply")
	@ResponseBody
	public Object updateEndFeeApply(HttpServletRequest request, OrderInfo orderInfo) {
		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("提交处理失败！");

		SysUser sysUser =SessionUtil.getUserFromSession(request);

		int count = 0;
		try {
			orderInfo.setShresult(1);
			count = orderService37.updateEndFeeApply(orderInfo,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("提交处理失败！");

		return ResultUtil.responseSuccessMsg("提交处理成功");
	}

	
	@RequestMapping("/update_sh_endfee")
	@ResponseBody
	public Object updateShEndFee(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("审核处理失败");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService37.updateEndFeeSh(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("审核处理失败");

		return ResultUtil.responseSuccessMsg("审核处理成功");
	}
	
	
}
