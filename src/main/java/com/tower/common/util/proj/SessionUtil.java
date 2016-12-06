package com.tower.common.util.proj;

import javax.servlet.http.HttpServletRequest;

import com.tower.system.bean.SysUser;

public class SessionUtil {

	private static final String user_session_name = "systemuser_session";

	public static SysUser getUserFromSession(HttpServletRequest request) {
		SysUser sysuser = (SysUser) request.getSession().getAttribute(
				user_session_name);
		if(sysuser==null||sysuser.getId()==0)
			return null;
		return sysuser;
	}

	public static void setUserFromSession(HttpServletRequest request,
			SysUser sysuser) {
		request.getSession().setAttribute(user_session_name, sysuser);
	}
}
