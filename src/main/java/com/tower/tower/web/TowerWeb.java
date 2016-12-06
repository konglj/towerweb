package com.tower.tower.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.TabableView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tower.common.bean.Area;
import com.tower.common.bean.DataTable;
import com.tower.common.service.AreaService;
import com.tower.common.util.ResultUtil;
import com.tower.common.util.StrUtil;
import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.SessionUtil;
import com.tower.common.util.proj.TowerUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.Tower;
import com.tower.tower.bean.TowerStyle;
import com.tower.tower.bean.TowerType;
import com.tower.tower.bean.TowersPage;
import com.tower.tower.service.TowerService;

@Controller
@RequestMapping("/tower")
@Scope("singleton")
public class TowerWeb {

	private TowersPage m_towersPage = new TowersPage();

	@Autowired
	private TowerService towerService;

	@Autowired
	private AreaService areaService;

	private void getTowers(SysUser sysUser, TowersPage towersPage) {
		towerService.getTowers(towersPage);
	}

	/**
	 * 获取站址页面
	 * 
	 * @param request
	 * @param towersPage
	 * @return
	 */
	@RequestMapping("/towers")
	public ModelAndView getTowersPage(HttpServletRequest request,
			TowersPage towersPage) {
		int isback = towersPage.getBack();
		towersPage.setBack(0);
		if (isback == 1) {
			towersPage = m_towersPage;
		} else {
			this.m_towersPage = towersPage;
		}
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		// getTowers(sysUser,EnumUtil.TowerVisible.VISIBLE.ordinal(),towersPage);
		int province = sysUser.getProvince();
		String url = "/tower/" + province + "/";
		switch (towersPage.getTowervisible()) {
		case -1:
			url += "tower_no";
			break;
		case 0:
			url += "tower_no";
			break;
		case 1:
			url += "tower_yes";
			towersPage.setTowerStates(TowerUtil.getTowerState(province));
			break;
		case 2:
			url += "tower_pool";
			break;
		default:
			break;
		}
		towerService.getTowerParamer(towersPage, sysUser, true);
		return new ModelAndView(url, "towersPage", towersPage);
	}

	/**
	 * 已上架
	 * 
	 * @param request
	 * @param towersPage
	 * @return
	 */
	@RequestMapping("/get_towers")
	@ResponseBody
	public Object getTowerYes(HttpServletRequest request, TowersPage towersPage) {

		this.m_towersPage = towersPage;
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		towersPage.setSysUser(sysUser);

		// towersPage.setPageno(pageno);
		getTowers(sysUser, towersPage);

		DataTable table = new DataTable(towersPage.sEcho,
				towersPage.getPagerowtotal(), towersPage.getPagerowtotal(),
				towersPage.getTowers());

		return ResultUtil.responseSuccessMsg(table);
	}

	/**
	 * 未上架
	 * 
	 * @param request
	 * @param towersPage
	 * @return
	 */
	@RequestMapping("/tower_no")
	public ModelAndView getTowerNo(HttpServletRequest request,
			TowersPage towersPage) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		// getTowers(sysUser,EnumUtil.TowerVisible.NO_VISIBLE.ordinal(),towersPage);
		int province = sysUser.getProvince();
		return new ModelAndView("/tower/" + province + "/tower_no",
				"towersPage", towersPage);
	}

	/**
	 * 站址池（待审核）
	 * 
	 * @param request
	 * @param towersPage
	 * @return
	 */
	@RequestMapping("/tower_pool")
	public ModelAndView getTowerPool(HttpServletRequest request,
			TowersPage towersPage) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		// getTowers(sysUser,EnumUtil.TowerVisible.POOL.ordinal(),towersPage);
		int province = sysUser.getProvince();
		return new ModelAndView("/tower/" + province + "/tower_pool",
				"towersPage", towersPage);
	}

	@RequestMapping("/towerinfo")
	public ModelAndView getTowerInfo(HttpServletRequest request, int towerid) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		Tower tower = towerService.getTowerInfoById(towerid);
		return new ModelAndView("/tower/" + province + "/tower_info", "tower",
				tower);
	}

	@RequestMapping("/savetower")
	@ResponseBody
	public Object saveTower(HttpServletRequest request, Tower tower) {
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int count = 0;
		if (tower == null)
			return ResultUtil.responseErrorMsg("保存失败！");
	
		try {
			String towerid="";
			
				switch (sysUser.getArealevel()) {
				case 1:

					break;
				case 2:
					tower.setTowerprovince(sysUser.getProvince());
					 towerid = towerService.getAreaOrder(tower.getTowercity(),
							tower.getTowerdistrict());
					tower.setTowerid(towerid);
					break;
				case 3:
					tower.setTowerprovince(sysUser.getProvince());
					tower.setTowercity(Integer.valueOf(sysUser.getCity()));
					
					break;
				case 4:

					break;

				default:
					break;
				}
				if (tower.getId() == 0) {
				 towerid = towerService.getAreaOrder(tower.getTowerdistrict(),
								tower.getTowerarea());
						tower.setTowerid(towerid);
				tower.setToweradduser(sysUser.getId());
				count = towerService.insertTower(tower);
			} else
				count = towerService.updateTower(tower);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count == 0)
			return ResultUtil.responseErrorMsg("保存失败！");
		return ResultUtil.responseSuccessMsg("保存成功！");
	}

	@RequestMapping("/deltower")
	@ResponseBody
	public Object delTower(String towerids) {
		if (StrUtil.isNullOrEmpty(towerids)) {
			return ResultUtil.responseErrorMsg("请选择需要删除的站址！");
		}
		String[] ids = towerids.split(",");
		if (ids.length == 0) {
			return ResultUtil.responseErrorMsg("请选择需要删除的站址！");
		}
		int count = 0;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			count = towerService.delTower(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count == 0)
			return ResultUtil.responseErrorMsg("删除失败！");
		return ResultUtil.responseSuccessMsg("删除成功！");

	}

	@RequestMapping("toweredit")
	public ModelAndView getTowerEdit(HttpServletRequest request, int id,
			int towervisible) {
		Tower tower = new Tower();
		SysUser sysUser = SessionUtil.getUserFromSession(request);
		int province = sysUser.getProvince();
		TowersPage towersPage = new TowersPage();
		towerService.getTowerParamer(towersPage, sysUser, false);
		List<TowerStyle> towerStyles = towerService.getTowerStyles();
		List<TowerType> towerTypes = new ArrayList<TowerType>();
		int towerstyle = 0;
		if (id != 0) {
			tower = towerService.getTowerInfoById(id);
			towerstyle = tower.getTowerstyle();
		} else {
			towerstyle = towerStyles.get(0).getId();
		}
		towerTypes = towerService.getTowerTypes(towerstyle);
		towersPage.setTower(tower);
		towersPage.setTowerStyles(towerStyles);
		towersPage.setTowerTypes(towerTypes);
		towersPage.setTowerStores(towerService.getTowerStores(sysUser
				.getProvince()));
		// AreaUtil.getTowerAreaParamer(towersPage, sysUser, false);
		int disid = 0;
		
		switch (sysUser.getArealevel()) {
		case 1:
			break;
		case 2:
			towersPage.setParamerCitys(sysUser.getCitys());

			if (tower.getTowercity() != 0) {
				disid = tower.getTowercity();
			} else {
				disid = sysUser.getCitys().get(0).getCityid();
			}
			towersPage.setParamerDistricts(areaService.getDistricts(disid, sysUser));
			break;
		case 3:
			towersPage.setParamerDistricts(sysUser.getDistricts());

			if (tower.getTowerdistrict() != 0) {
				disid = tower.getTowerdistrict();
			} else {
				disid = sysUser.getDistricts().get(0).getDisid();
			}
			towersPage.setParamerAreas(areaService.getAreas(disid,sysUser.getAreas()));
			break;

		case 4:
			break;

		default:
			break;
		}

		return new ModelAndView("/tower/" + province + "/tower_edit",
				"towersPage", towersPage);
	}

	@RequestMapping("/updatevisible")
	@ResponseBody
	public Object updateTowerVisible(String towerids, int state) {
		if (StrUtil.isNullOrEmpty(towerids)) {
			return ResultUtil.responseErrorMsg("请选择需要修改的站址！");
		}
		String[] ids = towerids.split(",");
		if (ids.length == 0) {
			return ResultUtil.responseErrorMsg("请选择需要修改的站址！");
		}
		int count = 0;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", ids);
			map.put("towervisible", state);
			count = towerService.updateTowerVisible(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (count == 0)
			return ResultUtil.responseErrorMsg("操作失败！");
		return ResultUtil.responseSuccessMsg("操作成功！");

	}

	public TowersPage getM_towersPage() {
		return m_towersPage;
	}

	public void setM_towersPage(TowersPage m_towersPage) {
		this.m_towersPage = m_towersPage;
	}

}
