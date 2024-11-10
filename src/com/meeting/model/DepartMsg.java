package com.meeting.model;
public class DepartMsg {
	private Integer id;//ID
	private String dname;//部门名
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getDname(){
		return dname;
	}
	public void setDname(String dname){
		this.dname = dname == null ? null : dname.trim();
	}
}
