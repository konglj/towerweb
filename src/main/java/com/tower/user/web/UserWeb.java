package com.tower.user.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.bean.DataTable;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.common.web.BaseWeb;
import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserInfo;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserManagePage;
import com.tower.user.bean.UserType;
import com.tower.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserWeb extends BaseWeb{
	@Autowired
	private UserService userService;
	
	private UserManagePage m_userManagePage;
	
	@RequestMapping("/users")
	public ModelAndView getUserPage(HttpServletRequest request,UserManagePage userManagePage){
		
		int isback = userManagePage.getBack();
		userManagePage.setBack(0);
		if (isback == 1) {
			userManagePage = m_userManagePage;
		} else {
			this.m_userManagePage = userManagePage;
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		AreaUtil.getUserAreaParamer(userManagePage, sysUser, true);
		List<UserType> userTypes=userService.getUserTypes();
		List<UserLevel> userLevels=userService.getUserLevels(province);
		userManagePage.setUserLevels(userLevels);
		userManagePage.setUserTypes(userTypes);
		return new ModelAndView("/user/"+province+"/users","userManagePage",userManagePage);
	}
	
	@RequestMapping("/get_users")
	@ResponseBody
	public Object getUsers(HttpServletRequest request,UserManagePage userManagePage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		userManagePage.setSysUser(sysUser);
		userService.getUserInfos(userManagePage);

		DataTable table = new DataTable(userManagePage.sEcho,
				userManagePage.getPagerowtotal(), userManagePage.getPagerowtotal(),
				userManagePage.getUserInfos());

		return ResultUtil.responseSuccessMsg(table);
	}

	
	@RequestMapping("/moneys")
	public ModelAndView getMoneyPage(HttpServletRequest request,UserManagePage userManagePage){
		
		int isback = userManagePage.getBack();
		userManagePage.setBack(0);
		if (isback == 1) {
			userManagePage = m_userManagePage;
		} else {
			this.m_userManagePage = userManagePage;
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		AreaUtil.getUserAreaParamer(userManagePage, sysUser, true);
		List<UserType> userTypes=userService.getUserTypes();
		List<UserLevel> userLevels=userService.getUserLevels(province);
		userManagePage.setUserLevels(userLevels);
		userManagePage.setUserTypes(userTypes);
		return new ModelAndView("/user/"+province+"/moneys","userManagePage",userManagePage);
	}
	
	@RequestMapping("/get_moneys")
	@ResponseBody
	public Object getMoneys(HttpServletRequest request,UserManagePage userManagePage){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		userManagePage.setSysUser(sysUser);
		userService.getUserMoneys(userManagePage);

		DataTable table = new DataTable(userManagePage.sEcho,
				userManagePage.getPagerowtotal(), userManagePage.getPagerowtotal(),
				userManagePage.getUserMoneys());

		return ResultUtil.responseSuccessMsg(table);
	}

	@RequestMapping("/get_userinfo")
	public ModelAndView getUserInfo(HttpServletRequest request,int userid){
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		UserInfo userInfo=userService.getUserDetail(userid);
		String url="/user/"+sysUser.getProvince()+"/user_info";
		return new ModelAndView(url,"userinfo",userInfo);
	}
	

	@RequestMapping("/update_user_state")
	@ResponseBody
	public Object updateUserState(Integer userid ,Integer state){
		if(userid==null||userid==0||state==null){
			return ResultUtil.responseErrorMsg(0);
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("state",state);
		int count=0;
		try {
			count=userService.updateuserstate(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count==0){
			return ResultUtil.responseErrorMsg(0);
		}
		return ResultUtil.responseSuccessMsg(1);
	}
	
	
	
	@RequestMapping("/update_user_verify_state")
	@ResponseBody
	public Object updateUserVerifyState(Integer userid ,Integer state){
		if(userid==null||userid==0||state==null){
			return ResultUtil.responseErrorMsg(0);
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("verifystate",state);
		int count=0;
		try {
			count=userService.updateuserstate(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count==0){
			return ResultUtil.responseErrorMsg(0);
		}
		return ResultUtil.responseSuccessMsg(1);
	}
	
	public UserManagePage getM_userManagePage() {
		return m_userManagePage;
	}

	public void setM_userManagePage(UserManagePage m_userManagePage) {
		this.m_userManagePage = m_userManagePage;
	}

	
	@RequestMapping("/get_user_bz")
	@ResponseBody
	public Object getUserBz(Integer userid){
		if(userid==null|| userid==0)
			return ResultUtil.responseErrorMsg(0);
		UserInfo userinfo=userService.getUpdateUserInfo(userid);
		if(userinfo==null)
			return ResultUtil.responseErrorMsg(0);
		return ResultUtil.responseSuccessMsg(userinfo.getUserbz());
	}
	
	@RequestMapping("/update_user_bz")
	@ResponseBody
	public Object updateUserBz(Integer userid,String userbz){
		if(userid==null|| userid==0)
			return ResultUtil.responseErrorMsg(0);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("userbz",userbz);
		int count=0;
		try {
			count=userService.updateUserBz(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count==0){
			return ResultUtil.responseErrorMsg(0);
		}
		return ResultUtil.responseSuccessMsg(1);
	}
	
	@RequestMapping("/get_user_type")
	@ResponseBody
	public Object getUserType(Integer userid){
		if(userid==null|| userid==0)
			return ResultUtil.responseErrorMsg(0);
		UserInfo userinfo=userService.getUpdateUserInfo(userid);
		if(userinfo==null)
			return ResultUtil.responseErrorMsg(0);
		List<UserType> types=new ArrayList<UserType>();
		types=userService.getUserTypes();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("usertype", userinfo.getUsertype());
		map.put("types",types);
		return ResultUtil.responseSuccessMsg(map);
	}
	
	@RequestMapping("/update_user_type")
	@ResponseBody
	public Object updateUserType(Integer userid,String usertype){
		if(userid==null|| userid==0)
			return ResultUtil.responseErrorMsg(0);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("usertype",usertype);
		int count=0;
		try {
			count=userService.updateusertype(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count==0){
			return ResultUtil.responseErrorMsg(0);
		}
		return ResultUtil.responseSuccessMsg(1);
	}
	
	
	
	
	
	
	
	
	
	
	
}
