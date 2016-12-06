package com.tower.money.util;

import com.tower.money.bean.TxRecord;

public class MoneyUtil {

	
	public static int getUpdateState(TxRecord check_txRecord,TxRecord txRecord){
		
		if (check_txRecord == null) {
			return -1;
		}
		if (check_txRecord.getState() != txRecord.getState()) {
			return -2;
		}
		int updatestate=0;
		if(txRecord.getShresult()==1){
			updatestate=check_txRecord.getSuccessstate();
		}else if(txRecord.getShresult()==0){
			updatestate=check_txRecord.getErrorstate();
		}
		return updatestate;
	}
	
}
