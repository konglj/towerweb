package com.tower.report.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.report.bean.ReportOrder;
import com.tower.report.bean.ReportOrderPage;
import com.tower.report.bean.ReportTx;
import com.tower.report.bean.ReportTxPage;
import com.tower.report.bean.ReportUser;
import com.tower.report.bean.ReportUserPage;
import com.tower.report.mapper.ReportMapper;
import com.tower.report.service.ReportService;


@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportMapper reportMapper;
	@Override
	public List<ReportOrder> getReportOrders(ReportOrderPage reportOrderPage) {
		int count = reportMapper.getOrdersCount(reportOrderPage);
		reportOrderPage.setPagerowtotal(count);
		List<ReportOrder> orders=reportMapper.getReportOrders(reportOrderPage);
		reportOrderPage.setOrders(orders);
		return orders;

	}
	@Override
	public List<Map<String,Object>> getDCReportOrders(ReportOrderPage reportOrderPage) {
		return reportMapper.getDCReportOrders(reportOrderPage);
	}
	@Override
	public List<ReportTx> getReportTxs(ReportTxPage reportTxPage) {
		int count = reportMapper.getReportTxsCount(reportTxPage);
		reportTxPage.setPagerowtotal(count);
		List<ReportTx>  txs=reportMapper.getReportTxs(reportTxPage);
		reportTxPage.setReportTxs(txs);
		return txs ;
	}
	@Override
	public List<Map<String,Object>> getDCReportTxs(ReportTxPage reportTxPage) {
		return reportMapper.getDCReportTxs(reportTxPage);
	}
	@Override
	public List<ReportUser> getReportUsers(ReportUserPage reportUserPage) {
		int count = reportMapper.getReportUsersCount(reportUserPage);
		reportUserPage.setPagerowtotal(count);
		List<ReportUser> reportUsers=reportMapper.getReportUsers(reportUserPage);
		reportUserPage.setReportUsers(reportUsers);
		return reportUsers;
	}
	@Override
	public List<Map<String,Object>> getDCReportUsers(ReportUserPage reportUserPage) {
		return reportMapper.getDCReportUsers(reportUserPage);
	}

}
