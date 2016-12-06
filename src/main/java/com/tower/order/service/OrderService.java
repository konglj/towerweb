package com.tower.order.service;

import java.util.List;
import java.util.Map;

import com.tower.order.bean.Order;
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderPage;
import com.tower.order.bean.OrderState;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerReport;

public interface OrderService {

	/**
	 * 获取订单列表
	 * @param orderPage
	 * @return
	 */
	public List<Order> getOrders(OrderPage orderPage);
	
	/**
	 * 获取订单详情
	 * @param orderid
	 * @return
	 */
	public OrderInfo getOrderInfo(int orderid);
	
	
	/**
	 * 订单状态表
	 * @return
	 */
	public List<OrderState> getOrderStates(int province);
	
	
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
	 * 获取交单未处理订单
	 * @param map
	 * @return
	 */
	public List<Order> getCheckPostUnDo(Map<String,Object> map);
	
	
	/**
	 * 审核拒绝
	 * @param orderid
	 * @param state
	 * @return
	 */
	public int  updateOrderShReject(int orderid,int state);
	
	
	/**
	 * 审核处理
	 * @param orderInfo
	 * @return
	 */
	public int updateOrderSh(OrderInfo orderInfo,SysUser sysUser);
	
	/**
	 * 签约后的审核拒绝
	 * @param orderInfo
	 * @param sysUser
	 * @return
	 */
	public  int updateShjj(OrderInfo orderInfo, SysUser sysUser);
	
	/**
	 * 提交目标建站地址
	 * @param orderInfo
	 * @return
	 */
	public int updateTargetAddress(OrderInfo orderInfo,SysUser sysUser);
	
	/**
	 * 延期处理
	 * @param orderInfo
	 * @param sysUser
	 * @return
	 */
	public int updateOrderByDelay(OrderInfo orderInfo,SysUser sysUser);
	
	/**
	 * 站址释放
	 * 
	 * @param checkOrder
	 * @param sysUser
	 * @return
	 */
	public int updateTowerLevel(OrderInfo checkOrder, SysUser sysUser) ;
	/**
	 * 订单评价
	 * @param map
	 * @return
	 */
	public int updateOrderPjProgress(OrderInfo orderInfo,SysUser sysUser);
}
