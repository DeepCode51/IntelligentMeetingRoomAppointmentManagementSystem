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
public class MeetingOrderServiceImpl implements MeetingOrderService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	/**
	预订会议室
	*/
	@Override
	public String add(MeetingOrder model,LoginModel login){
		if(model.getStartTime()==null||model.getStartTime().equals("")){
			return "开始时间为必填属性";
		}
		if(model.getEndTime()==null||model.getEndTime().equals("")){
			return "结束时间为必填属性";
		}
		if(model.getTotalHours()==null){
			return "总时长为必填属性";
		}
		if(model.getUsingIntro()==null||model.getUsingIntro().equals("")){
			return "用途为必填属性";
		}
		model.setUid(login.getId());//登录id
		model.setMeetingStatus(1);//默认已预约,
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		UserMsg uidT = userMsgMapper.selectByPrimaryKey(model.getUid());//查询用户
		if(uidT!=null){
			model.setUdepartId(uidT.getDepartId());//赋值uidT的所属部门
		}
		String nowTime = sdf1.format(new Date());
		if(model.getStartTime().compareTo(nowTime)<0){
			return "开始时间不能小于当前时间";
		}
		if(model.getEndTime().compareTo(nowTime)<0){
			return "结束时间不能小于当前时间";
		}
		if(model.getStartTime()!=null&&model.getEndTime()!=null&&model.getStartTime().compareTo(model.getEndTime())>0){
			return "开始时间不能大于结束时间";
		}
		meetingOrderMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	*根据参数查询会议室预订列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(MeetingOrder queryModel,Integer pageSize,LoginModel login) {
		MeetingOrderExample se = new MeetingOrderExample();
		MeetingOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getRid()!=null){
			sc.andRidEqualTo(queryModel.getRid());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getMeetingStatus()!=null){
			sc.andMeetingStatusEqualTo(queryModel.getMeetingStatus());//查询预订状态等于指定值
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		int count = (int)meetingOrderMapper.countByExample(se);
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
	*根据参数查询会议室预订列表数据
	*/
	@Override
	public Map<String,Object> getDataList(MeetingOrder queryModel,Integer page,Integer pageSize,LoginModel login) {
		MeetingOrderExample se = new MeetingOrderExample();
		MeetingOrderExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getRid()!=null){
			sc.andRidEqualTo(queryModel.getRid());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(queryModel.getMeetingStatus()!=null){
			sc.andMeetingStatusEqualTo(queryModel.getMeetingStatus());//查询预订状态等于指定值
		}
		if(queryModel.getUid()!=null){
			sc.andUidEqualTo(queryModel.getUid());
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<MeetingOrder> list = meetingOrderMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(MeetingOrder model:list){
			list2.add(getMeetingOrderModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装会议室预订为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getMeetingOrderModel(MeetingOrder model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("meetingOrder",model);
		if(model.getUid()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getUid());//预订用户为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("uidStr",userMsg.getLoginName());
			}
		}
		if(model.getUdepartId()!=null){
			DepartMsg departMsg = departMsgMapper.selectByPrimaryKey(model.getUdepartId());//所属部门为外接字段，需要关联部门来解释该字段
			if(departMsg!=null){
				map.put("udepartIdStr",departMsg.getDname());
			}
		}
		if(model.getRid()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRid());//会议室为外接字段，需要关联会议室来解释该字段
			if(roomMsg!=null){
				map.put("ridStr",roomMsg.getRoomNo());
			}
		}
		map.put("meetingStatusStr",DataListUtils.getMeetingStatusNameById(model.getMeetingStatus()+""));//解释预订状态字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		meetingOrderMapper.deleteByPrimaryKey(id);
	}
}
