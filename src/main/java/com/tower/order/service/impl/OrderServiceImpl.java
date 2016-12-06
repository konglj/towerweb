package com.tower.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.tower.common.bean.Dict;
import com.tower.common.mapper.DictMapper;
import com.tower.common.util.TimeUtil;
import com.tower.common.util.proj.DictUtil;
import com.tower.order.bean.Order;
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderPage;
import com.tower.order.bean.OrderShInfo;
import com.tower.order.bean.OrderState;
import com.tower.order.bean.OrderUserInfo;
import com.tower.order.mapper.OrderEvaluateMapper;
import com.tower.order.mapper.OrderMapper;
import com.tower.order.mapper.OrderShInfoMapper;
import com.tower.order.service.OrderService;
import com.tower.order.util.OrderUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerReport;
import com.tower.tower.mapper.TowerMapper;
import com.tower.tower.mapper.TowerReportMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderShInfoMapper shInfoMapper;

	@Autowired
	private TowerMapper towerMapper;

	@Autowired
	private DictMapper dictMapper;

	@Autowired
	private TowerReportMapper towerReportMapper;

	@Autowired
	private OrderEvaluateMapper evaluateMapper;

	@Override
	public List<Order> getOrders(OrderPage orderPage) {
		int count = orderMapper.getOrdersCount(orderPage);
		List<Order> orders = orderMapper.getOrders(orderPage);
		orderPage.setPagerowtotal(count);
		orderPage.setOrders(orders);
		return orders;
	}

	@Override
	public OrderInfo getOrderInfo(int orderid) {
		OrderInfo orderInfo = orderMapper.getOrderInfo(orderid);
		List<OrderShInfo> shInfos = shInfoMapper.getShInfos(orderid);
		orderInfo.setShInfos(shInfos);
		return orderInfo;
	}

	@Override
	public List<OrderState> getOrderStates(int privince) {
		return orderMapper.getOrderStates(privince);
	}

	@Override
	public int updateOrderState(Map<String, Object> map) {
		return 0;
	}

	@Override
	public List<Order> getCheckCancelOrder(int province) {

		return null;
	}

	@Override
	public List<Order> getCheckPostUnDo(Map<String, Object> map) {

		return null;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderSh(OrderInfo orderInfo, SysUser sysUser) {
		int count = 0;
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int updatestate = 0;
		if ((updatestate = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updatestate;
		}
		// 1 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", checkOrder.getId());
		map.put("towerstate", updatestate);
		if (checkOrder.getTowerrelease() == 1 && orderInfo.getShresult() == 0) {
			map.put("towerabandontime", TimeUtil.getNow());
		}
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");

		count = updateOrder(checkOrder, orderInfo, updatestate, sysUser);
		if (count == 0)
			throw new RuntimeException("处理失败！");
		return 1;
	}

	/**
	 * 审核签约时的审核拒绝
	 */
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateShjj(OrderInfo orderInfo, SysUser sysUser) {
		orderInfo.setShresult(0);
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 修改订单状态
		orderInfo.setTowerstate(updateState);

		// 1 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", checkOrder.getId());
		map.put("towerstate", updateState);
		map.put("towerabandontime", TimeUtil.getNow());
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");
		// 2 释放站址
		// 订单是否无效
		// 释放站址
		count = updateTowerLevel(checkOrder, sysUser);
		if (count == 0)
			throw new RuntimeException("释放站址失败");

		TowerReport report = new TowerReport();
		report.setTowerid(checkOrder.getTowerid());
		report.setRejectcount(1);
		report.setConrejectcount(1);
		count = updateTowerReport(report);
		if (count == 0)
			throw new RuntimeException("站址统计失败！");

		// 3 修改用户抢单记录
		OrderUserInfo orderUserInfo = new OrderUserInfo();
		orderUserInfo.setUserid(checkOrder.getUserid());
		orderUserInfo.setFailcount(1);
		orderUserInfo.setIngcount(checkOrder.getOrderreleaseingcount());
		orderUserInfo.setRejectcount(1);
		orderUserInfo.setSucccount(-1);
		count = orderMapper.updateUserOrderInfo(orderUserInfo);
		if (count == 0)
			throw new RuntimeException("用户订单统计失败！");
		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;

	}

	/**
	 * 目标建站地址审核
	 */
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateTargetAddress(OrderInfo orderInfo,
			SysUser sysUser) {
		int count = 0;
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int updatestate = 0;
		if ((updatestate = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updatestate;
		}
		orderInfo.setTowerstate(updatestate);
		orderInfo.setOrderisdeal(OrderUtil.getOrderDeal(checkOrder, orderInfo));
		count = orderMapper.upateOrderByTargetaddress(orderInfo);
		if (count == 0)
			throw new RuntimeException("订单处理失败！");
		count = updateOrder(checkOrder, orderInfo, updatestate, sysUser);
		if (count == 0)
			throw new RuntimeException("处理失败！");
		return 1;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderByDelay(OrderInfo orderInfo,
			SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int updateState = 0;
		int count = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) <= 0) {
			return updateState;
		}
		orderInfo.setTowerstate(updateState);
		orderInfo.setOrderisdeal(OrderUtil.getOrderDeal(checkOrder, orderInfo));
		count = orderMapper.updateOrderByDelay(orderInfo);
		if (count == 0)
			throw new RuntimeException("修改订单失败！");

		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");

		return 1;
	}

	@Override
	public int updateOrderShReject(int orderid, int state) {
		return 0;
	}

	/**
	 * 站址释放处理()
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrder(OrderInfo checkOrder,
			OrderInfo orderInfo, int updateState, SysUser sysUser) {
		// 1 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;

		// 2 释放站址
		// 订单是否无效
		if (orderInfo.getShresult()==0&&checkOrder.getTowerrelease() == 1) {
			// 释放站址
			map = new HashMap<String, Object>();
			map.put("towerid", checkOrder.getTowerid());
			map.put("towerstate", 0);
			count = towerMapper.updateTowerState(map);
			if (count == 0)
				throw new RuntimeException("释放站址失败");

			// 3 判断是否是降级处理
			Dict dict = new Dict(DictUtil.order_sh_tower_degrade,
					sysUser.getProvince());
			dict = dictMapper.getDict(dict);
			if (dict != null && dict.getId() > 0 && dict.getMapInfo() != null) {
				Map<String, String> mapInfo = dict.getMapInfo();
				Integer con_reject_count = Integer.valueOf(mapInfo
						.get("con_reject_count"));
				Integer tower_level = Integer.valueOf(mapInfo
						.get("tower_level"));
				if (con_reject_count != null && tower_level != null
						&& con_reject_count > 0 && tower_level > 0) {
					if (checkOrder.getTowerconrejectcount() > 0
							&& checkOrder.getTowerconrejectcount()
									% con_reject_count == 0) {
						if (checkOrder.getTowerlevel() != tower_level) {
							Map<String, Object> mapLevel = new HashMap<String, Object>();
							mapLevel.put("towerid", checkOrder.getTowerid());
							mapLevel.put("towerlevel", tower_level);
							count = towerMapper.updateTowerLevel(mapLevel);
							if (count == 0)
								throw new RuntimeException("降级失败！");
						}
					}
				}

			}
			TowerReport report = new TowerReport();
			report.setTowerid(checkOrder.getTowerid());
			report.setRejectcount(1);
			report.setConrejectcount(1);
			count = updateTowerReport(report);
			if (count == 0)
				throw new RuntimeException("站址统计失败！");
			// 3 修改用户抢单记录
			OrderUserInfo orderUserInfo = new OrderUserInfo();
			orderUserInfo.setUserid(checkOrder.getUserid());
			orderUserInfo.setFailcount(1);
			orderUserInfo.setIngcount(checkOrder.getOrderreleaseingcount());
			orderUserInfo.setRejectcount(1);
			count = orderMapper.updateUserOrderInfo(orderUserInfo);
			if (count == 0)
				throw new RuntimeException("用户订单统计失败！");
		}
		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;
	}

	/**
	 * 修改站址统计
	 */
	public int updateTowerReport(TowerReport report) {
		int count = 0;
		count = towerReportMapper.checkTowerExist(report.getTowerid());
		if (count == 0) {
			count = towerReportMapper.insertTowerReport(report);
		} else {
			count = towerReportMapper.upateTowerReport(report);

		}
		return count;
	}

	/**
	 * 站址释放
	 * 
	 * @param checkOrder
	 * @param sysUser
	 * @return
	 */
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateTowerLevel(OrderInfo checkOrder,
			SysUser sysUser) {
		// 释放站址
		int count = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("towerid", checkOrder.getTowerid());
		map.put("towerstate", 0);
		count = towerMapper.updateTowerState(map);
		if (count == 0)
			throw new RuntimeException("释放站址失败");

		// 3 判断是否是降级处理
		Dict dict = new Dict(DictUtil.order_sh_tower_degrade,
				sysUser.getProvince());
		dict = dictMapper.getDict(dict);
		if (dict != null && dict.getId() > 0 && dict.getMapInfo() != null) {
			Map<String, String> mapInfo = dict.getMapInfo();
			Integer con_reject_count = Integer.valueOf(mapInfo
					.get("con_reject_count"));
			Integer tower_level = Integer.valueOf(mapInfo.get("tower_level"));
			if (con_reject_count != null && tower_level != null
					&& con_reject_count > 0 && tower_level > 0) {
				if (checkOrder.getTowerconrejectcount() > 0
						&& checkOrder.getTowerconrejectcount()
								% con_reject_count == 0) {
					if (checkOrder.getTowerlevel() != tower_level) {
						Map<String, Object> mapLevel = new HashMap<String, Object>();
						mapLevel.put("towerid", checkOrder.getTowerid());
						mapLevel.put("towerlevel", tower_level);
						count = towerMapper.updateTowerLevel(mapLevel);
						if (count == 0)
							throw new RuntimeException("降级失败！");
					}
				}
			}

		}
		return 1;
	}

	/**
	 * 订单评价
	 * 
	 * @param map
	 * @return
	 */
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderPjProgress(OrderInfo orderInfo,
			SysUser sysUser) {
		int count = 0;
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		if(checkOrder.getTowerpjprogress()==2||checkOrder.getTowerpjprogress()==3)
			throw new RuntimeException("已评价过！");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", orderInfo.getId());
		map.put("progress", 2);
		count = orderMapper.updateOrderPjProgress(map);
		if (count == 0)
			throw new RuntimeException("修改评价进度失败！");
		count = 0;
		map.put("admincontent", orderInfo.getShinfo());
		int evaluate = evaluateMapper.getOrderEvaluateByOrderId(map);
		if (evaluate == 0) {
			count = evaluateMapper.insertAdminEvaluate(map);
		} else {
			count = evaluateMapper.updateAdminEvaluate(map);
		}
		if (count == 0)
			throw new RuntimeException("插入评价记录失败");

		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(orderInfo.getId(),
				"", 24, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;
	}

}
