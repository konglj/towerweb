package com.tower.index.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.util.ResultUtil;
import com.tower.common.util.StrUtil;
import com.tower.common.util.proj.EnumUtil;
import com.tower.common.util.proj.MsgInfo;
import com.tower.common.util.proj.SessionUtil;
import com.tower.common.web.BaseWeb;
import com.tower.index.service.LoginService;
import com.tower.system.bean.SysUser;
import com.tower.system.service.SysService;

@Controller
@RequestMapping("/")
public class LoginWeb extends BaseWeb {

	@Autowired
	private LoginService loginService;

	@Autowired
	private SysService sysService;

	/**
	 * 获取登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView("/index/login");
	}

	/**
	 * 登录操作
	 * 
	 * @return
	 */
	@RequestMapping("/go_login")
	@ResponseBody
	public Object goLogin(HttpServletRequest request,String username, String password) {
		if (StrUtil.isNullOrEmpty(username) || StrUtil.isNullOrEmpty(password)) {
			return ResultUtil.responseErrorMsg(MsgInfo.msg_user_empty);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		SysUser sysuser = null;
		try {
			sysuser = loginService.login(map);
		} catch (Exception e) {
			System.out.println("login==>>" + e.getMessage());
			return ResultUtil.responseErrorMsg(MsgInfo.msg_login_error);
		}
		if (sysuser == null || sysuser.getId() == 0)
			return ResultUtil.responseErrorMsg(MsgInfo.msg_user_error);
		if (sysuser.getState() == EnumUtil.AdminState.FROZEN.ordinal())
			return ResultUtil.responseErrorMsg(MsgInfo.msg_user_dj);
		SessionUtil.setUserFromSession(request, sysuser);

		return ResultUtil.responseSuccessMsg(MsgInfo.msg_login_success);
	}

}
