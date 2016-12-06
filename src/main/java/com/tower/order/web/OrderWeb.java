package com.tower.order.web;

import java.util.List;

import javax.jws.WebParam.Mode;
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
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderPage;
import com.tower.order.bean.OrderState;
import com.tower.order.service.OrderService;
import com.tower.system.bean.SysUser;

@Controller
@RequestMapping("/order")
public class OrderWeb {

	private OrderPage m_orderPage;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderService orderService31;

	@RequestMapping("/orders")
	public ModelAndView getOrderPage(HttpServletRequest request,
			OrderPage orderPage) {

		int isback = orderPage.getBack();
		orderPage.setBack(0);
		if (isback == 1) {
			orderPage = m_orderPage;
		} else {
			this.m_orderPage = orderPage;
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();

		String url = "";
		AreaUtil.getTowerAreaParamer(orderPage, sysUser, true);
		AreaUtil.getUserAreaParamer(orderPage, sysUser, true);
		if (orderPage.getPage() == 0) {
			url = "/order/" + province + "/orders";
			List<OrderState> orderStates = orderService
					.getOrderStates(province);
			orderPage.setOrderStates(orderStates);
		} else {
			url = "/order/" + province + "/shorders";

		}

		return new ModelAndView(url, "orderPage", orderPage);
	}

	@RequestMapping("/get_orders")
	@ResponseBody
	public Object getOrders(HttpServletRequest request, OrderPage orderPage) {
		this.m_orderPage = orderPage;
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		orderPage.setSysUser(sysUser);

		switch (sysUser.getProvince()) {
		case 31:
			orderPage.setOrderstates(new Integer[] { 8 });
			break;

		default:
			break;
		}

		// towersPage.setPageno(pageno);
		orderService.getOrders(orderPage);

		DataTable table = new DataTable(orderPage.sEcho,
				orderPage.getPagerowtotal(), orderPage.getPagerowtotal(),
				orderPage.getOrders());
		return ResultUtil.responseSuccessMsg(table);
	}

	@RequestMapping("/order_info")
	public ModelAndView getOrderInfo(HttpServletRequest request, int orderid,
			int page, int shinfo) {
		m_orderPage.setBack(1);
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		OrderInfo order = orderService.getOrderInfo(orderid);
		String url = "/order/" + province + "/order_info";
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("order", order);
		modelAndView.addObject("page", page);
		if (shinfo == 0) {
			modelAndView.addObject("loadurl", "/order/"+province+"/order_info_back.html");
		} else {
			modelAndView.addObject("loadurl", "/order/"+province+"/"+order.getTowerstateloadurl());

		}
		return modelAndView;
	}

	@RequestMapping("/order_pj")
	public ModelAndView getOrderPjPage(HttpServletRequest request,int orderid,int page){
		m_orderPage.setBack(1);
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		OrderInfo order = orderService.getOrderInfo(orderid);
		String url = "/order/" + province + "/order_info";
		ModelAndView modelAndView = new ModelAndView(url);
		modelAndView.addObject("order", order);
		modelAndView.addObject("page", page);
		modelAndView.addObject("loadurl", "/order/"+province+"/order_info_pj.html");
		return modelAndView;
		
	}
	
	
	/**
	 * 目标建站地址审核
	 * 
	 * @param request
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("/ordersh")
	@ResponseBody
	public Object orderSh(HttpServletRequest request,
			OrderInfo orderInfo) {
		if (orderInfo == null || orderInfo.getId() == 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService.updateTargetAddress(orderInfo, sysUser);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count<= 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		return ResultUtil.responseErrorMsg("审核处理成功！");
	}

	
	/**
	 * 目标建站地址审核
	 * 
	 * @param request
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("/sh_order_targetaddress")
	@ResponseBody
	public Object updateOrderTargetAddress(HttpServletRequest request,
			OrderInfo orderInfo) {
		if (orderInfo == null || orderInfo.getId() == 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService.updateTargetAddress(orderInfo, sysUser);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count <= 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		return ResultUtil.responseSuccessMsg("审核处理成功！");
	}

	
	/**
	 * 订单审核
	 * 
	 * @param request
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("/order_sh")
	@ResponseBody
	public Object updateOrderSh(HttpServletRequest request,
			OrderInfo orderInfo) {
		if (orderInfo == null || orderInfo.getId() == 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService.updateOrderSh(orderInfo, sysUser);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count <= 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		return ResultUtil.responseSuccessMsg("审核处理成功！");
	}
	
	@RequestMapping("/update_order_shjj")
	@ResponseBody
	public Object updateOrderShjj(HttpServletRequest request, OrderInfo orderInfo) {
		if (orderInfo == null)
			return ResultUtil.responseErrorMsg("");

		SysUser sysUser =SessionUtil.getUserFromSession(request);

		int count = 0;
		try {
			
			count = orderService.updateShjj(orderInfo,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (count <= 0)
			return ResultUtil.responseErrorMsg("审核拒绝失败");

		return ResultUtil.responseSuccessMsg("审核拒绝成功");
	}

	
	/**
	 * 延期审核
	 * 
	 * @param request
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("/sh_order_delay")
	@ResponseBody
	public Object updateOrderDelay(HttpServletRequest request,
			OrderInfo orderInfo) {

		if (orderInfo == null || orderInfo.getId() == 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService.updateOrderByDelay(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count<= 0) {
			return ResultUtil.responseErrorMsg("审核处理失败！");
		}
		return ResultUtil.responseSuccessMsg("审核处理成功！");
	}

	@RequestMapping("/order_evaluate")
	@ResponseBody
	public  Object updateOrderevaluate(HttpServletRequest request,
			OrderInfo orderInfo){
		if (orderInfo == null || orderInfo.getId() == 0) {
			return ResultUtil.responseErrorMsg("评价失败！");
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		try {
			count = orderService.updateOrderPjProgress(orderInfo, sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count<= 0) {
			return ResultUtil.responseErrorMsg("评价失败！");
		}
		return ResultUtil.responseSuccessMsg("评价成功！");
	}
	
	public OrderPage getM_orderPage() {
		return m_orderPage;
	}

	public void setM_orderPage(OrderPage m_orderPage) {
		this.m_orderPage = m_orderPage;
	}

}
