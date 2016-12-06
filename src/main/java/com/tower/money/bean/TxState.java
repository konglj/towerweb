package com.tower.money.bean;

public class TxState {
	
	private int txstate;
	
	private String statename;
	
	private int province;
	
	private int success;
	
	private int error;

	public int getTxstate() {
		return txstate;
	}

	public void setTxstate(int txstate) {
		this.txstate = txstate;
	}

	
	
	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
	
	

}
