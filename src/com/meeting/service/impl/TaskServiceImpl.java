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
public class TaskServiceImpl implements TaskService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	
	@Override
	public void taskService(){
		MeetingOrderExample me = new MeetingOrderExample();
		MeetingOrderExample.Criteria mc = me.createCriteria();
		mc.andMeetingStatusNotEqualTo(1);
		mc.andMeetingStatusNotEqualTo(3);
		mc.andMeetingStatusNotEqualTo(5);
		mc.andMeetingStatusNotEqualTo(6);
		List<MeetingOrder> ml = meetingOrderMapper.selectByExample(me);
		for(MeetingOrder m:ml) {
			if(m.getMeetingStatus()==2) {
				if(m.getStartTime().compareTo(sdf1.format(new Date()))<0) {
					m.setMeetingStatus(4);		
					meetingOrderMapper.updateByPrimaryKeySelective(m);
				}
			}
			if(m.getMeetingStatus()==4) {
				if(m.getEndTime().compareTo(sdf1.format(new Date()))<0) {
					m.setMeetingStatus(5);		
					meetingOrderMapper.updateByPrimaryKeySelective(m);
				}
			}
			
		}
	}
}
