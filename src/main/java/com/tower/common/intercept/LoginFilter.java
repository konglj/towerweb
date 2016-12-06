package com.tower.common.intercept;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;


public class LoginFilter extends HandlerInterceptorAdapter {

	private String[] errorPages = { "/404.html", "/500.html" };
	private String [] nologinpages={"/login.html","/go_login.html"};
	private boolean checkUrl(String url, String[] strrr) {
		for (int i = 0; i < strrr.length; i++) {
			if (url.contains(strrr[i]))
				return true;
		}
		return false;
	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getServletPath();
		String contextPath = request.getContextPath();
		if (url.equals("")) {
			url += "/";
		}
		

		System.out.println(url);

		if (checkUrl(url, errorPages)||checkUrl(url, nologinpages))
			return true;
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		if(sysUser==null||sysUser.getId()==0){
			try {
				response.sendRedirect(contextPath + "/login.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		return true;
	}
}
