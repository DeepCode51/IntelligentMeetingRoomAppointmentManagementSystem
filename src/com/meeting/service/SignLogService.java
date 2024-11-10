package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface SignLogService{
	/**
	分页查询签到记录数据总数
	*/
	public Map<String,Integer> getDataListCount(String signTime1,String signTime2,SignLog queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询签到记录数据列表
	*/
	public Map<String,Object> getDataList(String signTime1,String signTime2,SignLog queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装签到记录为前台展示的数据形式
	*/
	public Map<String,Object> getSignLogModel(SignLog model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
}
