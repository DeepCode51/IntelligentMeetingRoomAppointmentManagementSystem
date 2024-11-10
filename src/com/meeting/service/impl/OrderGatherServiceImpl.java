package com.meeting.service.impl;
import java.util.Map;
import java.util.HashMap;
import com.meeting.controller.LoginModel;
import com.meeting.model.*;
import com.meeting.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.meeting.service.*;
import  java.io.InputStream;
import   java.text.SimpleDateFormat;
import  com.meeting.util.*;
import   org.springframework.ui.ModelMap;
import   java.util.regex.Pattern;
import  java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
@Service
public class OrderGatherServiceImpl implements OrderGatherService{
	@Autowired
	AdhocOrderGatherMapper adhocOrderGatherMapper;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	预订走势
	page:当前页数
	login:当前登录账号
	mecreateTime1:创建时间（最小值）
	mecreateTime2:创建时间（最大值）
	*/
	@Override
	public Map<String,Object> orderGather(Integer page,LoginModel login,String mecreateTime1,String mecreateTime2){
		Map<String,Object> rs = new HashMap<String,Object>();
		Map<String,Object> params= new HashMap<String,Object>();
		params.put("createTime1",mecreateTime1);
		params.put("createTime2",mecreateTime2);
		List<Map<String,Object>> list=adhocOrderGatherMapper.orderGather(params);//预订走势
		for(Map<String,Object> adhocMap:list){
		}
		List<String> createTimeXList=DateCommonUtils.getEchartTimeList(mecreateTime1,mecreateTime2,"yyyy-MM-dd","yyyy-MM-dd",3);
		rs.put("createTimeXList",createTimeXList);
		List<Map<String,Object>> rsList1 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map =list.get(i);
			rsList1.add(map);
		}
		rs.put("rsList1",rsList1);
		return rs;
	}
}
