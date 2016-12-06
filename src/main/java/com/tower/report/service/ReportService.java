package com.tower.report.service;

import java.util.List;
import java.util.Map;

import com.tower.report.bean.ReportOrder;
import com.tower.report.bean.ReportOrderPage;
import com.tower.report.bean.ReportTx;
import com.tower.report.bean.ReportTxPage;
import com.tower.report.bean.ReportUser;
import com.tower.report.bean.ReportUserPage;

public interface ReportService {
	
	//订单报表
	public List<ReportOrder> getReportOrders(ReportOrderPage reportOrderPage);
	
	//导出订单报表
	public List<Map<String,Object>> getDCReportOrders(ReportOrderPage reportOrderPage);
	
	
	
	
	//收款报表
	public List<ReportTx> getReportTxs(ReportTxPage reportTxPage);
	
	//收款报表导出
	public List<Map<String,Object>> getDCReportTxs(ReportTxPage reportTxPage);
	
	
	
	//用户报表
	public List<ReportUser> getReportUsers(ReportUserPage reportUserPage);
	
	//用户报表导出
	public List<Map<String,Object>> getDCReportUsers(ReportUserPage reportUserPage);
	
	

}
