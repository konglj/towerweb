package com.tower.money.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tower.money.bean.TxDoinfo;
import com.tower.money.bean.TxPage;
import com.tower.money.bean.TxRecord;
import com.tower.money.bean.TxSource;
import com.tower.money.bean.TxState;
import com.tower.money.mapper.TxMapper;
import com.tower.money.service.TxService;
import com.tower.money.util.MoneyUtil;
import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserMoney;
import com.tower.user.mapper.UserMapper;

@Service
public class TxServiceImpl implements TxService {

	@Autowired
	private TxMapper txMapper;

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<TxRecord> getTxs(TxPage txpage) {
		int count = txMapper.getTxsCount(txpage);
		List<TxRecord> txRecords = txMapper.getTxs(txpage);
		txpage.setPagerowtotal(count);
		;
		txpage.setTxRecords(txRecords);
		return txRecords;
	}

	@Override
	public TxRecord getTx(TxPage txPage) {
		int id = txPage.getTxid();
		TxRecord txRecord = txMapper.getTx(id);
		if (txRecord == null)
			return new TxRecord();
		List<TxSource> txSources = getTxSources(txPage);
		List<TxDoinfo> txDoinfos = txMapper.getTxDoinfos(id);
		txRecord.setTxdoinfos(txDoinfos);
		txRecord.setTxsources(txSources);
		return txRecord;
	}

	@Override
	public List<TxSource> getTxSources(TxPage txPage) {
		List<TxSource> txSources = txMapper.getTxSources(txPage);
		// txPage.setTxSources(txSources);
		return txSources;
	}

	@Override
	public List<TxState> gettxStates(Map<String, Integer> map) {
		return txMapper.gettxStates(map);
	}

	private int insertTxDoInfo(TxRecord txRecord, SysUser sysUser) {
		// 修改审核日志

		TxDoinfo txdoinfo = new TxDoinfo();
		txdoinfo.setTxid(txRecord.getId());
		txdoinfo.setDouserid(sysUser.getName());
		txdoinfo.setDousername(sysUser.getName());
		txdoinfo.setDousertele(sysUser.getPhone());
		txdoinfo.setUsertype(1);
		txdoinfo.setNowstate(txRecord.getState());
		txdoinfo.setShinfo(txRecord.getShinfo());

		int count = txMapper.addTxdoinfo(txdoinfo);
		return count;

	}

	@Override
	@Transactional
	public int shTxApply(TxRecord txRecord, SysUser sysUser) {
		// 验证
		TxRecord check_txRecord = txMapper.getCheckTx(txRecord.getId());
		int upateState = 0;
		if ((upateState = MoneyUtil.getUpdateState(check_txRecord, txRecord)) <= 0)
			return upateState;

		txRecord.setState(upateState);
		int count = 0;
		count = txMapper.updateRecordState(txRecord);
		if (count == 0)
			throw new RuntimeException("修改申请状态失败！");

		// 插入日志
		count = insertTxDoInfo(txRecord, sysUser);
		if (count == 0)
			throw new RuntimeException("修改申请状态失败！");

		return 1;
	}

	@Override
	@Transactional
	public int shTxDk(TxRecord txRecord, SysUser sysUser) {
		// 验证
		TxRecord check_txRecord = txMapper.getCheckTx(txRecord.getId());
		int upateState = 0;
		if (txRecord.getShinfo() != null
				&& txRecord.getShinfo().equals("AB000000")) {
			// 银行单号为"AB000000"的记录置为打款失败
			txRecord.setShresult(0);
		}
		if ((upateState = MoneyUtil.getUpdateState(check_txRecord, txRecord)) <= 0)
			return upateState;
		// 修改打款状态
		txRecord.setState(upateState);
		int count = 0;
		if(txRecord.getShresult()==1){
			txRecord.setBankbackid(txRecord.getShinfo());
		}
		count = txMapper.updateDkRecordState(txRecord);

		if (count == 0)
			throw new RuntimeException("修改申请状态失败！");

		// 插入日志
		count = insertTxDoInfo(txRecord, sysUser);
		if (count == 0)
			throw new RuntimeException("修改申请状态失败！");

		Map<String, Object> map = new HashMap<String, Object>();
		// 审核失败
		if (txRecord.getShresult() == 0) {

			// txsourse 的txid清空
			map.put("txid", txRecord.getId());
			count = txMapper.shnotxsource(map);
			// 修改用户金额 体现中-fee 总金额+fee
			UserMoney userMoney = new UserMoney();
			userMoney.setGetnow(check_txRecord.getFee());
			userMoney.setGettingnow(-check_txRecord.getFee());
			userMoney.setCharge(check_txRecord.getFee());
			userMoney.setUserid(check_txRecord.getUserid());
			count = userMapper.updateUserMoney(userMoney);
			if (count == 0)
				throw new RuntimeException("修改用户金额失败！");

		} else { // 审核成功
			// 打款成功情况
			// 修改用户费用
			UserMoney userMoney = new UserMoney();
			userMoney.setGettingnow(-check_txRecord.getFee());
			userMoney.setAllgeting(check_txRecord.getFee());
			userMoney.setUserid(check_txRecord.getUserid());
			count = userMapper.updateUserMoney(userMoney);
			if (count == 0)
				throw new RuntimeException("修改用户金额失败！");

		}

		return 1;
	}

	@Override
	public int plShTx(Map map) {
		return 0;
	}

	@Override
	public int dkTx(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map> getDcTxs(TxPage txPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> getDcTxApplys(TxPage txPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dkTx(List<Map> list, int adminid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TxRecord> getAutoTxs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAutoTx(TxRecord txRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
