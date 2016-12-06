package com.tower.money.mapper;

import java.util.List;
import java.util.Map;

import com.tower.money.bean.TxDoinfo;
import com.tower.money.bean.TxPage;
import com.tower.money.bean.TxRecord;
import com.tower.money.bean.TxSource;
import com.tower.money.bean.TxState;


public interface TxMapper {
	
	public List<TxRecord> getTxs(TxPage txpage);
	
	public int getTxsCount(TxPage txpage);
	
	public TxRecord getTx(int id);
	
	public TxRecord getCheckTx(int id);
	
	public List<TxState> gettxStates(Map<String,Integer> map);
	
	
	public List<TxSource> getTxSources(TxPage txPage);
	
	
	public List<TxDoinfo> getTxDoinfos(int txid);
	
	
	
	public int addTxdoinfo(TxDoinfo txdoinfo);
	
	
	
	public int updateRecordState(TxRecord txRecord);
	
	public int updateDkRecordState(TxRecord txRecord);
	
	
	
	public int shnocharge(Map<String,Object> map);
	
	public int shnotxsource(Map<String,Object> map);
	
	public int dkyescharge(Map<String,Object> map);
	
	
	public List<Map<String,Object>> getDcTxs(TxPage txPage);
	
	public List<Map<String,Object>> getDcTxApplys(TxPage txPage);
	
	public TxRecord getTxRecord(String txid);
	public int plShTx(Map<String,Object> map);
	
	public TxRecord getTxRecordById(int id);
	
	public List<TxRecord> getAutoTxs();
	
	public int updateAutoTx(int id);
	
	public int insertTxSource(TxSource txSource);
	
	public int shTxApply(TxRecord txRecord);
	

}
