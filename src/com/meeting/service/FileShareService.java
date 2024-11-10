package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface FileShareService{
	/**
	分页查询共享文件数据总数
	*/
	public Map<String,Integer> getDataListCount(FileShare queryModel,Integer pageSize,LoginModel login) ;
	/**
	分页查询共享文件数据列表
	*/
	public Map<String,Object> getDataList(FileShare queryModel,Integer page,Integer pageSize,LoginModel login) ;
	/**
	封装共享文件为前台展示的数据形式
	*/
	public Map<String,Object> getFileShareModel(FileShare model,LoginModel login);
	/**
	* 删除数据
	*/
	public void delete(Integer id);
	/**
	新增
	*/
	public String add(FileShare model,LoginModel login);
	/**
	修改
	*/
	public String update(FileShare model,LoginModel login);
}
