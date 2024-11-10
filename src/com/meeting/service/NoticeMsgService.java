package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface NoticeMsgService{
	/**
	分页查询公告数据总数
	*/
	public Map<String,Integer> getDataListCount(NoticeMsg queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询公告数据列表
	*/
	public Map<String,Object> getDataList(NoticeMsg queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装公告为前台展示的数据形式
	*/
	public Map<String,Object> getNoticeMsgModel(NoticeMsg model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(NoticeMsg model,LoginModel login);
	/**
	修改
	*/
	public String update(NoticeMsg model,LoginModel login);
}
