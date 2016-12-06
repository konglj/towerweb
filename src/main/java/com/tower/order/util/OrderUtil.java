package com.tower.order.util;

import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderShInfo;
import com.tower.system.bean.SysUser;

public class OrderUtil {

	/**
	 * 验证订单状态是否正确(返回处理后状态)
	 * @param checkOrder
	 * @param orderInfo
	 * @return
	 */
	public static int checkOldOrder(OrderInfo checkOrder, OrderInfo orderInfo) {
		if (checkOrder == null) {
			return -1;
		}
		if (checkOrder.getTowerstate() != orderInfo.getTowerstate()) {
			return -2;
		}
		
		return 1;
	}
	
	/**
	 * 获取处理订单后状态
	 * @param checkOrder
	 * @param orderInfo
	 * @return
	 */
	public static int getOrderUpdateState(OrderInfo checkOrder, OrderInfo orderInfo){
		if (checkOrder == null) {
			return -1;
		}
		if (checkOrder.getTowerstate() != orderInfo.getTowerstate()) {
			return -2;
		}
		int updatestate=0;
		if(orderInfo.getShresult()==1){
			updatestate=checkOrder.getOrdersuccessstate();
		}else if(orderInfo.getShresult()==0){
			updatestate=checkOrder.getOrdererrorstate();
		}
		return updatestate;
	}
	
	/**
	 * 获取处理订单后站址是否释放
	 * @param checkOrder
	 * @param orderInfo
	 * @return
	 */
	public static Boolean isTowerRelease(OrderInfo checkOrder){
		if(checkOrder.getTowerrelease()==1){
			return true;
		}
		return false;
	}
	
	/**
	 * 组装 管理员审核记录 shinfo
	 * @param orderid
	 * @param updatestate
	 * @param sysUser
	 * @return
	 */
	public static OrderShInfo getOrderShInfo(int orderid,String shinfo,int updatestate,SysUser sysUser){
		OrderShInfo shInfo = new OrderShInfo();
		shInfo.setOrderid(orderid);
		shInfo.setOrdername(sysUser.getName());
		shInfo.setOrderuser(sysUser.getName());
		shInfo.setOrderphone(sysUser.getPhone());
		shInfo.setOrderstate(updatestate);
		shInfo.setOrdershinfo(shinfo);
		shInfo.setProvince(sysUser.getProvince());
		shInfo.setOrdertype(sysUser.getPower());
		
		return shInfo;
		
	}
	
	public static int getOrderDeal(OrderInfo checkOrder, OrderInfo orderInfo){
		if(orderInfo.getShresult()==1)
			return checkOrder.getOrdersuccessdeal();
		return checkOrder.getOrdererrordeal();
	}
	
}
