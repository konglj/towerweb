package com.tower.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tower.system.bean.Menu;
import com.tower.system.mapper.MenuMapper;
import com.tower.system.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	/**
	 * 获取所有的菜单类别 （包含childmenu）
	 * @param province
	 * @return
	 */
	public List<Menu> getMenus(int province){
		return menuMapper.getMenus(province);
	}

}
