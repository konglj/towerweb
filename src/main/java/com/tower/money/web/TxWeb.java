package com.tower.money.web;

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
import com.tower.money.bean.TxPage;
import com.tower.money.bean.TxParameter;
import com.tower.money.bean.TxRecord;
import com.tower.money.bean.TxState;
import com.tower.money.mapper.TxMapper;
import com.tower.money.service.TxService;
import com.tower.system.bean.SysUser;
import com.tower.user.bean.UserLevel;
import com.tower.user.bean.UserType;
import com.tower.user.service.UserService;

@Controller
@RequestMapping("/money")
public class TxWeb {
	
	@Autowired
	private TxService txService;
	
	@Autowired
	private UserService userService;
	
	private TxPage m_txPage;
	
	@RequestMapping("/tx_applys")
	public ModelAndView getTxApplyPage(HttpServletRequest request,TxPage txPage){
		
		if(txPage.getBack()==1){
			txPage=m_txPage;
		}else{
			m_txPage=txPage;
		}
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		
		List<UserType> userTypes=userService.getUserTypes();
		List<UserLevel> userLevels=userService.getUserLevels(province);
		txPage.setUserLevels(userLevels);
		txPage.setUserTypes(userTypes);
		
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("province", province);
		map.put("apply", 1);
		List<TxState> txStates=txService.gettxStates(map);
		txPage.setTxStates(txStates);
		txPage.getParameter().setState(0);
		AreaUtil.getUserAreaParamer(txPage, sysUser, true);
		return new ModelAndView("/money/"+province+"/applys","txPage",txPage);
	}
	
	
	@RequestMapping("/get_txs")
	@ResponseBody
	public Object getTxApplys(HttpServletRequest request,TxPage txPage){
		SysUser sysuser=SessionUtil.getUserFromSession(request);
		txPage.setSysUser(sysuser);
		txService.getTxs(txPage);
		DataTable table = new DataTable(txPage.sEcho,
				txPage.getPagerowtotal(), txPage.getPagerowtotal(),
				txPage.getTxRecords());
		return ResultUtil.responseSuccessMsg(table);
	}
	
	
	
	
	@RequestMapping("/tx_dks")
	public ModelAndView getTxDkPage(HttpServletRequest request,TxPage txPage){
		
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		if(txPage.getBack()==1){
			txPage=m_txPage;
		}else{
			m_txPage=txPage;
		}
		List<UserType> userTypes=userService.getUserTypes();
		List<UserLevel> userLevels=userService.getUserLevels(province);
		txPage.setUserLevels(userLevels);
		txPage.setUserTypes(userTypes);
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("province", province);
		map.put("apply", 0);
		List<TxState> txStates=txService.gettxStates(map);
		txPage.setTxStates(txStates);
		txPage.getParameter().setState(1);
		AreaUtil.getUserAreaParamer(txPage, sysUser, true);
		return new ModelAndView("/money/"+province+"/dks","txPage",txPage);
	}
	
	
	@RequestMapping("get_tx_info")
	public ModelAndView getTxInfo(HttpServletRequest request,int txid,int shinfo,int page){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		TxRecord txRecord=new TxRecord();
		TxPage txPage=new TxPage();
		txPage.setSysUser(sysUser);
		txPage.setTxid(txid);
		
		try {
			txRecord=txService.getTx(txPage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String url = "/money/" + province + "/money_info";
		ModelAndView modelAndView = new ModelAndView(url);
		if (shinfo == 0) {
			modelAndView.addObject("loadurl", "/money/money_info_back.html");
		} else {
			modelAndView.addObject("loadurl", "/money/"+txRecord.getLoadurl());

		}
		modelAndView.addObject("page",page);
		modelAndView.addObject("tx",txRecord);
		return modelAndView;
	}
	
	@RequestMapping("/money_info_back")
	public ModelAndView getTxBack(HttpServletRequest request){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		String url = "/money/" + province + "/money_info_back";
		return new ModelAndView(url);
	}

	@RequestMapping("/money_info_apply_sh")
	public ModelAndView getTxApplySh(HttpServletRequest request){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		String url = "/money/" + province + "/ money_info_apply_sh";
		return new ModelAndView(url);
		
	}
	
	@RequestMapping("/money_info_dk_sh")
	public ModelAndView getTxDKSh(HttpServletRequest request){
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int province=sysUser.getProvince();
		String url = "/money/" + province + "/money_info_dk_sh";
		return new ModelAndView(url);
		
	}

	
	@RequestMapping("sh_money_apply")
	@ResponseBody
	public Object shTxApply(HttpServletRequest request,TxRecord txRecord){
		if(txRecord==null||txRecord.getId()==0){
			return ResultUtil.responseErrorMsg("审核失败！");
		}
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int count=0;
		try {
			count=txService.shTxApply(txRecord,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count<=0)
			return ResultUtil.responseErrorMsg("审核失败！");
		return ResultUtil.responseSuccessMsg("审核成功！");
	}
	

	@RequestMapping("sh_money_dk")
	@ResponseBody
	public Object shTxDk(HttpServletRequest request,TxRecord txRecord){
		if(txRecord==null||txRecord.getId()==0){
			return ResultUtil.responseErrorMsg("审核失败！");
		}
		SysUser sysUser=SessionUtil.getUserFromSession(request);
		int count=0;
		try {
			count=txService.shTxDk(txRecord,sysUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(count<=0)
			return ResultUtil.responseErrorMsg("审核失败！");
		return ResultUtil.responseSuccessMsg("审核成功！");
	}
	
	
	public TxPage getM_txPage() {
		return m_txPage;
	}


	public void setM_txPage(TxPage m_txPage) {
		this.m_txPage = m_txPage;
	}
	
	
	
	
	
	
	
	
	
}
