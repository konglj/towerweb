package com.tower.system.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.MsgInfo;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.Menu;
import com.tower.system.bean.SysUser;
import com.tower.system.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuWeb {

	@Autowired
	private MenuService menuService;

	/**
	 * 获取所有的菜单
	 * @param request
	 * @return
	 */
	@RequestMapping("/menus")
	@ResponseBody
	public Object getMenus(HttpServletRequest request) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		if (sysUser == null)
			return ResultUtil.responseErrorMsg(MsgInfo.msg_get_menus_error);
		List<Menu> menus = menuService.getMenus(sysUser.getProvince());
		return ResultUtil.responseSuccessMsg(menus);
	}
}
