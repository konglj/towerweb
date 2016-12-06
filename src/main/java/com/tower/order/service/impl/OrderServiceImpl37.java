package com.tower.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Timed;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.tower.common.bean.Dict;
import com.tower.common.mapper.DictMapper;
import com.tower.common.util.FormatUtil;
import com.tower.common.util.TimeUtil;
import com.tower.common.util.proj.DictUtil;
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderShInfo;
import com.tower.order.bean.OrderUserInfo;
import com.tower.order.mapper.OrderMapper;
import com.tower.order.mapper.OrderMapper37;
import com.tower.order.mapper.OrderShInfoMapper;
import com.tower.order.service.OrderService;
import com.tower.order.service.OrderService37;
import com.tower.order.util.OrderUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerReport;
import com.tower.tower.mapper.TowerMapper;
import com.tower.tower.mapper.TowerReportMapper;
import com.tower.user.bean.UserMoney;
import com.tower.user.service.UserService;

@Service
public class OrderServiceImpl37 implements OrderService37 {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderMapper37 orderMapper37;

	@Autowired
	private UserService userService;

	@Autowired
	private TowerMapper towerMapper;

	@Autowired
	private DictMapper dictMapper;

	@Autowired
	private TowerReportMapper towerReportMapper;

	@Autowired
	private OrderShInfoMapper shInfoMapper;

	@Autowired
	private OrderService orderService;

	/**
	 * 交单后审核
	 */
	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateJd(OrderInfo orderInfo, SysUser sysUser) {
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
		if (orderInfo.getShresult() == 0) {
			map.put("towerabandontime", TimeUtil.getNow());
		}
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");
		// 2 释放站址
		// 订单是否无效
		OrderUserInfo orderUserInfo = new OrderUserInfo();
		if (orderInfo.getShresult() == 0) {
			if (checkOrder.getTowerrelease() == 1) {
				// 站址释放
				count = orderService.updateTowerLevel(checkOrder, sysUser);
				if (count == 0)
					throw new RuntimeException("修改订单状态失败");
				// 修改站址统计
				TowerReport report = new TowerReport();
				report.setTowerid(checkOrder.getTowerid());
				report.setRejectcount(1);
				report.setConrejectcount(1);
				count = updateTowerReport(report);
				if (count == 0)
					throw new RuntimeException("站址统计失败！");
			}

			// 3 修改用户抢单记录
			orderUserInfo.setUserid(checkOrder.getUserid());
			orderUserInfo.setFailcount(1);
			orderUserInfo.setIngcount(checkOrder.getOrderreleaseingcount());
			orderUserInfo.setRejectcount(1);

		} else {
			// 3 修改用户抢单记录
			orderUserInfo.setUserid(checkOrder.getUserid());
			orderUserInfo.setIngcount(-1);
			orderUserInfo.setConcancelcount(0 - checkOrder.getCancelcount());
			orderUserInfo.setSucccount(1);
		}

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

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateFistFeeApply(OrderInfo orderInfo,
			SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 修改订单状态
		orderInfo.setTowerstate(updateState);
		count = orderMapper37.upateOrderByFirstFeeApply(orderInfo);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");
		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized  int updateFistFeeSh(OrderInfo orderInfo, SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", checkOrder.getId());
		map.put("towerstate", updateState);
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("");
		// 如果审核成功
		if (orderInfo.getShresult() == 1) {

			Dict dict = new Dict(DictUtil.order_first_fee_rewards,
					sysUser.getProvince());
			dict = dictMapper.getDict(dict);
			// 是否存在修改用户积分、经验等奖励
			UserMoney userMoney = new UserMoney();
			if (dict != null && dict.getMapInfo() != null) {
				// 积分奖励
				int score = FormatUtil.StringToInt(dict.getMapInfo().get(
						"score"));
				int exp = FormatUtil.StringToInt(dict.getMapInfo().get("exp"));
				String reason = dict.getMapInfo().get("reason");

				userMoney.setScore(score);
				userMoney.setExp(exp);
				userMoney.setScorereason(reason);
				userMoney.setCharge(checkOrder.getTowerfee());
				userMoney.setGetnow(checkOrder.getTowerfirstfee());
				userMoney.setUserid(checkOrder.getUserid());
				userMoney.setGetnowtype(0);

			} else {
				// 无积分奖励
				userMoney.setCharge(checkOrder.getTowerfee());
				userMoney.setGetnow(checkOrder.getTowerfirstfee());
				userMoney.setUserid(checkOrder.getUserid());
				userMoney.setGetnowtype(0);
			}
			userMoney.setOrderid(checkOrder.getId());
			count = userService.updateUserMoney(userMoney, sysUser);
			if (count == 0)
				throw new RuntimeException();
		}

		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized  int updateEndFeeApply(OrderInfo orderInfo, SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 修改订单状态
		orderInfo.setTowerstate(updateState);
		count = orderMapper37.upateOrderByEndFeeApply(orderInfo);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");
		// 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		return 1;
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized  int updateEndFeeSh(OrderInfo orderInfo, SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", checkOrder.getId());
		map.put("towerstate", updateState);
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("");
		// 如果审核成功
		if (orderInfo.getShresult() == 1) {

			Dict dict = new Dict(DictUtil.order_end_fee_rewards,
					sysUser.getProvince());
			dict = dictMapper.getDict(dict);
			// 是否存在修改用户积分、经验等奖励
			UserMoney userMoney = new UserMoney();
			if (dict != null && dict.getMapInfo() != null) {
				// 积分奖励
				int score = FormatUtil.StringToInt(dict.getMapInfo().get(
						"score"));
				int exp = FormatUtil.StringToInt(dict.getMapInfo().get("exp"));
				String reason = dict.getMapInfo().get("reason");

				userMoney.setScore(score);
				userMoney.setExp(exp);
				userMoney.setScorereason(reason);
				userMoney.setGetnow(checkOrder.getTowerendfee());
				userMoney.setUserid(checkOrder.getUserid());
				userMoney.setGetnowtype(0);

			} else {
				// 无积分奖励
				userMoney.setGetnow(checkOrder.getTowerendfee());
				userMoney.setUserid(checkOrder.getUserid());
				userMoney.setGetnowtype(0);
			}
			count = userService.updateUserMoney(userMoney, sysUser);
			if (count == 0)
				throw new RuntimeException();
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

}
