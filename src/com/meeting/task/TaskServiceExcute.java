package com.meeting.task;
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
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
@Component
public class TaskServiceExcute {
	@Autowired
	TaskService taskService;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	//定时任务,定时规则：每分钟执行一次
	@Scheduled(cron="0 0/1 * * * ?")
	public void taskService(){
		taskService.taskService();
	}
}
