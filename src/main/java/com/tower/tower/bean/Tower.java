package com.tower.tower.bean;

import java.util.List;

import com.tower.common.bean.MapPoint;

public class Tower {

	private int id;

	// towerid
	private String towerid;

	// 站址名称
	private String towername;

	// 运营商需求 移动
	private String towerwhoyd;

	// 运营商需求 移动
	private String towerwhodx;

	// 运营商需求 移动
	private String towerwholt;

	// 省
	private int towerprovince;

	// 市
	private int towercity;

	// 区
	private int towerdistrict;

	// 街道
	private int towerarea;


	// 详细地址
	private String toweraddress;

	// 站址级别
	private int towerlevel;

	// 站址基本名称
	private String towerlevelname;

	// 站址费用
	private int towerfee;

	// 站址状态
	private int towerstate;

	// 站址状态名称
	private String towerstatename;

	private int towerstyle;
	
	private String towerstylename;
	
	// 站址类型
	private int towertype;

	// 站址类型名称
	private String towertypename;

	// 站址面积
	private String towerlarge;

	// 站址精度
	private String towerj;

	// 站址精度
	private String towerw;

	// 站址百度地图精度
	private String towerjbaidu;

	// 站址百度地图精度
	private String towerwbaidu;

	private String towerfirstjbaidu = "0";

	private String towerfirstwbaidu = "0";

	private String towersecondjbaidu = "0";

	private String towersecondwbaidu = "0";

	// 管理员手机号
	private String towermanager;

	// 管理员名
	private String towermanagername;

	
	// 站址详情
	private String towerinfo;
	
	// 站址详情
	private String towerremark;

	// 是否上架
	private int towervisible;

	// 订单ＩＤ
	private String towerorderid;

	// 站址图片
	private String towerimg;

	private String areaname;

	private String cityname;

	private String provincename;

	private String districtname;

	// 是否收藏
	private int isfavourite;

	private String toweridefined;

	private String toweradddate;

	private String towervisibletime;
	
	private String towercreatetime;

	private int towerrentfee;

	private int adminpower;

	private int orderstate;

	private int pagetype = 0;// 0 tower 1 order

	private int towerstore;

	private String towerstorename;
	
	private int towerhb;

	// 经度
	private String towerfirstj;

	// 纬度
	private String towerfirstw;

	// 经度
	private String towersecondj;

	// 纬度
	private String towersecondw;

	private int towersource;

	private List<MapPoint> towerMapPoint;

	private int towercreatetype;

	private String towercreatetypename;

	private String towermanagerchat;
	
	private int toweradduser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTowerid() {
		return towerid;
	}

	public void setTowerid(String towerid) {
		this.towerid = towerid;
	}

	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public String getTowerwhoyd() {
		return towerwhoyd;
	}

	public void setTowerwhoyd(String towerwhoyd) {
		this.towerwhoyd = towerwhoyd;
	}

	public String getTowerwhodx() {
		return towerwhodx;
	}

	public void setTowerwhodx(String towerwhodx) {
		this.towerwhodx = towerwhodx;
	}

	public String getTowerwholt() {
		return towerwholt;
	}

	public void setTowerwholt(String towerwholt) {
		this.towerwholt = towerwholt;
	}

	public int getTowerprovince() {
		return towerprovince;
	}

	public void setTowerprovince(int towerprovince) {
		this.towerprovince = towerprovince;
	}

	public int getTowercity() {
		return towercity;
	}

	public void setTowercity(int towercity) {
		this.towercity = towercity;
	}

	public int getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(int towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public int getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(int towerarea) {
		this.towerarea = towerarea;
	}

	public String getToweraddress() {
		return toweraddress;
	}

	public void setToweraddress(String toweraddress) {
		this.toweraddress = toweraddress;
	}

	public int getTowerlevel() {
		return towerlevel;
	}

	public void setTowerlevel(int towerlevel) {
		this.towerlevel = towerlevel;
	}

	public String getTowerlevelname() {
		return towerlevelname;
	}

	public void setTowerlevelname(String towerlevelname) {
		this.towerlevelname = towerlevelname;
	}

	public int getTowerfee() {
		return towerfee;
	}

	public void setTowerfee(int towerfee) {
		this.towerfee = towerfee;
	}

	public int getTowerstate() {
		return towerstate;
	}

	public void setTowerstate(int towerstate) {
		this.towerstate = towerstate;
	}

	public String getTowerstatename() {
		return towerstatename;
	}

	public void setTowerstatename(String towerstatename) {
		this.towerstatename = towerstatename;
	}

	
	public int getTowerstyle() {
		return towerstyle;
	}

	
	
	public String getTowerstylename() {
		return towerstylename;
	}

	public void setTowerstylename(String towerstylename) {
		this.towerstylename = towerstylename;
	}

	public void setTowerstyle(int towerstyle) {
		this.towerstyle = towerstyle;
	}

	public int getTowertype() {
		return towertype;
	}

	public void setTowertype(int towertype) {
		this.towertype = towertype;
	}

	public String getTowertypename() {
		return towertypename;
	}

	public void setTowertypename(String towertypename) {
		this.towertypename = towertypename;
	}

	public String getTowerlarge() {
		return towerlarge;
	}

	public void setTowerlarge(String towerlarge) {
		this.towerlarge = towerlarge;
	}

	public String getTowerj() {
		return towerj;
	}

	public void setTowerj(String towerj) {
		this.towerj = towerj;
	}

	public String getTowerw() {
		return towerw;
	}

	public void setTowerw(String towerw) {
		this.towerw = towerw;
	}

	public String getTowerjbaidu() {
		return towerjbaidu;
	}

	public void setTowerjbaidu(String towerjbaidu) {
		this.towerjbaidu = towerjbaidu;
	}

	public String getTowerwbaidu() {
		return towerwbaidu;
	}

	public void setTowerwbaidu(String towerwbaidu) {
		this.towerwbaidu = towerwbaidu;
	}

	public String getTowerfirstjbaidu() {
		return towerfirstjbaidu;
	}

	public void setTowerfirstjbaidu(String towerfirstjbaidu) {
		this.towerfirstjbaidu = towerfirstjbaidu;
	}

	public String getTowerfirstwbaidu() {
		return towerfirstwbaidu;
	}

	public void setTowerfirstwbaidu(String towerfirstwbaidu) {
		this.towerfirstwbaidu = towerfirstwbaidu;
	}

	public String getTowersecondjbaidu() {
		return towersecondjbaidu;
	}

	public void setTowersecondjbaidu(String towersecondjbaidu) {
		this.towersecondjbaidu = towersecondjbaidu;
	}

	public String getTowersecondwbaidu() {
		return towersecondwbaidu;
	}

	public void setTowersecondwbaidu(String towersecondwbaidu) {
		this.towersecondwbaidu = towersecondwbaidu;
	}

	public String getTowermanager() {
		return towermanager;
	}

	public void setTowermanager(String towermanager) {
		this.towermanager = towermanager;
	}

	public String getTowermanagername() {
		return towermanagername;
	}

	public void setTowermanagername(String towermanagername) {
		this.towermanagername = towermanagername;
	}

	public String getTowerinfo() {
		return towerinfo;
	}

	public void setTowerinfo(String towerinfo) {
		this.towerinfo = towerinfo;
	}

	
	
	public String getTowerremark() {
		return towerremark;
	}

	public void setTowerremark(String towerremark) {
		this.towerremark = towerremark;
	}

	public int getTowervisible() {
		return towervisible;
	}

	public void setTowervisible(int towervisible) {
		this.towervisible = towervisible;
	}

	public String getTowerorderid() {
		return towerorderid;
	}

	public void setTowerorderid(String towerorderid) {
		this.towerorderid = towerorderid;
	}

	public String getTowerimg() {
		return towerimg;
	}

	public void setTowerimg(String towerimg) {
		this.towerimg = towerimg;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public int getIsfavourite() {
		return isfavourite;
	}

	public void setIsfavourite(int isfavourite) {
		this.isfavourite = isfavourite;
	}

	public String getToweridefined() {
		return toweridefined;
	}

	public void setToweridefined(String toweridefined) {
		this.toweridefined = toweridefined;
	}

	public String getToweradddate() {
		return toweradddate;
	}

	public void setToweradddate(String toweradddate) {
		this.toweradddate = toweradddate;
	}

	public String getTowervisibletime() {
		return towervisibletime;
	}

	public void setTowervisibletime(String towervisibletime) {
		this.towervisibletime = towervisibletime;
	}

	public int getTowerrentfee() {
		return towerrentfee;
	}

	public void setTowerrentfee(int towerrentfee) {
		this.towerrentfee = towerrentfee;
	}

	public int getAdminpower() {
		return adminpower;
	}

	public void setAdminpower(int adminpower) {
		this.adminpower = adminpower;
	}

	public int getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}

	public int getPagetype() {
		return pagetype;
	}

	public void setPagetype(int pagetype) {
		this.pagetype = pagetype;
	}

	public int getTowerstore() {
		return towerstore;
	}

	public void setTowerstore(int towerstore) {
		this.towerstore = towerstore;
	}

	public String getTowerstorename() {
		return towerstorename;
	}

	public void setTowerstorename(String towerstorename) {
		this.towerstorename = towerstorename;
	}

	public String getTowerfirstj() {
		return towerfirstj;
	}

	public void setTowerfirstj(String towerfirstj) {
		this.towerfirstj = towerfirstj;
	}

	public String getTowerfirstw() {
		return towerfirstw;
	}

	public void setTowerfirstw(String towerfirstw) {
		this.towerfirstw = towerfirstw;
	}

	public String getTowersecondj() {
		return towersecondj;
	}

	public void setTowersecondj(String towersecondj) {
		this.towersecondj = towersecondj;
	}

	public String getTowersecondw() {
		return towersecondw;
	}

	public void setTowersecondw(String towersecondw) {
		this.towersecondw = towersecondw;
	}

	public int getTowersource() {
		return towersource;
	}

	public void setTowersource(int towersource) {
		this.towersource = towersource;
	}

	public List<MapPoint> getTowerMapPoint() {
		return towerMapPoint;
	}

	public void setTowerMapPoint(List<MapPoint> towerMapPoint) {
		this.towerMapPoint = towerMapPoint;
	}

	public int getTowercreatetype() {
		return towercreatetype;
	}

	public void setTowercreatetype(int towercreatetype) {
		this.towercreatetype = towercreatetype;
	}

	public String getTowercreatetypename() {
		return towercreatetypename;
	}

	public void setTowercreatetypename(String towercreatetypename) {
		this.towercreatetypename = towercreatetypename;
	}

	public String getTowermanagerchat() {
		return towermanagerchat;
	}

	public void setTowermanagerchat(String towermanagerchat) {
		this.towermanagerchat = towermanagerchat;
	}

	public String getTowercreatetime() {
		return towercreatetime;
	}

	public void setTowercreatetime(String towercreatetime) {
		this.towercreatetime = towercreatetime;
	}

	public int getTowerhb() {
		return towerhb;
	}

	public void setTowerhb(int towerhb) {
		this.towerhb = towerhb;
	}

	public int getToweradduser() {
		return toweradduser;
	}

	public void setToweradduser(int toweradduser) {
		this.toweradduser = toweradduser;
	}
	
	
	

}
