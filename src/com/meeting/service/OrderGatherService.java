package com.meeting.service;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import com.meeting.dao.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface OrderGatherService{
	/**
	预订走势
	page:当前页数
	login:当前登录账号
	mecreateTime1:创建时间（最小值）
	mecreateTime2:创建时间（最大值）
	*/
	public Map<String,Object> orderGather(Integer page,LoginModel login,String mecreateTime1,String mecreateTime2);
}
