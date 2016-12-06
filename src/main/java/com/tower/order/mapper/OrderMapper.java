package com.tower.order.mapper;

import java.util.List;
import java.util.Map;

import com.tower.order.bean.Order;
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderPage;
import com.tower.order.bean.OrderState;
import com.tower.order.bean.OrderUserInfo;

public interface OrderMapper {
	
	/**
	 * 获取订单列表
	 * @param orderPage
	 * @return
	 */
	public List<Order> getOrders(OrderPage orderPage);
	
	/**
	 * 获取订单列表count
	 * @param orderPage
	 * @return
	 */
	public int getOrdersCount(OrderPage orderPage) ;
	
	/**
	 * 获取订单详情
	 * @param orderid
	 * @return
	 */
	public OrderInfo getOrderInfo(int orderid);
	
	/**
	 * 获取订单处理时的验证数据 如金额、状态 ID。等基本信息
	 */
	public OrderInfo getOrderCheckInfo(int orderid);
	
	/**
	 * 订单状态表
	 * @return
	 */
	public List<OrderState> getOrderStates(int privince);
	
	/**
	 * 修改订单状态
	 * @param map
	 * @return
	 */
	public int updateOrderState(Map<String,Object> map);
	
	
	/**
	 * 获取到期未取消订单
	 * @param province
	 * @return
	 */
	public List<Order> getCheckCancelOrder(int province);
	
	/**
	 * 获取交单为处理订单
	 * @param map
	 * @return
	 */
	public List<Order> getCheckPostUnDo(Map<String,Object> map);
	
	/**
	 * 修改用户订单信息
	 * @param orderUserInfo
	 * @return
	 */
	public int updateUserOrderInfo(OrderUserInfo orderUserInfo);
	
	

	//提交目标建站地址审核
	public int upateOrderByTargetaddress(OrderInfo orderInfo);
	
	//延期
	public int updateOrderByDelay(OrderInfo orderInfo);
	
	/**
	 * 评价订单
	 * @param map
	 * @return
	 */
	public int updateOrderPjProgress(Map<String,Object> map);

}
