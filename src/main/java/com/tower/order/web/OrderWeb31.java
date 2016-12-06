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
import com.tower.system.bean.SysUser;

@Controller
@RequestMapping("/order/31")
public class OrderWeb31 {

	@Autowired
	private OrderService31 orderService31;
	
	@Autowired
	private DictService dictService;
	@RequestMapping("/order_info_back")
	public ModelAndView getOrderInfoBackPage1() {
		String url = "/order/31/order_info_back";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_delay")
	public ModelAndView getOrderInfoDelay(HttpServletRequest request){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		String url = "/order/31/order_info_delay";
		Dict dict=new Dict(DictUtil.order_delay_day,sysUser.getProvince());
		dict=dictService.getDict(dict);
		Map<String, String> map=new HashMap<String, String>();
		if(dict!=null&&dict.getMapInfo()!=null){
			map=dict.getMapInfo();
		}
		return new ModelAndView(url,"info",map);
	}

	@RequestMapping("/order_info_sh_address")
	public ModelAndView getOrderInfoTargetaddressPage() {
		String url = "/order/31/order_info_sh_address";
		return new ModelAndView(url);
	}

	@RequestMapping("/order_info_rentht")
	public ModelAndView getOrderInfoRentht() {
		String url = "/order/31/order_info_rentht";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_threeht")
	public ModelAndView getOrderInfoThreeht() {
		String url = "/order/31/order_info_threeht";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_sh_threeht")
	public ModelAndView getOrderInfoShThreeht() {
		String url = "/order/31/order_info_sh_threeht";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_fee_apply")
	public ModelAndView getOrderInfoFeeApply() {
		String url = "/order/31/order_info_fee_apply";
		return new ModelAndView(url);
	}
	
	@RequestMapping("/order_info_sh_fee")
	public ModelAndView getOrderInfoShFee() {
		String url = "/order/31/order_info_sh_fee";
		return new ModelAndView(url);
	}


	@RequestMapping("/order_info_pj")
	public ModelAndView getOrderPjPageUrl(HttpServletRequest request){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		return new ModelAndView("/order/"+province+"/order_info_pj");
		
	}


	@RequestMapping("/update_rentht")
	@ResponseBody
	public Object updateRentht(HttpServletRequest request, OrderInfo orderInfo,
			int ischeckht) {
		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("");

		if (orderInfo.getIscheckht() == 2) {
			String image = orderInfo.getTowerhtimag();
			if (image == null || image.equals(""))
				return ResultUtil.responseErrorMsg("");
		} else if (orderInfo.getIscheckht() == 1) {
			if (orderInfo.getTowerhtid() == null
					|| orderInfo.getTowerhtid().equals("")) {
				return ResultUtil.responseErrorMsg("提交失败");
			}
		} else {
			orderInfo.setTowerhtid("0");
		}
		SysUser sysUser =SessionUtil.getUserFromSession(request);

		int count = 0;
		try {
			orderInfo.setShresult(1);
			count = orderService31.updateOrderByRentHt(orderInfo,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("提交失败！");

		return ResultUtil.responseSuccessMsg("提交成功！");
	}

	@RequestMapping("/update_threeht")
	@ResponseBody
	public Object updateThreeHt(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			String rootpath=request.getSession().getServletContext().getRealPath("/");
			
			String templatePath=request.getSession().getServletContext().getRealPath(TemplateDocUtil.TEMPLATE_PATH+File.separator+sysUser.getProvince());
			count = orderService31.updateOrderByThreeHt(rootpath,templatePath,
					orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("");

		return ResultUtil.responseSuccessMsg("success");
	}
	
	@RequestMapping("/update_sh_threeht")
	@ResponseBody
	public Object updateShThreeHt(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService31.updateOrderByThreeSh(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("");

		return ResultUtil.responseSuccessMsg("success");
	}
	
	

	@RequestMapping("/update_fee_apply")
	@ResponseBody
	public Object updateFeeApply(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService31.updateOrderByFreeApply(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("");

		return ResultUtil.responseSuccessMsg("success");
	}
	
	@RequestMapping("/update_sh_fee")
	@ResponseBody
	public Object updateShFee(HttpServletRequest request,OrderInfo orderInfo){


		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("审核失败！");
		SysUser sysUser =SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService31.updateOrderByFreeSh(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("审核失败！");

		return ResultUtil.responseSuccessMsg("审核成功！");
	}
	
	
}
