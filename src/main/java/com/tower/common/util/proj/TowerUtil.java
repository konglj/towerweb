package com.tower.common.util.proj;

import java.util.ArrayList;
import java.util.List;

import com.tower.tower.bean.TowerState;

public class TowerUtil {

	/**
	 * 站址状态
	 * 
	 * @return
	 */
	public static List<TowerState> getTowerState(int province) {
		List<TowerState> list = new ArrayList<TowerState>();
		TowerState state = null;
		if (province == 0||province==31||province==37) {
			state = new TowerState("全部", -1);
			list.add(state);

			state = new TowerState("未抢", 0);
			list.add(state);

			state = new TowerState("抢单", 1);
			list.add(state);
		}
		return list;
	}
}
