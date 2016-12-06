package com.tower.order.bean;

/**
 * @author win7
 *
 */
public class Order {
	
	private int id;
	
    private String towerno;//站址编号
	
	private String toweridefined;//自定义编号
	
	private String orderid;
	
	private String username;
	
	private String usertele;
	
	private String usercity;
	
	private String usercityname;
	
	private int userdistrict;
	
	private String userdistrictname;
	
	private String towername;
	
	private int towercity;
	
	private String   towercityname;
	
	private String towerdistrict;
	
	private String   towerdistrictname;
	
	private int towerarea;
	
	private String towerareaname;
	
	private int towerfactfee;
	
	private int towerstateeffect;
	
	private String towerstatename;
	
	private int towerfee;
	
	private String toweraddtime;
	
	private int towerid;
	
	private int userid;
	
	private String userwintype;
	
	private int orderstate;
	
	private String orderstatename;
	
	
	private String towerstateshtype;
	
	private int moneyapply;//是否为付款审核
	
	private int canpj;//是否需要评价订单
	
	private int towerpjprogress;//评价进度 1 用户 2 管理员
	
	public String getTowerno() {
		return towerno;
	}

	public void setTowerno(String towerno) {
		this.towerno = towerno;
	}

	public String getToweridefined() {
		return toweridefined;
	}

	public void setToweridefined(String toweridefined) {
		this.toweridefined = toweridefined;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getUserdistrictname() {
		return userdistrictname;
	}

	public void setUserdistrictname(String userdistrictname) {
		this.userdistrictname = userdistrictname;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public String getUsercity() {
		return usercity;
	}

	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}


	public String getTowername() {
		return towername;
	}

	public void setTowername(String towername) {
		this.towername = towername;
	}

	public int getTowercity() {
		return towercity;
	}

	public void setTowercity(int towercity) {
		this.towercity = towercity;
	}

	public String getTowercityname() {
		return towercityname;
	}

	public void setTowercityname(String towercityname) {
		this.towercityname = towercityname;
	}

	public int getTowerarea() {
		return towerarea;
	}

	public void setTowerarea(int towerarea) {
		this.towerarea = towerarea;
	}

	public String getTowerareaname() {
		return towerareaname;
	}

	public void setTowerareaname(String towerareaname) {
		this.towerareaname = towerareaname;
	}

	public int getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}

	public String getOrderstatename() {
		return orderstatename;
	}

	public void setOrderstatename(String orderstatename) {
		this.orderstatename = orderstatename;
	}

	public String getTowerstatename() {
		return towerstatename;
	}

	public void setTowerstatename(String towerstatename) {
		this.towerstatename = towerstatename;
	}

	public int getTowerfee() {
		return towerfee;
	}

	public void setTowerfee(int towerfee) {
		this.towerfee = towerfee;
	}

	public String getToweraddtime() {
		return toweraddtime;
	}

	public void setToweraddtime(String toweraddtime) {
		this.toweraddtime = toweraddtime;
	}

	public String getUsercityname() {
		return usercityname;
	}

	public void setUsercityname(String usercityname) {
		this.usercityname = usercityname;
	}

	
	public int getUserdistrict() {
		return userdistrict;
	}

	public void setUserdistrict(int userdistrict) {
		this.userdistrict = userdistrict;
	}

	


	public int getTowerid() {
		return towerid;
	}

	public void setTowerid(int towerid) {
		this.towerid = towerid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUserwintype() {
		return userwintype;
	}

	public void setUserwintype(String userwintype) {
		this.userwintype = userwintype;
	}

	public String getTowerdistrict() {
		return towerdistrict;
	}

	public void setTowerdistrict(String towerdistrict) {
		this.towerdistrict = towerdistrict;
	}

	public String getTowerdistrictname() {
		return towerdistrictname;
	}

	public void setTowerdistrictname(String towerdistrictname) {
		this.towerdistrictname = towerdistrictname;
	}

	public int getTowerstateeffect() {
		return towerstateeffect;
	}

	public void setTowerstateeffect(int towerstateeffect) {
		this.towerstateeffect = towerstateeffect;
	}

	public String getTowerstateshtype() {
		return towerstateshtype;
	}

	public void setTowerstateshtype(String towerstateshtype) {
		this.towerstateshtype = towerstateshtype;
	}

	public int getTowerfactfee() {
		return towerfactfee;
	}

	public void setTowerfactfee(int towerfactfee) {
		this.towerfactfee = towerfactfee;
	}

	public int getMoneyapply() {
		return moneyapply;
	}

	public void setMoneyapply(int moneyapply) {
		this.moneyapply = moneyapply;
	}

	public int getCanpj() {
		return canpj;
	}

	public void setCanpj(int canpj) {
		this.canpj = canpj;
	}

	public int getTowerpjprogress() {
		return towerpjprogress;
	}

	public void setTowerpjprogress(int towerpjprogress) {
		this.towerpjprogress = towerpjprogress;
	}
	
	

	
	
	
	
	
	
	
	

}
