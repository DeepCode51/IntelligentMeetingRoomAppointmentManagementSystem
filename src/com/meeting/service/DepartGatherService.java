package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import com.meeting.dao.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface DepartGatherService{
	/**
	部门会议统计
	page:当前页数
	login:当前登录账号
	*/
	public Map<String,Object> departGather(Integer page,LoginModel login);
}
