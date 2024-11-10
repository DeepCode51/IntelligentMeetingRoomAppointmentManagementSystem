package com.meeting.dao;
import java.util.Map;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import com.meeting.dao.*;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
public interface AdhocDepartGatherMapper{
	/**
	部门会议统计
	*/
	public List<Map<String,Object>> departGather();
}
