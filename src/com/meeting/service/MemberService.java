package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface MemberService{
	/**
	分页查询参会人员数据总数
	*/
	public Map<String,Integer> getDataListCount(Member queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询参会人员数据列表
	*/
	public Map<String,Object> getDataList(Member queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装参会人员为前台展示的数据形式
	*/
	public Map<String,Object> getMemberModel(Member model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(Member model,LoginModel login);
	/**
	修改
	*/
	public String update(Member model,LoginModel login);
}
