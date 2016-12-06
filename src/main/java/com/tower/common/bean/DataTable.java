package com.tower.common.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTable {


	private String sEcho;// 表示请求次数

	private Integer iTotalRecords;// 总记录数

	private Integer iTotalDisplayRecords;// 过滤后的总记录数

	private Object aaData;// 具体的数据对象数组

	public String getsEcho()
	{
		return sEcho;
	}

	public void setsEcho(String sEcho)
	{
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords()
	{
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords)
	{
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getiTotalDisplayRecords()
	{
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords)
	{
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object getAaData()
	{
		return aaData;
	}

	public void setAaData(Object aaData)
	{
		this.aaData = aaData;
	}

	public DataTable(String sEcho, Integer iTotalRecords,
			Integer iTotalDisplayRecords, Object aaData)
	{
		super();
		this.sEcho = sEcho;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

	public DataTable(String sEcho, Object aaData)
	{
		super();
		this.sEcho = sEcho;
		this.aaData = aaData;
	}

	public DataTable()
	{
		super();
	}

	public Map<String, Object> toJson()
	{

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sEcho", sEcho);
		map.put("iTotalRecords", iTotalRecords);
		map.put("iTotalDisplayRecords", iTotalDisplayRecords);
		List<Object> list3 = new ArrayList<Object>();
		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) aaData;
		try
		{
			if (list != null && list.size() > 0)
			{
				for (int i = 0; i < list.size(); i++)
				{
					Object object = list.get(i);
					Class<? extends Object> cl = object.getClass();
					Method[] ms = cl.getMethods();
					List<Object> list2 = new ArrayList<Object>();
					for (Method m : ms)
					{
						String mName = m.getName();
						if (mName.startsWith("get"))
						{
							Object o = m.invoke(object);
							list2.add(o.toString());
						}
					}
					list3.add(list2);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		map.put("aaData", list3);
		return map;

	}

}
