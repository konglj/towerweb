package com.tower.common.util;

public class FormatUtil {

	
	public static int StringToInt(String str){
		return str==null||str.equals("")?0:Integer.valueOf(str);
	}
}
