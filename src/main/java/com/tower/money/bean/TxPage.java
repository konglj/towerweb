package com.tower.money.bean;


import java.util.ArrayList;
import java.util.List;

import com.tower.common.bean.BasePage;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserType;

public class TxPage extends  BasePage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int txid;
	
	private int page;//0 付款申请 1 打款
	
	private int apply=-1;
	
	private List<TxRecord> txRecords=new ArrayList<TxRecord>();
	
	private List<TxSource> txSources=new ArrayList<TxSource>();
	
	private TxRecord txRecord=new TxRecord();
	
	private TxSource txSource=new TxSource();
	
	private TxParameter parameter=new TxParameter();

	private List<UserLevel> userLevels=new ArrayList<UserLevel>();
	
	private List<UserType> userTypes=new ArrayList<UserType>();
	
	private List<TxState> txStates=new ArrayList<TxState>();
	
	
	

	public int getTxid() {
		return txid;
	}

	public void setTxid(int txid) {
		this.txid = txid;
	}

	public List<TxRecord> getTxRecords() {
		return txRecords;
	}

	public void setTxRecords(List<TxRecord> txRecords) {
		this.txRecords = txRecords;
	}

	public List<TxSource> getTxSources() {
		return txSources;
	}

	public void setTxSources(List<TxSource> txSources) {
		this.txSources = txSources;
	}

	public TxRecord getTxRecord() {
		return txRecord;
	}

	public void setTxRecord(TxRecord txRecord) {
		this.txRecord = txRecord;
	}

	public TxSource getTxSource() {
		return txSource;
	}

	public void setTxSource(TxSource txSource) {
		this.txSource = txSource;
	}

	public TxParameter getParameter() {
		return parameter;
	}

	public void setParameter(TxParameter parameter) {
		this.parameter = parameter;
	}

	public List<UserLevel> getUserLevels() {
		return userLevels;
	}

	public void setUserLevels(List<UserLevel> userLevels) {
		this.userLevels = userLevels;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	public List<TxState> getTxStates() {
		return txStates;
	}

	public void setTxStates(List<TxState> txStates) {
		this.txStates = txStates;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getApply() {
		return apply;
	}

	public void setApply(int apply) {
		this.apply = apply;
	}
	
	
	
	
	
	
	
	
	
}
