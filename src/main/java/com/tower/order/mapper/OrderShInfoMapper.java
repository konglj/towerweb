package com.tower.order.mapper;

import java.util.List;

import com.tower.order.bean.OrderShInfo;


public interface OrderShInfoMapper {
	
	public List<OrderShInfo> getShInfos(int orderid);
	
	public int insertTowerShInfo(OrderShInfo shInfos);
	

}
