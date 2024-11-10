package com.meeting.dao;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import com.meeting.dao.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
public interface AdhocOrderGatherMapper{
	/**
	预订走势
	*/
	public List<Map<String,Object>> orderGather(Map<String,Object> params);//预订走势
}
