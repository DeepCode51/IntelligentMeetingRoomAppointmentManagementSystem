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
@RequestMapping("/user/sign_log")
public class USignLogController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	SignLogService signLogService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	SignLogMapper signLogMapper;
	/**
	* 根据查询条件分页查询签到记录数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(SignLog model,Integer page,String signTime1,String signTime2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return signLogService.getDataListCount(signTime1,signTime2,model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回签到记录列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,Integer meetingId,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		SignLog model = new SignLog();
		model.setMeetingId(meetingId);
		modelMap.addAttribute("data",model);
		return "user/sign_log/list";
	}
	/**
	* 根据查询条件分页查询签到记录数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(SignLog model,Integer page,String signTime1,String signTime2,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return signLogService.getDataList(signTime1,signTime2,model,page,CommonVal.pageSize,login);//分页查询数据
	}
}
