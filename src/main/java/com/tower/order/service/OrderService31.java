package com.tower.order.service;


import com.tower.order.bean.OrderInfo;
import com.tower.system.bean.SysUser;

public interface OrderService31 {
	
	
	
	//提交租赁
	public int updateOrderByRentHt(OrderInfo orderInfo,SysUser sysUser);
	
	//提交三方
	public int updateOrderByThreeHt(String rootPath,String templetePath,OrderInfo orderInfo,SysUser sysUser);
	//三方合同审核
	public  int updateOrderByThreeSh(OrderInfo orderInfo,SysUser sysUser);
	
	//付款申请（提交单项服务协议）
	public  int updateOrderByFreeApply(OrderInfo orderInfo,SysUser sysUser);
	
	//付款审核
	public  int updateOrderByFreeSh(OrderInfo orderInfo,SysUser sysUser);
}
