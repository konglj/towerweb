package com.tower.system.mapper;

import java.util.List;

import com.tower.system.bean.Menu;

public interface MenuMapper {
	
	/**
	 * 获取所有的菜单类别 （包含childmenu）
	 * @param province
	 * @return
	 */
	public List<Menu> getMenus(int province);

}
