package com.tower.system.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tower.common.util.ResultUtil;

@Controller
@RequestMapping("/auth")
public class AuthWeb {
	
	@RequestMapping("/check_auth")
	@ResponseBody 
	public Object checkAuth(HttpServletRequest request,String authcode){
		return ResultUtil.responseSuccessMsg("ok");
	} 

	@RequestMapping("/check_auth_order")
	@ResponseBody 
	public Object checkAuthOrder(HttpServletRequest request,int towerstate){
		return ResultUtil.responseSuccessMsg("ok");
	} 

}
