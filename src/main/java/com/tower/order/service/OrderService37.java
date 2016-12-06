package com.tower.order.service;


import com.tower.order.bean.OrderInfo;
import com.tower.system.bean.SysUser;

public interface OrderService37 {
	
	/**
	 * 交单后审核
	 * @param orderInfo
	 * @param sysUser
	 * @return
	 */
	public int updateJd(OrderInfo orderInfo,SysUser sysUser);
	
	//public int updateShjj(OrderInfo orderInfo,SysUser sysUser);
	
	public int updateFistFeeApply(OrderInfo orderInfo,SysUser sysUser);
	
	public int updateFistFeeSh(OrderInfo orderInfo,SysUser sysUser);
	
	
	public int updateEndFeeApply(OrderInfo orderInfo,SysUser sysUser);
	
	public int updateEndFeeSh(OrderInfo orderInfo,SysUser sysUser);
}
