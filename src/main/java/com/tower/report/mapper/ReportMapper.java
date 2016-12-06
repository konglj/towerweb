package com.tower.report.mapper;

import java.util.List;
import java.util.Map;

import com.tower.report.bean.ReportOrder;
import com.tower.report.bean.ReportOrderPage;
import com.tower.report.bean.ReportTx;
import com.tower.report.bean.ReportTxPage;
import com.tower.report.bean.ReportUser;
import com.tower.report.bean.ReportUserPage;


public interface ReportMapper {
	

	/**
	 * 订单报表
	 */
	public List<ReportOrder> getReportOrders(ReportOrderPage reportOrderPage);
	
	public int getOrdersCount(ReportOrderPage reportOrderPage);
	
	/**
	 * 订单报表导出
	 */
	public List<Map<String,Object>> getDCReportOrders(ReportOrderPage reportOrderPage);
	
	
	
	//收款报表
	public List<ReportTx> getReportTxs(ReportTxPage reportTxPage);
	
	public int getReportTxsCount(ReportTxPage reportTxPage);
	
	//收款报表导出
	public List<Map<String,Object>> getDCReportTxs(ReportTxPage reportTxPage);
	
	
	
	//用户报表
	public List<ReportUser> getReportUsers(ReportUserPage reportUserPage);
	
	public int getReportUsersCount(ReportUserPage reportUserPage);
	
	//用户报表导出
	public List<Map<String,Object>> getDCReportUsers(ReportUserPage reportUserPage);
	
	

}
