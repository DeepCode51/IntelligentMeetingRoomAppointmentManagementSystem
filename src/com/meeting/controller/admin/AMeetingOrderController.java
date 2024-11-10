package com.meeting.controller.admin;
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
@RequestMapping("/admin/meeting_order")
public class AMeetingOrderController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	MeetingOrderService meetingOrderService;
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	@Autowired
	MemberMapper memberMapper;
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
		return meetingOrderService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回会议室预订列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		AdminMsg adminMsg = adminMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",adminMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "admin/meeting_order/list";
	}
	/**
	* 根据查询条件分页查询会议室预订数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(MeetingOrder model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return meetingOrderService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	删除会议室预订接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		meetingOrderService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "shtg")
	@ResponseBody
	public Object shtg(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		MeetingOrder model = meetingOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该会议室预订已不存在");
			return rs;
		}
		model.setMeetingStatus(2);
		meetingOrderMapper.updateByPrimaryKey(model);
		
		
		MemberExample me = new MemberExample();
		MemberExample.Criteria mc = me.createCriteria();
		mc.andMeetingIdEqualTo(model.getId());
		List<Member> ml = memberMapper.selectByExample(me);
		for(Member m:ml) {
			try {
				MailOperation.sendMail(m.getEmail(), "会议提醒", "您有待参与会议，会议主题是：“"+m.getTitle()+"”");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs.put("code", 1);
		rs.put("msg","审核通过成功");
		return rs;
	}
	@RequestMapping(value = "shbtg")
	@ResponseBody
	public Object shbtg(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		MeetingOrder model = meetingOrderMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该会议室预订已不存在");
			return rs;
		}
		model.setMeetingStatus(3);
		meetingOrderMapper.updateByPrimaryKey(model);
		rs.put("code", 1);
		rs.put("msg","审核不通过成功");
		return rs;
	}
}
