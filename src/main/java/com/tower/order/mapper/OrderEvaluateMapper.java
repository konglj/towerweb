package com.tower.order.mapper;

import java.util.Map;

/**
 * 订单评价表
 * @author win7
 *
 */
public interface OrderEvaluateMapper {
	
	public int getOrderEvaluateByOrderId(Map<String,Object> map);
	
	public int updateAdminEvaluate(Map<String,Object> map);
	
	public int insertAdminEvaluate(Map<String,Object> map);
	
	public int updateUserEvaluate(Map<String,Object> map);
	
	public int insertUserEvaluate(Map<String,Object> map);
	
	
	


}
