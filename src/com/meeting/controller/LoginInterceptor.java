package com.meeting.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.meeting.util.CommonVal;
/**
过滤器，校验所有需要验证的请求，判断是否有登录，如果未登录，则强制跳转到登录页面，如果已登录，则判断是否正在进行非法请求
*/
public class LoginInterceptor  implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String contextPath2 = requestUri.trim().replaceAll("/","");
		if(contextPath2.equals("meeting_sys")){
			return true;
		}
		if (login == null) {//登录session为空，说明尚未登录
			if(requestUri.contains("/admin/")){
				response.sendRedirect(contextPath+"/login/sys_login");//强制跳转到登录页面
				return false;
			}
			if(requestUri.contains("/user/")){
				response.sendRedirect(contextPath+"/login/sys_login");//强制跳转到登录页面
				return false;
			}
			return true;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
