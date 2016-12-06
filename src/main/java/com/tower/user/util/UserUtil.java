package com.tower.user.util;

import java.util.List;

import com.tower.user.bean.UserLevel;

public class UserUtil {

	
	private static boolean check_range(int min,int max,int cur){
		if(max==0){
			if(cur>=min)
				return true;
			else
				return false;
		}else{
			if(cur>=min&&cur<=max)
				return true;
		}
		return false;
	}
	public static int getUserLevel(int score,int exp,List<UserLevel> userLevels){
		
		for (UserLevel userLevel : userLevels) {
			if(check_range(userLevel.getMinscore(),userLevel.getMaxscore(),score)){
				if(check_range(userLevel.getMinexp(),userLevel.getMaxexp(),exp)){
					return userLevel.getUserlevel();
				}else{
					if(userLevel.getUserlevel()==1)
						return userLevel.getUserlevel();
					else
						return userLevel.getUserlevel()-1;
				}
			}
		}
		
		return  1;
		
	}
}
