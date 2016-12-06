package com.tower.order.bean;

import java.util.ArrayList;
import java.util.List;


public class OrderInfo{
	
	private int id;
	
	private int userid;
	
	private String username;
	 
	private String usertele;
	
	private String usercityname;
	
	private String userdistrictname;
	
	private String userareaname;
	
	private String userlevelname;
	
	private String usercompany;
	
	private String userbusiness;
	
	private int ordercount;

	private int succcount;

	private int ingcount;

	private int failcount;

	private int cancelcount;
	
	
	private int towerlevel;
	
	
	private int towerid;
	
	private String towername;
	
	private String towercityname;
	
	private String towerdistrictname;
	
	private String towerareaname;
	
	private String towerlevelname;
	
	private int towerfee;
	
	private int towerrentfee;
	
	private String towermanager;
	
	private String towermanagername;
	
	private String towerstylename;
	
	private String towertypename;
	
	private String towerinfo;
	
	private String towerj;
	
	private String towerw;
	
	private int towerfirstfee;
	
	private int towerendfee;
	
	private String orderid;
	
	private String towerhtid;
	
	private String towerdelayreason;
	
	private String toweraddtime;
	
	private String towerstatename;
	
	private String towerstateloadurl;
	
	private String towerstateshtype;//0  不可操作 1 审核  2付款申请	3 评价
	
	private int towerstate;
	
	private String towerendtime;
	
	private String towerabandontime;
	
	private String towertargetaddress;
	
	private String towerpowertypename;
	
	private Double towerpowerprice;
	
	private String towerpowert;
	
	private int towerfactfee;
	
	private String towerthreeht;
	
	private int towerfactrentfee;
	
	private String towerhtimag;
	
	private String towerfile;
	
	private String towerfactaddress;
	
	private String toweryzname;
	
	private String toweryzphone;
	
	private int towerpjprogress;
	
	private int toweryqcount;
	
	private String adminpjcontent;
	
	private String userpjcontent;
	
	private String userpjtower;
	
	private String towerprojectno;
	
	private String towerprojectname;
	
	private String towerfactgps;
	
	private int shresult;
	
	private String shinfo;
	
	private int  ordersuccessstate;
	
	private int ordersuccessdeal;//订单处理成功，是否真实处理，用户处理两级处理问题
	
	private int  ordererrorstate;
	
	private int ordererrordeal;
	
	private int orderreleaseingcount;//订单失效时进行中订单处理数量
	
	private int towerrelease;//订单审核失败是都需要释放站址
	
	private int ischeckht;
	

	private List<OrderShInfo> shInfos=new ArrayList<OrderShInfo>();


	private int towerconrejectcount;//站址连续审核次数
	
	private int userconcancelcount;//站址连续审核次数
	
	private int delayday=0;//延期时延期天数
	
	private int orderisdeal=0;//当两步处理时 哪一步实际操作  对目标建站和延期有效

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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



	public String getUsercityname() {
		return usercityname;
	}



	public void setUsercityname(String usercityname) {
		this.usercityname = usercityname;
	}



	public String getUserdistrictname() {
		return userdistrictname;
	}



	public void setUserdistrictname(String userdistrictname) {
		this.userdistrictname = userdistrictname;
	}



	public String getUserareaname() {
		return userareaname;
	}



	public void setUserareaname(String userareaname) {
		this.userareaname = userareaname;
	}



	public String getUserlevelname() {
		return userlevelname;
	}



	public void setUserlevelname(String userlevelname) {
		this.userlevelname = userlevelname;
	}



	public String getUsercompany() {
		return usercompany;
	}



	public void setUsercompany(String usercompany) {
		this.usercompany = usercompany;
	}



	public String getUserbusiness() {
		return userbusiness;
	}



	public void setUserbusiness(String userbusiness) {
		this.userbusiness = userbusiness;
	}



	public int getOrdercount() {
		return ordercount;
	}



	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}



	public int getSucccount() {
		return succcount;
	}



	public void setSucccount(int succcount) {
		this.succcount = succcount;
	}



	public int getIngcount() {
		return ingcount;
	}



	public void setIngcount(int ingcount) {
		this.ingcount = ingcount;
	}



	public int getFailcount() {
		return failcount;
	}



	public void setFailcount(int failcount) {
		this.failcount = failcount;
	}



	public int getCancelcount() {
		return cancelcount;
	}



	public void setCancelcount(int cancelcount) {
		this.cancelcount = cancelcount;
	}



	public int getTowerid() {
		return towerid;
	}



	public void setTowerid(int towerid) {
		this.towerid = towerid;
	}



	public String getTowername() {
		return towername;
	}



	public void setTowername(String towername) {
		this.towername = towername;
	}



	public String getTowercityname() {
		return towercityname;
	}



	public void setTowercityname(String towercityname) {
		this.towercityname = towercityname;
	}



	public String getTowerareaname() {
		return towerareaname;
	}



	public void setTowerareaname(String towerareaname) {
		this.towerareaname = towerareaname;
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



	public int getTowerrentfee() {
		return towerrentfee;
	}



	public void setTowerrentfee(int towerrentfee) {
		this.towerrentfee = towerrentfee;
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



	public String getTowerstylename() {
		return towerstylename;
	}



	public void setTowerstylename(String towerstylename) {
		this.towerstylename = towerstylename;
	}



	public String getTowertypename() {
		return towertypename;
	}



	public void setTowertypename(String towertypename) {
		this.towertypename = towertypename;
	}



	public String getTowerinfo() {
		return towerinfo;
	}



	public void setTowerinfo(String towerinfo) {
		this.towerinfo = towerinfo;
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



	public int getTowerfirstfee() {
		return towerfirstfee;
	}



	public void setTowerfirstfee(int towerfirstfee) {
		this.towerfirstfee = towerfirstfee;
	}



	public int getTowerendfee() {
		return towerendfee;
	}



	public void setTowerendfee(int towerendfee) {
		this.towerendfee = towerendfee;
	}



	public String getTowerhtid() {
		return towerhtid;
	}



	public void setTowerhtid(String towerhtid) {
		this.towerhtid = towerhtid;
	}



	public String getTowerdelayreason() {
		return towerdelayreason;
	}



	public void setTowerdelayreason(String towerdelayreason) {
		this.towerdelayreason = towerdelayreason;
	}



	public String getToweraddtime() {
		return toweraddtime;
	}



	public void setToweraddtime(String toweraddtime) {
		this.toweraddtime = toweraddtime;
	}



	public String getTowerstatename() {
		return towerstatename;
	}



	public void setTowerstatename(String towerstatename) {
		this.towerstatename = towerstatename;
	}



	public String getTowerendtime() {
		return towerendtime;
	}



	public void setTowerendtime(String towerendtime) {
		this.towerendtime = towerendtime;
	}



	public String getTowerabandontime() {
		return towerabandontime;
	}



	public void setTowerabandontime(String towerabandontime) {
		this.towerabandontime = towerabandontime;
	}



	public String getTowertargetaddress() {
		return towertargetaddress;
	}



	public void setTowertargetaddress(String towertargetaddress) {
		this.towertargetaddress = towertargetaddress;
	}



	public String getTowerpowertypename() {
		return towerpowertypename;
	}



	public void setTowerpowertypename(String towerpowertypename) {
		this.towerpowertypename = towerpowertypename;
	}



	public Double getTowerpowerprice() {
		return towerpowerprice;
	}



	public void setTowerpowerprice(Double towerpowerprice) {
		this.towerpowerprice = towerpowerprice;
	}



	public String getTowerpowert() {
		return towerpowert;
	}



	public void setTowerpowert(String towerpowert) {
		this.towerpowert = towerpowert;
	}



	public int getTowerfactfee() {
		return towerfactfee;
	}



	public void setTowerfactfee(int towerfactfee) {
		this.towerfactfee = towerfactfee;
	}



	public String getTowerthreeht() {
		return towerthreeht;
	}



	public void setTowerthreeht(String towerthreeht) {
		this.towerthreeht = towerthreeht;
	}



	public int getTowerfactrentfee() {
		return towerfactrentfee;
	}



	public void setTowerfactrentfee(int towerfactrentfee) {
		this.towerfactrentfee = towerfactrentfee;
	}



	public String getTowerhtimag() {
		return towerhtimag;
	}



	public void setTowerhtimag(String towerhtimag) {
		this.towerhtimag = towerhtimag;
	}



	public String getTowerfile() {
		return towerfile;
	}



	public void setTowerfile(String towerfile) {
		this.towerfile = towerfile;
	}



	public String getTowerfactaddress() {
		return towerfactaddress;
	}



	public void setTowerfactaddress(String towerfactaddress) {
		this.towerfactaddress = towerfactaddress;
	}



	public String getToweryzname() {
		return toweryzname;
	}



	public void setToweryzname(String toweryzname) {
		this.toweryzname = toweryzname;
	}



	public String getToweryzphone() {
		return toweryzphone;
	}



	public void setToweryzphone(String toweryzphone) {
		this.toweryzphone = toweryzphone;
	}



	public int getTowerpjprogress() {
		return towerpjprogress;
	}



	public void setTowerpjprogress(int towerpjprogress) {
		this.towerpjprogress = towerpjprogress;
	}



	public int getToweryqcount() {
		return toweryqcount;
	}



	public void setToweryqcount(int toweryqcount) {
		this.toweryqcount = toweryqcount;
	}



	public String getAdminpjcontent() {
		return adminpjcontent;
	}



	public void setAdminpjcontent(String adminpjcontent) {
		this.adminpjcontent = adminpjcontent;
	}



	public String getUserpjcontent() {
		return userpjcontent;
	}



	public void setUserpjcontent(String userpjcontent) {
		this.userpjcontent = userpjcontent;
	}



	public String getUserpjtower() {
		return userpjtower;
	}



	public void setUserpjtower(String userpjtower) {
		this.userpjtower = userpjtower;
	}



	public String getTowerprojectno() {
		return towerprojectno;
	}



	public void setTowerprojectno(String towerprojectno) {
		this.towerprojectno = towerprojectno;
	}



	public String getTowerprojectname() {
		return towerprojectname;
	}



	public void setTowerprojectname(String towerprojectname) {
		this.towerprojectname = towerprojectname;
	}



	public String getTowerfactgps() {
		return towerfactgps;
	}



	public void setTowerfactgps(String towerfactgps) {
		this.towerfactgps = towerfactgps;
	}



	public List<OrderShInfo> getShInfos() {
		return shInfos;
	}



	public void setShInfos(List<OrderShInfo> shInfos) {
		this.shInfos = shInfos;
	}



	public int getTowerstate() {
		return towerstate;
	}



	public void setTowerstate(int towerstate) {
		this.towerstate = towerstate;
	}



	public String getTowerdistrictname() {
		return towerdistrictname;
	}



	public void setTowerdistrictname(String towerdistrictname) {
		this.towerdistrictname = towerdistrictname;
	}



	public String getOrderid() {
		return orderid;
	}



	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}



	public int getShresult() {
		return shresult;
	}



	public void setShresult(int shresult) {
		this.shresult = shresult;
	}



	public int getOrdersuccessstate() {
		return ordersuccessstate;
	}



	public void setOrdersuccessstate(int ordersuccessstate) {
		this.ordersuccessstate = ordersuccessstate;
	}



	public int getOrdererrorstate() {
		return ordererrorstate;
	}



	public void setOrdererrorstate(int ordererrorstate) {
		this.ordererrorstate = ordererrorstate;
	}



	public int getTowerrelease() {
		return towerrelease;
	}



	public void setTowerrelease(int towerrelease) {
		this.towerrelease = towerrelease;
	}



	public String getTowerstateloadurl() {
		return towerstateloadurl;
	}



	public void setTowerstateloadurl(String towerstateloadurl) {
		this.towerstateloadurl = towerstateloadurl;
	}



	public String getTowerstateshtype() {
		return towerstateshtype;
	}



	public void setTowerstateshtype(String towerstateshtype) {
		this.towerstateshtype = towerstateshtype;
	}



	public String getShinfo() {
		return shinfo;
	}



	public void setShinfo(String shinfo) {
		this.shinfo = shinfo;
	}



	public int getTowerconrejectcount() {
		return towerconrejectcount;
	}



	public void setTowerconrejectcount(int towerconrejectcount) {
		this.towerconrejectcount = towerconrejectcount;
	}



	public int getTowerlevel() {
		return towerlevel;
	}



	public void setTowerlevel(int towerlevel) {
		this.towerlevel = towerlevel;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public int getOrderreleaseingcount() {
		return orderreleaseingcount;
	}



	public void setOrderreleaseingcount(int orderreleaseingcount) {
		this.orderreleaseingcount = orderreleaseingcount;
	}



	public int getIscheckht() {
		return ischeckht;
	}



	public void setIscheckht(int ischeckht) {
		this.ischeckht = ischeckht;
	}



	public int getUserconcancelcount() {
		return userconcancelcount;
	}



	public void setUserconcancelcount(int userconcancelcount) {
		this.userconcancelcount = userconcancelcount;
	}



	public int getDelayday() {
		return delayday;
	}

	public void setDelayday(int delayday) {
		this.delayday = delayday;
	}


	public int getOrdersuccessdeal() {
		return ordersuccessdeal;
	}


	public void setOrdersuccessdeal(int ordersuccessdeal) {
		this.ordersuccessdeal = ordersuccessdeal;
	}


	public int getOrdererrordeal() {
		return ordererrordeal;
	}


	public void setOrdererrordeal(int ordererrordeal) {
		this.ordererrordeal = ordererrordeal;
	}


	public int getOrderisdeal() {
		return orderisdeal;
	}


	public void setOrderisdeal(int orderisdeal) {
		this.orderisdeal = orderisdeal;
	}


	

	
	
	
	
	
	
	
	
	
}
