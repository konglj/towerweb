package com.tower.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Repeat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tower.common.bean.Score;
import com.tower.common.mapper.ScoreMapper;
import com.tower.money.bean.TxSource;
import com.tower.money.mapper.TxMapper;
import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserInfo;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserManagePage;
import com.tower.user.bean.UserMoney;
import com.tower.user.bean.UserType;
import com.tower.user.mapper.UserMapper;
import com.tower.user.service.UserService;
import com.tower.user.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ScoreMapper scoreMapper;

	@Autowired
	private TxMapper txMapper;

	@Override
	public List<UserInfo> getUserInfos(UserManagePage usermanagepage) {
		int count = userMapper.getUserInfosCount(usermanagepage);
		List<UserInfo> userInfos = userMapper.getUserInfos(usermanagepage);
		usermanagepage.setUserInfos(userInfos);
		usermanagepage.setPagerowtotal(count);
		return userInfos;
	}

	@Override
	public List<UserMoney> getUserMoneys(UserManagePage usermanagepage) {
		int count = userMapper.getUserMoneysCount(usermanagepage);
		List<UserMoney> userMoneys = userMapper.getUserMoneys(usermanagepage);
		usermanagepage.setUserMoneys(userMoneys);
		usermanagepage.setPagerowtotal(count);
		return userMoneys;
	}

	@Override
	public UserInfo getUserDetail(int userid) {

		return userMapper.getUserDetail(userid);
	}

	@Override
	public int updateuserstate(Map<String, Object> map) {

		return userMapper.updateuserstate(map);
	}

	@Override
	public int updateusertype(Map<String, Object> map) {

		return userMapper.updateusertype(map);
	}

	@Override
	public int updateUserBz(Map<String, Object> map) {
		return userMapper.updateUserBz(map);
	}

	@Override
	public int updateUserLevle(Map<String, Object> map) {

		return userMapper.updateUserLevel(map);
	}

	@Override
	public List<UserType> getUserTypes() {

		return userMapper.getUserTypes();
	}

	@Override
	public List<UserLevel> getUserLevels(int province) {

		return userMapper.getUserLevels(province);
	}

	@Override
	public UserInfo getUpdateUserInfo(int userid) {
		return userMapper.getUpdateUserInfo(userid);
	}

	@Override
	@Transactional
	public int updateUserMoney(UserMoney userMoney, SysUser sysUser) {
		int count = 0;
		int userid = userMoney.getUserid();
		int sc = userMoney.getScore();
		int exp = userMoney.getExp();
		UserMoney userMoneyold = userMapper.getUserMoney(userid);
		count = userMapper.updateUserMoney(userMoney);
		if (count == 0)
			throw new RuntimeException("修改用户钱包失败");
		

		if (userMoney.getScore() != 0 || userMoney.getExp() != 0) {
			// 判断用户积分
			// 插入积分来源表

			if (userMoney.getScore() != 0) {

				Score score = new Score();
				score.setUserid(userid);
				score.setScorecount(userMoney.getScore());
				score.setScorereason(userMoney.getScorereason());
				count = scoreMapper.insertScore(score);
				if (count == 0)
					throw new RuntimeException("插入记录记录失败");
			}
			// 判断积分级别
		
			sc = userMoneyold.getScore() + sc;
			exp = userMoney.getExp() + exp;

			List<UserLevel> userLevels = userMapper.getUserLevels(sysUser
					.getProvince());
			int level = UserUtil.getUserLevel(sc, exp, userLevels);
			Integer userlevel = userMapper.getUserLevel(userid);
			if (userlevel != null) {
				if (level != userlevel) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("userid", userid);
					map.put("userlevel", level);
					count = userMapper.updateUserLevel(map);
					if (count == 0)
						throw new RuntimeException("修改用户级别失败");
				}
			}

		}

		if (userMoney.getGetnow() != 0) {

			// 插入提现来源吧
			TxSource txSource = new TxSource();
			txSource.setOrderid(userMoney.getOrderid());
			txSource.setUserid(userid);
			txSource.setFee(userMoney.getGetnow());
			txSource.setFeetype(userMoney.getGetnowtype());
			count = txMapper.insertTxSource(txSource);
			if (count == 0)
				throw new RuntimeException();
		}
		return 1;
	}

}
