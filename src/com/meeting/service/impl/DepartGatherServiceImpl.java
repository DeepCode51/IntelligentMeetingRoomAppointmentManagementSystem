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
public class DepartGatherServiceImpl implements DepartGatherService{
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	AdhocDepartGatherMapper adhocDepartGatherMapper;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	/**
	部门会议统计
	page:当前页数
	login:当前登录账号
	*/
	@Override
	public Map<String,Object> departGather(Integer page,LoginModel login){
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list=adhocDepartGatherMapper.departGather();//部门会议统计
		for(Map<String,Object> adhocMap:list){
			if(adhocMap.get("col2")!=null){
				DepartMsg model = departMsgMapper.selectByPrimaryKey(Integer.parseInt(adhocMap.get("col2").toString()));
				if(model!=null){
					String col2Str="";
					col2Str+=model.getDname();
					adhocMap.put("col2Str", col2Str);
				}
			}
		}
		DepartMsgExample departMsgE = new DepartMsgExample();
		DepartMsgExample.Criteria departMsgC =departMsgE.createCriteria();
		List<DepartMsg> departMsgXList = departMsgMapper.selectByExample(departMsgE);//得到x轴数据列表
		List<Map<String,String>> departMsgXList2 = new ArrayList<Map<String,String>>();
		for(DepartMsg tmp:departMsgXList){
			Map<String,String> departMsgXMap = new HashMap<String,String>();
			String showXVal="";
			showXVal+=tmp.getDname();
			departMsgXMap.put("name", showXVal);
			departMsgXMap.put("id",tmp.getId()+"");
			departMsgXList2.add(departMsgXMap);
		}
		rs.put("udepartIdXList",departMsgXList2);
		List<Map<String,Object>> rsList1 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<list.size();i++){
			Map<String,Object> map =list.get(i);
			rsList1.add(map);
		}
		rs.put("rsList1",rsList1);
		return rs;
	}
}
