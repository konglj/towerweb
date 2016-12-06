package com.tower.system.bean;

import java.util.List;

import com.tower.common.bean.Area;
import com.tower.common.bean.City;
import com.tower.common.bean.District;
import com.tower.common.bean.Province;

public class SysUser {
	
	private int id;
	
	private String adminid;
	
	private String password;
	
	private int power;
	
	private String powername;
	

	private int province;//省
	
	private String city;//市
	
	private String district;//区
	
	private String area;//街道
	
	
	
	private String phone;//电环
	
	private int wxisbind;//是否绑定微信
	
	private String wxid;//微信ID
	
	private String dltime;//最后登录时间
	
	private String addtime;//添加时间
	
	private int admintype;
	
	private String typesuffix;
	
	private String name;
	
	private int state;
	
	private List<Province> provinces;
	
	private List<City> citys;
	
	private List<District> districts;
	
	private List<Area> areas;
	
	private int arealevel;
	
	private int userarealevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getPowername() {
		return powername;
	}

	public void setPowername(String powername) {
		this.powername = powername;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getWxisbind() {
		return wxisbind;
	}

	public void setWxisbind(int wxisbind) {
		this.wxisbind = wxisbind;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getDltime() {
		return dltime;
	}

	public void setDltime(String dltime) {
		this.dltime = dltime;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public int getAdmintype() {
		return admintype;
	}

	public void setAdmintype(int admintype) {
		this.admintype = admintype;
	}

	public String getTypesuffix() {
		return typesuffix;
	}

	public void setTypesuffix(String typesuffix) {
		this.typesuffix = typesuffix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	
	
	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public int getArealevel() {
		return arealevel;
	}

	public void setArealevel(int arealevel) {
		this.arealevel = arealevel;
	}

	public int getUserarealevel() {
		return userarealevel;
	}

	public void setUserarealevel(int userarealevel) {
		this.userarealevel = userarealevel;
	}
	
	
	

}