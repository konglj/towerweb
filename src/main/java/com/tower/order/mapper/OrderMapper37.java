package com.tower.order.mapper;


import com.tower.order.bean.OrderInfo;


public interface OrderMapper37 {

	//提交目标建站地址审核
	public int upateOrderByFirstFeeApply(OrderInfo orderInfo);
	
	//延期
	public int upateOrderByEndFeeApply(OrderInfo orderInfo);
	
	
	
	
}
