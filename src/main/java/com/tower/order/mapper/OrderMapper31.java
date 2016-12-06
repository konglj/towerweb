package com.tower.order.mapper;

import java.util.Map;

import com.tower.order.bean.OrderInfo;


public interface OrderMapper31 {

	//提交目标建站地址审核
	public int upateOrderByTargetaddress(OrderInfo orderInfo);
	
	//延期
	public int updateOrderByDelay(Map<String,Object> map);
	
	//提交租赁
	public int updateOrderByRentHt(OrderInfo orderInfo);
	
	//提交三方
	public int updateOrderByThreeHt(OrderInfo orderInfo);
	

	//提交租赁合同
	public int updateOrderByFeeApply(OrderInfo orderInfo);
	
	
	
}
