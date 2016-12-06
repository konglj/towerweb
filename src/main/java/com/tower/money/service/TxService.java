package com.tower.money.service;

import java.util.List;
import java.util.Map;

import com.tower.money.bean.TxPage;
import com.tower.money.bean.TxRecord;
import com.tower.money.bean.TxSource;
import com.tower.money.bean.TxState;
import com.tower.system.bean.SysUser;

public interface TxService {

public List<TxRecord> getTxs(TxPage txPage);
	
	/**
	 * 获取体现记录
	 * @param txPage
	 * @return
	 */
	public TxRecord getTx(TxPage txPage);
	
	/**
	 * 获取体现明细
	 * @param txPage
	 * @return
	 */
	public List<TxSource>  getTxSources(TxPage txPage);
	
	/**
	 * 获取体现状态列表
	 * @param province
	 * @return
	 */
	public List<TxState> gettxStates(Map<String,Integer> map);

	/**
	 * 体现审核
	 * @param map
	 * @return
	 */
	public int shTxApply(TxRecord txRecord, SysUser sysUser);
	
	/**
	 * 打款审核
	 * @param map
	 * @return
	 */
	public int shTxDk(TxRecord txRecord, SysUser sysUser);

	public int plShTx(Map map);
	
	/**
	 * 大打款审核
	 * @param map
	 * @return
	 */
	public  int dkTx(Map map);
	
	public List<Map> getDcTxs(TxPage txPage);
	
	public List<Map> getDcTxApplys(TxPage txPage);
	
	public int dkTx(List<Map> list,int adminid);
	
	public List<TxRecord> getAutoTxs();

	public int updateAutoTx(TxRecord txRecord);
	
}
