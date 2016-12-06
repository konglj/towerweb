package com.tower.system.mapper;

import java.util.Map;

import com.tower.system.bean.SysUser;

public interface SysMapper {

	/**
	 * 根据用户名密码获取登录信息
	 * 
	 * @param map
	 * @return
	 */
	public SysUser getSysUserInfoByPwd(Map<String, Object> map);

	/**
	 * 修改管理员密码
	 * 
	 * @param map
	 * @return
	 */
	public int updatePwd(Map<String, Object> map);

	/**
	 * 修改管理员信息
	 * 
	 * @param map
	 * @return
	 */
	public int updateSysUserInfo(Map<String,Object> map);

	/**
	 * 插入管理员信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public int insertSysUser(SysUser sysUser);

	/**
	 * 删除管理员信息（假删除）
	 * 
	 * @param id
	 * @return
	 */
	public int delSysUser(int id);
	
	/**
	 * 修改管理员最后登录时间
	 * 
	 * @param id
	 * @return
	 */
	public int updateUserDlTime(int id);

}
