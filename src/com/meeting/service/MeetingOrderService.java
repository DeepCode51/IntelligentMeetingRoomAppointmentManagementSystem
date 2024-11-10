package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface MeetingOrderService{
	/**
	分页查询会议室预订数据总数
	*/
	public Map<String,Integer> getDataListCount(MeetingOrder queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询会议室预订数据列表
	*/
	public Map<String,Object> getDataList(MeetingOrder queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装会议室预订为前台展示的数据形式
	*/
	public Map<String,Object> getMeetingOrderModel(MeetingOrder model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	预订会议室
	*/
	public String add(MeetingOrder model,LoginModel login);
}
