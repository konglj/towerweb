package com.tower.index.web;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.system.bean.SysUser;
import com.tower.system.service.SysService;

@Controller
@RequestMapping("/")
public class IndexWeb {

	
	@Autowired
	private SysService sysService;
	
	@RequestMapping("/index")
	public ModelAndView indexPage(HttpServletRequest request) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		return new ModelAndView("/index/index","sysUser",sysUser);
	}

	@RequestMapping("/index_content")
	public ModelAndView indexContentPage() {
		// 获取
		return new ModelAndView("/index/index_content");
	}

	@RequestMapping("/check_old_password")
	@ResponseBody
	public Object checkOldPwd(HttpServletRequest request, String password) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		if (sysUser.getPassword().equals(password)) {
			return ResultUtil.responseSuccessMsg("1");
		}
		return ResultUtil.responseErrorMsg("0");
	}

	@RequestMapping("/updatePass")
	@ResponseBody
	public Object updatePass(HttpServletRequest request, String password) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", sysUser.getId());
		map.put("password", password);
		int count=0;
		try {
			count=sysService.updatePwd(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count>0) {
			sysUser.setPassword(password);
			SessionUtil.setUserFromSession(request, sysUser);
			return ResultUtil.responseSuccessMsg("1");
		}
		return ResultUtil.responseErrorMsg("0");
	}
	
	@RequestMapping("/loginout")
	@ResponseBody
	public Object loginOut(HttpServletRequest request){
		SessionUtil.setUserFromSession(request, null);
		return ResultUtil.responseSuccessMsg("1");
	}
	@RequestMapping("/updateSysUser")
	@ResponseBody
	public Object updateSysUser(HttpServletRequest request,String adminname,String adminphone){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("adminname", adminname);
		map.put("adminphone", adminphone);
		map.put("userid", sysUser.getId());
		int count=0;
		try {
			count=sysService.updateSysUserInfo(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count>0) {
			sysUser.setName(adminname);
			sysUser.setPhone(adminphone);
			SessionUtil.setUserFromSession(request, sysUser);
			return ResultUtil.responseSuccessMsg("1");
		}
		return ResultUtil.responseErrorMsg("0");
	}
}
