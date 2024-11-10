package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface DepartMsgService{
	/**
	分页查询部门数据总数
	*/
	public Map<String,Integer> getDataListCount(DepartMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询部门数据列表
	*/
	public Map<String,Object> getDataList(DepartMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装部门为前台展示的数据形式
	*/
	public Map<String,Object> getDepartMsgModel(DepartMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(DepartMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(DepartMsg model,LoginModel login);
}
