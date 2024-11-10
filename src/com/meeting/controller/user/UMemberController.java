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
@RequestMapping("/user/member")
public class UMemberController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	MemberService memberService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	SignLogMapper signLogMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		UserMsgExample userMsgE = new UserMsgExample();
		UserMsgExample.Criteria userMsgC=userMsgE.createCriteria();
		userMsgC.andIdNotEqualTo(login.getId());//ID等于当前登录id
		List<UserMsg> userMsgList=userMsgMapper.selectByExample(userMsgE);
		List<Map<String,Object>>  userMsgList2 = new ArrayList<Map<String,Object>>();
		for(UserMsg m:userMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getLoginName());
			userMsgList2.add(map);
		}
		modelMap.addAttribute("userMsgList",userMsgList2);
	}
	/**
	* 根据查询条件分页查询参会人员数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(Member model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return memberService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回参会人员列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,Integer meetingId,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		Member model = new Member();
		model.setMeetingId(meetingId);
		modelMap.addAttribute("data",model);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "user/member/list";
	}
	/**
	* 根据查询条件分页查询参会人员数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(Member model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return memberService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,Member model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "user/member/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(Member model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = memberService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update")
	public String update(ModelMap modelMap,Member model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		Member data = memberMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "user/member/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(Member model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = memberService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除参会人员接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		memberService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
	@RequestMapping(value = "sign")
	@ResponseBody
	public Object sign(Integer id, ModelMap modelMap,
	HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rs = new HashMap<String, Object>();
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Member model = memberMapper.selectByPrimaryKey(id);
		if(model==null){
			rs.put("code", 0);
			rs.put("msg","该参会人员已不存在");
			return rs;
		}
	
		SignLogExample se = new SignLogExample();
		SignLogExample.Criteria sc =se.createCriteria();
		sc.andMemberIdEqualTo(model.getId());
		sc.andUserIdEqualTo(login.getId());
		int count = (int) signLogMapper.countByExample(se);
		if(count>0) {
			rs.put("code", 0);
			rs.put("msg","您已签到该会议，不能重复签到");
			return rs;
		}
		SignLog log = new SignLog();
		log.setMeetingId(model.getMeetingId());
		log.setMemberId(model.getId());
		log.setSignTime(sdf1.format(new Date()));
		log.setUserId(login.getId());
		signLogMapper.insertSelective(log);
		
		rs.put("code", 1);
		rs.put("msg","签到成功");
		return rs;
	}
}
