package com.tower.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tower.system.bean.SysUser;

public class BasePage implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageno=1;
	
	private int pagerowtotal;
	
	private int pageSize=10;
	
	
	
	private SysUser sysUser=new SysUser();
	
	private int province;
	
	private int city;
	
	private int district;
	
	private int area;
	
	private List<Province> paramerProvinces=new ArrayList<Province>();
	
	private List<City> paramerCitys=new ArrayList<City>();
	
	private List<District> paramerDistricts=new ArrayList<District>();
	
	private List<Area> paramerAreas=new ArrayList<Area>();
	
	private int back=0;
	
     private List<City> userParamerCitys=new ArrayList<City>();
	
	private List<District> userParamerDistricts=new ArrayList<District>();
	
	
	
	// / <summary>
		// / DataTable请求服务器端次数
		// / </summary>
		public String sEcho = "0";

		// / <summary>
		// / 过滤文本
		// / </summary>
		public String sSearch;

		// / <summary>
		// / 每页显示的数量
		// / </summary>
		public int iDisplayLength;

		// / <summary>
		// / 分页时每页跨度数量
		// / </summary>
		public int iDisplayStart;

		// / <summary>
		// / 列数
		// / </summary>
		public int iColumns;

		// / <summary>
		// / 排序列的数量

		// / </summary>

		public int iSortingCols;

		public String sColumns;

		public String iSortCol_0;

		public String sSortDir_0;

		public String[] mDataProp_;

	

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getPagerowtotal() {
		return pagerowtotal;
	}

	public void setPagerowtotal(int pagerowtotal) {
		this.pagerowtotal = pagerowtotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiColumns() {
		return iColumns;
	}

	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}

	public int getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public String getiSortCol_0() {
		return iSortCol_0;
	}

	public void setiSortCol_0(String iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}

	public String getsSortDir_0() {
		return sSortDir_0;
	}

	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}

	public String[] getmDataProp_() {
		return mDataProp_;
	}

	public void setmDataProp_(String[] mDataProp_) {
		this.mDataProp_ = mDataProp_;
	}

	public List<Province> getParamerProvinces() {
		return paramerProvinces;
	}

	public void setParamerProvinces(List<Province> paramerProvinces) {
		this.paramerProvinces = paramerProvinces;
	}

	public List<City> getParamerCitys() {
		return paramerCitys;
	}

	public void setParamerCitys(List<City> paramerCitys) {
		this.paramerCitys = paramerCitys;
	}

	public List<District> getParamerDistricts() {
		return paramerDistricts;
	}

	public void setParamerDistricts(List<District> paramerDistricts) {
		this.paramerDistricts = paramerDistricts;
	}

	public List<Area> getParamerAreas() {
		return paramerAreas;
	}

	public void setParamerAreas(List<Area> paramerAreas) {
		this.paramerAreas = paramerAreas;
	}

	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public List<City> getUserParamerCitys() {
		return userParamerCitys;
	}

	public void setUserParamerCitys(List<City> userParamerCitys) {
		this.userParamerCitys = userParamerCitys;
	}

	public List<District> getUserParamerDistricts() {
		return userParamerDistricts;
	}

	public void setUserParamerDistricts(List<District> userParamerDistricts) {
		this.userParamerDistricts = userParamerDistricts;
	}

	
	
	
	
	
	
}
