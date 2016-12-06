package com.tower.order.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.tower.common.Config;
import com.tower.common.bean.Dict;
import com.tower.common.mapper.DictMapper;
import com.tower.common.util.FormatUtil;
import com.tower.common.util.MoneyUtil;
import com.tower.common.util.StrUtil;
import com.tower.common.util.TemplateDocUtil;
import com.tower.common.util.TimeUtil;
import com.tower.common.util.proj.DictUtil;
import com.tower.money.bean.TxSource;
import com.tower.money.mapper.TxMapper;
import com.tower.order.bean.Order;
import com.tower.order.bean.OrderInfo;
import com.tower.order.bean.OrderShInfo;
import com.tower.order.bean.OrderUserInfo;
import com.tower.order.mapper.OrderMapper;
import com.tower.order.mapper.OrderMapper31;
import com.tower.order.mapper.OrderShInfoMapper;
import com.tower.order.service.OrderService31;
import com.tower.order.util.OrderUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.TowerReport;
import com.tower.tower.mapper.TowerMapper;
import com.tower.tower.mapper.TowerReportMapper;
import com.tower.user.bean.UserMoney;
import com.tower.user.mapper.UserMapper;
import com.tower.user.service.UserService;

@Service
public class OrderServiceImpl31 implements OrderService31 {

	@Autowired
	private OrderMapper31 orderMapper31;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderShInfoMapper shInfoMapper;

	@Autowired
	private TowerMapper towerMapper;
	@Autowired
	private TowerReportMapper towerReportMapper;

	@Autowired
	private DictMapper dictMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private TxMapper txMapper;

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderByRentHt(OrderInfo orderInfo, SysUser sysUser) {
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		orderInfo.setTowerstate(updateState);
		count = orderMapper31.updateOrderByRentHt(orderInfo);
		if (count == 0) {
			throw new RuntimeException("修改订单状态失败");
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
	public synchronized  int updateOrderByThreeHt(String rootPath, String templatePath,
			OrderInfo orderInfo, SysUser sysUser) {
		orderInfo.setShresult(1);
		// 获取订单基本信息
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		String filePath = File.separator + Config.root_path + File.separator
				+ sysUser.getProvince();
		String filename = UUID.randomUUID().toString().replace("-", "")
				+ ".doc";
		filePath += File.separator + filename;
		String threePath = new File(rootPath).getParent() + filePath;

		orderInfo.setTowerstate(updateState);
		// 生成三方合同
		// 金额格式化
		String money = MoneyUtil.digitUppercase(orderInfo.getTowerfactfee())
				+ "(" + orderInfo.getTowerfactfee() + ")";
		// 生成三方合同文件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("towername", checkOrder.getTowername());
		map.put("towerfactaddress", checkOrder.getTowerfactaddress());
		map.put("towerfactfee", money);
		map.put("towertime", TimeUtil.getNowDay());
		if (!TemplateDocUtil.toPreview(templatePath, threePath,
				Config.three_ht_name, map)) {
			throw new RuntimeException();
		}
		orderInfo.setTowerthreeht(filePath);

		count = orderMapper31.updateOrderByThreeHt(orderInfo);
		if (count == 0) {
			throw new RuntimeException("修改订单状态失败");
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
	 * 三方合同审核
	 */

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderByThreeSh(OrderInfo orderInfo,
			SysUser sysUser) {
		// 根据订单获取订单状态
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
		if (checkOrder.getTowerrelease() == 1) {
			map.put("towerabandontime", TimeUtil.getNow());
		}
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException();

		if (orderInfo.getShresult() == 1) {
			// 3 修改用户抢单记录
			OrderUserInfo orderUserInfo = new OrderUserInfo();
			orderUserInfo.setUserid(checkOrder.getUserid());
			orderUserInfo.setSucccount(1);
			orderUserInfo.setIngcount(-1);
			orderUserInfo.setConcancelcount(0 - checkOrder
					.getUserconcancelcount());
			count = orderMapper.updateUserOrderInfo(orderUserInfo);
			if (count == 0)
				throw new RuntimeException("用户订单统计失败！");
			// 插入插入操作日志表

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
	 * 提交付款审核 即为提交单项服务协议
	 */

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public synchronized int updateOrderByFreeApply(OrderInfo orderInfo,
			SysUser sysUser) {
		// 根据订单获取订单状态
		// 获取订单基本信息
		orderInfo.setShresult(1);
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		orderInfo.setTowerstate(updateState);
		// 修改订单状态
		count = orderMapper31.updateOrderByFeeApply(orderInfo);
		if (count == 0)
			throw new RuntimeException();

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
	public synchronized int updateOrderByFreeSh(OrderInfo orderInfo, SysUser sysUser) {
		// 根据订单获取订单状态
		OrderInfo checkOrder = orderMapper.getOrderCheckInfo(orderInfo.getId());
		int count = 0;
		int updateState = 0;
		if ((updateState = OrderUtil.getOrderUpdateState(checkOrder, orderInfo)) < 1) {
			return updateState;
		}
		// 1 修改订单状态
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderid", checkOrder.getId());
		map.put("towerstate", updateState);
		if (checkOrder.getTowerrelease() == 1) {
			map.put("towerabandontime", TimeUtil.getNow());
		}
		count = orderMapper.updateOrderState(map);
		if (count == 0)
			throw new RuntimeException("修改订单状态失败");
		//

		// 2 处理审核记录
		OrderShInfo orderShInfo = OrderUtil.getOrderShInfo(checkOrder.getId(),
				orderInfo.getShinfo(), updateState, sysUser);
		count = shInfoMapper.insertTowerShInfo(orderShInfo);
		if (count == 0)
			throw new RuntimeException("插入操作日志失败！");
		if (orderInfo.getShresult() == 0)
			// 审核拒绝不用给积分等信息
			return 1;

		Dict dict = new Dict(DictUtil.order_fee_rewards, sysUser.getProvince());
		dict = dictMapper.getDict(dict);
		// 是否存在修改用户积分、经验等奖励
		UserMoney userMoney = new UserMoney();
		if (dict != null && dict.getMapInfo() != null) {
			// 积分奖励
			int score = FormatUtil.StringToInt(dict.getMapInfo().get("score"));
			int exp = FormatUtil.StringToInt(dict.getMapInfo().get("exp"));
			String reason = dict.getMapInfo().get("reason");

			userMoney.setScore(score);
			userMoney.setExp(exp);
			userMoney.setScorereason(reason);
			userMoney.setGetnow(checkOrder.getTowerfactfee());
			userMoney.setUserid(checkOrder.getUserid());
			userMoney.setCharge(checkOrder.getTowerfactfee());
			userMoney.setGetnowtype(0);

		} else {
			// 无积分奖励
			userMoney.setGetnow(checkOrder.getTowerfactfee());
			userMoney.setCharge(checkOrder.getTowerfactfee());
			userMoney.setUserid(checkOrder.getUserid());
			userMoney.setGetnowtype(0);
		}
		userMoney.setOrderid(checkOrder.getId());
		count = userService.updateUserMoney(userMoney, sysUser);
		if (count == 0)
			throw new RuntimeException();

		// tower_sh_doinfo
		TowerReport report = new TowerReport();
		report.setTowerid(checkOrder.getTowerid());
		report.setConrejectcount(0 - checkOrder.getTowerconrejectcount());
		count = updateTowerReport(report);
		if (count == 0)
			throw new RuntimeException("站址统计失败！");
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
