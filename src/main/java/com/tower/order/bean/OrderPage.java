package com.tower.order.bean;

import java.util.List;

import com.tower.common.bean.BasePage;


public class OrderPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int role;
	
	private Integer[] orderstates;//
	
	private int page;//0 订单列表  1付款审核列表
	
	private List<Order> orders;
	
	private List<OrderState> orderStates;
	
	private OrderParameter parameter=new OrderParameter();
	
	private OrderInfo order=new OrderInfo();
	

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Integer[] getOrderstates() {
		return orderstates;
	}

	public void setOrderstates(Integer[] orderstates) {
		this.orderstates = orderstates;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<OrderState> getOrderStates() {
		return orderStates;
	}

	public void setOrderStates(List<OrderState> orderStates) {
		this.orderStates = orderStates;
	}

	public OrderParameter getParameter() {
		return parameter;
	}

	public void setParameter(OrderParameter parameter) {
		this.parameter = parameter;
	}

	public OrderInfo getOrder() {
		return order;
	}

	public void setOrder(OrderInfo order) {
		this.order = order;
	}
	
	


	

	
	
	
	
}
