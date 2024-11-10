package com.meeting.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.meeting.controller.LoginModel;
import com.meeting.util.CommonVal;
import  com.meeting.model.*;
import com.meeting.dao.*;
import com.meeting.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
@Controller
@RequestMapping("/login")
public class LoginController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	AdminMsgMapper adminMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	进入登录页面接口
	*/
	@RequestMapping(value="sys_login")
	public String sys_login(ModelMap modelMap,String msg){
		modelMap.addAttribute("msg",msg);
		return "sys_login";
	}
	/**
	退出接口
	*/
	@RequestMapping(value="sys_logout")
	public String sys_logout(ModelMap modelMap,String msg,HttpServletRequest request){
		request.getSession().removeAttribute(CommonVal.sessionName);//删除登录session
		return "redirect:/login/sys_login";
	}
	/**
	提交登录验证信息接口
	*/
	@RequestMapping("sysSubmit")
	@ResponseBody
	public Object sysSubmit(LoginModel user,String imgCode,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String,Object> rs = new HashMap<String,Object>();
		//图片验证码验证，从session中查询验证码并校验
		if(imgCode==null||imgCode.trim().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入图片验证码");
			return rs;
		}
		if (!imgCode.toLowerCase().equals(request.getSession().getAttribute(CommonVal.code).toString().toLowerCase())){//当前验证码存储session的值是否和输入的值一致
			rs.put("code",0);
			rs.put("msg","图片验证码错误");
			return rs;
		}
		if(user.getLoginType()==null){
			rs.put("code",0);
			rs.put("msg","请选择登录角色");
			return rs;
		}
		if(user.getName()==null||user.getName().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入登录名");
			return rs;
		}
		if(user.getPassword()==null||user.getPassword().equals("")){
			rs.put("code",0);
			rs.put("msg","请输入密码");
			return rs;
		}
		if(user.getLoginType()==1){
			AdminMsgExample te = new AdminMsgExample();//验证管理员账号密码
			AdminMsgExample.Criteria tc = te.createCriteria();
			tc.andLoginNameEqualTo(user.getName());//查询LoginName=用户名
			tc.andPasswordEqualTo(user.getPassword());//查询Password=输入的密码
			List<AdminMsg> tl = adminMsgMapper.selectByExample(te);
			if(tl.size()==0){//从数据库中查询不到账号
				rs.put("code",0);
				rs.put("msg","登录名或密码错误");
				return rs;
			}else{
				LoginModel login = new LoginModel();
				login.setId(tl.get(0).getId());
				login.setLoginType(1);
				login.setName(user.getName());
				request.getSession().setAttribute(CommonVal.sessionName, login);//设置登录session，保持会话
				rs.put("code",1);
				rs.put("msg","登录成功");
				return rs;
			}
		}
		if(user.getLoginType()==2){
			UserMsgExample te = new UserMsgExample();//验证用户账号密码
			UserMsgExample.Criteria tc = te.createCriteria();
			tc.andLoginNameEqualTo(user.getName());//查询LoginName=用户名
			tc.andPasswordEqualTo(user.getPassword());//查询Password=输入的密码
			List<UserMsg> tl = userMsgMapper.selectByExample(te);
			if(tl.size()==0){//从数据库中查询不到账号
				rs.put("code",0);
				rs.put("msg","登录名或密码错误");
				return rs;
			}else{
				LoginModel login = new LoginModel();
				login.setId(tl.get(0).getId());
				login.setLoginType(2);
				login.setName(user.getName());
				request.getSession().setAttribute(CommonVal.sessionName, login);//设置登录session，保持会话
				rs.put("code",1);
				rs.put("msg","登录成功");
				return rs;
			}
		}
		rs.put("code",0);
		rs.put("msg","系统出错");
		return rs;
	}
}
