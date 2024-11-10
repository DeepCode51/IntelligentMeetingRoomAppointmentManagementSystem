package com.meeting.controller.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.meeting.dao.*;
import com.meeting.model.*;
import com.meeting.service.impl.*;
import com.meeting.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.meeting.controller.LoginModel;
import com.meeting.service.*;
@Controller
@RequestMapping("/user/room_msg")
public class URoomMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	RoomMsgService roomMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("roomTypeList",DataListUtils.getRoomTypeList());//返回room_type列表
	}
	/**
	* 根据查询条件分页查询会议室数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(RoomMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return roomMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回会议室列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "user/room_msg/list";
	}
	/**
	* 根据查询条件分页查询会议室数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(RoomMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return roomMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
