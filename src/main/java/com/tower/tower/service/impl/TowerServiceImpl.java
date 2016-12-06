package com.tower.tower.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.common.util.proj.AreaUtil;
import com.tower.common.util.proj.TowerUtil;
import com.tower.system.bean.SysUser;
import com.tower.tower.bean.Tower;
import com.tower.tower.bean.TowerCreateType;
import com.tower.tower.bean.TowerLevel;
import com.tower.tower.bean.TowerState;
import com.tower.tower.bean.TowerStore;
import com.tower.tower.bean.TowerStyle;
import com.tower.tower.bean.TowerType;
import com.tower.tower.bean.TowersPage;
import com.tower.tower.mapper.TowerMapper;
import com.tower.tower.service.TowerService;

@Service
public class TowerServiceImpl implements TowerService {

	@Autowired
	private TowerMapper towerMapper;

	@Override
	public List<Tower> getTowers(TowersPage towerpage) {
		int count = towerMapper.getTowersCount(towerpage);
		List<Tower> towers = towerMapper.getTowers(towerpage);
		towerpage.setPagerowtotal(count);
		towerpage.setTowers(towers);
		return towers;
	}

	@Override
	public Tower getTowerInfoById(int id) {
		return towerMapper.getTowerInfoById(id);
	}

	@Override
	public int insertTower(Tower tower) {
		return towerMapper.insertTower(tower);
	}

	@Override
	public int updateTower(Tower tower) {
		return towerMapper.updateTower(tower);
	}

	@Override
	public int delTower(Map<String,Object> map) {
		return towerMapper.delTower(map);
	}

	@Override
	public int updateTowerVisible(Map<String, Object> map) {
		return towerMapper.updateTowerVisible(map);
	}

	@Override
	public int updateTowerState(Map<String, Object> map) {
		return towerMapper.updateTowerState(map);
	}

	@Override
	public int updateTowerSource(Map<String, Object> map) {
		return towerMapper.updateTowerSource(map);
	}


	@Override
	 public List<TowerStyle> getTowerStyles() {
		return towerMapper.getTowerStyles();
	}
	

	@Override
	public List<TowerType> getTowerTypes(int styleid) {
		return towerMapper.getTowerTypes(styleid);
	}

	@Override
	public void getTowerParamer(TowersPage towersPage,SysUser sysUser,boolean all) {
		int province=sysUser.getProvince();
		// 站址类型

		List<TowerLevel> towerLevels=towerMapper.getTowerLevels(province);
		towersPage.setTowerLevels(towerLevels);
		
		// 站址区域
		AreaUtil.getTowerAreaParamer(towersPage,sysUser,all);
		// 站址状态
		List<TowerState> towerStates=TowerUtil.getTowerState(province);
		towersPage.setTowerStates(towerStates);
		// 建站类型
					List<TowerCreateType> towerCreateTypes=towerMapper.getTowerTowerCreateTypes(province);
					towersPage.setTowerCreateTypes(towerCreateTypes);
		switch (province) {
		case 31:// 上海
			
			break;
		case 37: // 山东
			
			break;

		default:
			break;
		}
	}

	@Override
	public List<TowerStore> getTowerStores(int province) {
		return towerMapper.getTowerStores(province);
	}

	@Override
	public String getAreaOrder(int city, int area) {

		Map<String,Object> map=new HashMap<String,Object>();
		map.put("city", String.valueOf(city));
		map.put("area", String.valueOf(area));
		
		Map<String,Object> result = towerMapper.getareaorder(map);
		int ordercount = Integer.parseInt(result.get("count").toString());
		int count = 0;
		if ( ordercount == 0) {
			//插入记录
			count = towerMapper.insertareaorder(map);
			if (count ==0)
				return "error";
			return  String.valueOf(city) + String.valueOf(area) + String.format("%05d", 1);		
		} else {
			//更新序号+1
			count = towerMapper.updateareaorder(map);
			if (count ==0)
				return "error";
			return city + area + String.format("%05d", Integer.parseInt(result.get("orderno").toString())+1);
		}
	}

	@Override
	public List<TowerLevel> getTowerLevels(int province) {
		return towerMapper.getTowerLevels(province);
	}

}
