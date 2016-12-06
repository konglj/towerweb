package com.tower.system.service;

import java.util.List;

import com.tower.system.bean.Menu;

public interface MenuService {
	
	/**
	 * 获取所有的菜单类别 （包含childmenu）
	 * @param province
	 * @return
	 */
	public List<Menu> getMenus(int province);

}
