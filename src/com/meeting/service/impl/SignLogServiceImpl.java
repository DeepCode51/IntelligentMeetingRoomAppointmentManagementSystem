package com.meeting.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meeting.dao.*;
import com.meeting.model.*;
import com.meeting.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.meeting.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.meeting.service.*;
import com.meeting.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class SignLogServiceImpl implements SignLogService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	SignLogMapper signLogMapper;
	/**
	*根据参数查询签到记录列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(String signTime1,String signTime2,SignLog queryModel,Integer pageSize,LoginModel login) {
		SignLogExample se = new SignLogExample();
		SignLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getMeetingId()!=null){
			sc.andMeetingIdEqualTo(queryModel.getMeetingId());
		}
		if(signTime1!=null&&signTime1.equals("")==false){
			sc.andSignTimeGreaterThanOrEqualTo(signTime1);
		}
		if(signTime2!=null&&signTime2.equals("")==false){
			sc.andSignTimeLessThanOrEqualTo(signTime2);
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		
		if(queryModel.getMeetingId()==null&&login.getLoginType()==2) {
			sc.andUserIdEqualTo(login.getId());
		}
		
		int count = (int)signLogMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询签到记录列表数据
	*/
	@Override
	public Map<String,Object> getDataList(String signTime1,String signTime2,SignLog queryModel,Integer page,Integer pageSize,LoginModel login) {
		SignLogExample se = new SignLogExample();
		SignLogExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getMeetingId()!=null){
			sc.andMeetingIdEqualTo(queryModel.getMeetingId());
		}
		if(signTime1!=null&&signTime1.equals("")==false){
			sc.andSignTimeGreaterThanOrEqualTo(signTime1);
		}
		if(signTime2!=null&&signTime2.equals("")==false){
			sc.andSignTimeLessThanOrEqualTo(signTime2);
		}
		if(queryModel.getUserId()!=null){
			sc.andUserIdEqualTo(queryModel.getUserId());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		
		if(queryModel.getMeetingId()==null&&login.getLoginType()==2) {
			sc.andUserIdEqualTo(login.getId());
		}
		List<SignLog> list = signLogMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(SignLog model:list){
			list2.add(getSignLogModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装签到记录为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getSignLogModel(SignLog model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("signLog",model);
		if(model.getMemberId()!=null){
			Member member = memberMapper.selectByPrimaryKey(model.getMemberId());//参会id为外接字段，需要关联参会人员来解释该字段
			if(member!=null){
				UserMsg userMsg = userMsgMapper.selectByPrimaryKey(member.getStafId());
				map.put("memberIdStr",userMsg.getLoginName());
			}
		}
		if(model.getMeetingId()!=null){
			MeetingOrder meetingOrder = meetingOrderMapper.selectByPrimaryKey(model.getMeetingId());//会议为外接字段，需要关联会议室预订来解释该字段
			if(meetingOrder!=null){
				map.put("meetingIdStr",meetingOrder.getTitle());
			}
		}
		if(model.getUserId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUserId());//签到用户为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("userIdStr",userMsg.getLoginName());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		signLogMapper.deleteByPrimaryKey(id);
	}
}
