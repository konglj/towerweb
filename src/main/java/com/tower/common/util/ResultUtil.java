package com.tower.common.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {

	
	public static Map<String,Object> responseMsg(Boolean result, Object msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("data", msg);
		return map;
	}
	
	public static Map<String,Object> responseSuccessMsg(Object msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		map.put("data", msg);
		return map;
	}
	
	public static Map<String,Object> responseErrorMsg(Object msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		map.put("data", msg);
		return map;
	}
	
	public static Map<String,Object> gresponseMsg(Boolean result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", result);
		return map;
	}
}
