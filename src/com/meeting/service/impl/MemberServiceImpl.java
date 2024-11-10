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
public class MemberServiceImpl implements MemberService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	MeetingOrderMapper meetingOrderMapper;
	@Autowired
	MemberMapper memberMapper;
	/**
	新增
	*/
	@Override
	public String add(Member model,LoginModel login){
		if(model.getStafId()==null){
			return "参会用户为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		UserMsg stafIdT = userMsgMapper.selectByPrimaryKey(model.getStafId());//查询用户
		MeetingOrder meetingIdT = meetingOrderMapper.selectByPrimaryKey(model.getMeetingId());//查询会议室预订
		if(stafIdT!=null){
			model.setRealName(stafIdT.getRealName());//赋值stafIdT的姓名
		}
		if(stafIdT!=null){
			model.setCelphone(stafIdT.getCelPhone());//赋值stafIdT的联系电话
		}
		if(stafIdT!=null){
			model.setEmail(stafIdT.getEmail());//赋值stafIdT的邮箱
		}
		if(meetingIdT!=null){
			model.setStartTime(meetingIdT.getEndTime());//赋值meetingIdT的结束时间
		}
		if(meetingIdT!=null){
			model.setEndTime(meetingIdT.getEndTime());//赋值meetingIdT的结束时间
		}
		if(meetingIdT!=null){
			model.setRoomId(meetingIdT.getRid());//赋值meetingIdT的会议室
		}
		model.setTitle(meetingIdT.getTitle());
		memberMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(Member model,LoginModel login){
		Member preModel = memberMapper.selectByPrimaryKey(model.getId());
		if(model.getStafId()==null){
			return "参会用户为必填属性";
		}
		preModel.setStafId(model.getStafId());
		preModel.setRemark(model.getRemark());
		UserMsg stafIdT = userMsgMapper.selectByPrimaryKey(model.getStafId());//查询用户
		MeetingOrder meetingIdT = meetingOrderMapper.selectByPrimaryKey(model.getMeetingId());//查询会议室预订
		if(stafIdT!=null){
			preModel.setRealName(stafIdT.getRealName());//赋值stafIdT的姓名
		}
		if(stafIdT!=null){
			preModel.setCelphone(stafIdT.getCelPhone());//赋值stafIdT的联系电话
		}
		if(stafIdT!=null){
			preModel.setEmail(stafIdT.getEmail());//赋值stafIdT的邮箱
		}
		if(meetingIdT!=null){
			preModel.setStartTime(meetingIdT.getEndTime());//赋值meetingIdT的结束时间
		}
		if(meetingIdT!=null){
			preModel.setEndTime(meetingIdT.getEndTime());//赋值meetingIdT的结束时间
		}
		if(meetingIdT!=null){
			preModel.setRoomId(meetingIdT.getRid());//赋值meetingIdT的会议室
		}
		memberMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询参会人员列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(Member queryModel,Integer pageSize,LoginModel login) {
		MemberExample se = new MemberExample();
		MemberExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getMeetingId()!=null){
			sc.andMeetingIdEqualTo(queryModel.getMeetingId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		
		if(queryModel.getMeetingId()==null&&login.getLoginType()==2) {
			sc.andStafIdEqualTo(login.getId());
		}
		
		int count = (int)memberMapper.countByExample(se);
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
	*根据参数查询参会人员列表数据
	*/
	@Override
	public Map<String,Object> getDataList(Member queryModel,Integer page,Integer pageSize,LoginModel login) {
		MemberExample se = new MemberExample();
		MemberExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getMeetingId()!=null){
			sc.andMeetingIdEqualTo(queryModel.getMeetingId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		
		if(queryModel.getMeetingId()==null&&login.getLoginType()==2) {
			sc.andStafIdEqualTo(login.getId());
		}
		List<Member> list = memberMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(Member model:list){
			list2.add(getMemberModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装参会人员为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getMemberModel(Member model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("member",model);
		if(model.getStafId()!=null){
			UserMsg userMsg = userMsgMapper.selectByPrimaryKey(model.getStafId());//参会用户为外接字段，需要关联用户来解释该字段
			if(userMsg!=null){
				map.put("stafIdStr",userMsg.getLoginName());
			}
		}
		int isSign =0;
		int canUpdate = 0;
		if(model.getMeetingId()!=null){
			MeetingOrder meetingOrder = meetingOrderMapper.selectByPrimaryKey(model.getMeetingId());//参与会议为外接字段，需要关联会议室预订来解释该字段
			if(meetingOrder!=null){
				map.put("meetingIdStr",meetingOrder.getTitle());
				if(meetingOrder.getMeetingStatus()==4&&model.getStafId().equals(login.getId())) {
					isSign=1;
				}
				
				if(meetingOrder.getUid().equals(login.getId())) {
					canUpdate=1;
				}
				
			}
		}
		if(model.getRoomId()!=null){
			RoomMsg roomMsg = roomMsgMapper.selectByPrimaryKey(model.getRoomId());//会议室为外接字段，需要关联会议室来解释该字段
			if(roomMsg!=null){
				map.put("roomIdStr",roomMsg.getRoomNo());
			}
		}
		map.put("isSign",isSign);
		map.put("canUpdate",canUpdate);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		memberMapper.deleteByPrimaryKey(id);
	}
}
