package com.tower.tower.service;

import java.util.List;
import java.util.Map;

import com.tower.system.bean.SysUser;
import com.tower.tower.bean.Tower;
import com.tower.tower.bean.TowerLevel;
import com.tower.tower.bean.TowerStore;
import com.tower.tower.bean.TowerStyle;
import com.tower.tower.bean.TowerType;
import com.tower.tower.bean.TowersPage;

public interface TowerService {

	/**
	 * 获取站址列表
	 * @param towerpage
	 * @return
	 */
	public List<Tower> getTowers(TowersPage towerpage);
	
	/**
	 * 获取站址详情
	 * @param id
	 * @return
	 */
	public Tower getTowerInfoById(int id);
	
	/**
	 * 插入站址
	 * @param tower
	 * @return
	 */
	public int insertTower(Tower tower);
	
	/**
	 * 修改站址信息
	 * @param tower
	 * @return
	 */
	public  int updateTower(Tower tower);
	
	/**
	 * 删除站址
	 * @param id
	 * @return
	 */
	public  int delTower(Map<String,Object> map);
	
	/**
	 * 修改站址上下架
	 * @param map
	 * @return
	 */
	public int updateTowerVisible(Map<String,Object> map);
	
	
	/**
	 * 修改站址状态
	 * @param map
	 * @return
	 */
	public int updateTowerState(Map<String,Object> map);
	
	
	  /**
     * 修改未上架站址来源，0 新增，1 下架
     * @param map
     * @return
     */
    public int updateTowerSource(Map<String, Object>  map);
    
    /**
     * 站址类型（style）
     * @return
     */
    public List<TowerStyle> getTowerStyles();
    
    /**
     * 站址类型
     * @return
     */
    public List<TowerType> getTowerTypes(int styleid);
    
    /**
     * 获取条件
     * @param province
     */
    public void getTowerParamer(TowersPage towersPage,SysUser sysUser,boolean all);
    
    
    /**
     * 站址库类型
     * @return
     */
    public List<TowerStore> getTowerStores(int province);
    
    /**
     * 获取站址编号
     * @param cityid
     * @param area
     * @return
     */
    public String getAreaOrder(int cityid, int area);
    
    /**
     * 站址等级
     * @param province
     * @return
     */
    public List<TowerLevel> getTowerLevels(int province);
}
