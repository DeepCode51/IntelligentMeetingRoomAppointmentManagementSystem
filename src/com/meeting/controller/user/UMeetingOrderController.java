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
@RequestMapping("/user/meeting_order")
public class UMeetingOrderController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	MeetingOrderService meetingOrderService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("meetingStatusList",DataListUtils.getMeetingStatusList());//返回meeting_status列表
	}
	/**
	* 根据查询条件分页查询会议室预订数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(MeetingOrder model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//预订用户等于当前登录id
		return meetingOrderService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回会议室预订列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,Integer rid,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		MeetingOrder model = new MeetingOrder();
		model.setRid(rid);
		modelMap.addAttribute("data",model);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "user/meeting_order/list";
	}
	/**
	* 根据查询条件分页查询会议室预订数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(MeetingOrder model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		model.setUid(login.getId());//预订用户等于当前登录id
		return meetingOrderService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入预订会议室页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,MeetingOrder model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "user/meeting_order/add_page";
	}
	/**
	预订会议室提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(MeetingOrder model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = meetingOrderService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","预订会议室成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除会议室预订接口
	*/
	@RequestMapping("del1")
	@ResponseBody
	public Object del1(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		meetingOrderService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "qx")
	@ResponseBody
	public Object qx(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		MeetingOrder model = meetingOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该会议室预订已不存在");
			return rs;
		}
		model.setMeetingStatus(6);
		meetingOrderMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","取消成功");
		return rs;
	}
}
