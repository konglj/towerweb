package com.tower.report.bean;

import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;
import com.tower.order.bean.OrderState;

public class ReportOrderPage extends BasePage {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ReportOrder> orders=new ArrayList<ReportOrder>();
	
	private ReportOrderParameter parameter=new ReportOrderParameter();
	
	private List<OrderState> orderStates=new ArrayList<OrderState>();

	public List<ReportOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ReportOrder> orders) {
		this.orders = orders;
	}

	public ReportOrderParameter getParameter() {
		return parameter;
	}

	public void setParameter(ReportOrderParameter parameter) {
		this.parameter = parameter;
	}

	public List<OrderState> getOrderStates() {
		return orderStates;
	}

	public void setOrderStates(List<OrderState> orderStates) {
		this.orderStates = orderStates;
	}
	
	
	
	
	
	
	
	
	

	
}
