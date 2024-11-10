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
public class RoomMsgServiceImpl implements RoomMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	RoomMsgMapper roomMsgMapper;
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(RoomMsg model,LoginModel login){
		if(model.getRoomNo()==null||model.getRoomNo().equals("")){
			return "会议室编号为必填属性";
		}
		if(model.getRoomNo()!=null){
			RoomMsgExample te=new RoomMsgExample();
			RoomMsgExample.Criteria tc=te.createCriteria();
			tc.andRoomNoEqualTo(model.getRoomNo());
			int count = (int)roomMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 会议室编号 ,请重新填写";
			}
		}
		if(model.getRoomType()==null){
			return "会议室类型为必填属性";
		}
		if(model.getRaddress()==null||model.getRaddress().equals("")){
			return "会议室地址为必填属性";
		}
		if(model.getRhyssb()==null||model.getRhyssb().equals("")){
			return "会议室设备为必填属性";
		}
		if(model.getNum()==null){
			return "容纳人数为必填属性";
		}
		roomMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(RoomMsg model,LoginModel login){
		RoomMsg preModel = roomMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getRoomNo()==null||model.getRoomNo().equals("")){
			return "会议室编号为必填属性";
		}
		if(model.getRoomNo()!=null){
			RoomMsgExample te=new RoomMsgExample();
			RoomMsgExample.Criteria tc=te.createCriteria();
			tc.andRoomNoEqualTo(model.getRoomNo());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)roomMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 会议室编号 ,请重新填写";
			}
		}
		if(model.getRoomType()==null){
			return "会议室类型为必填属性";
		}
		if(model.getRaddress()==null||model.getRaddress().equals("")){
			return "会议室地址为必填属性";
		}
		if(model.getRhyssb()==null||model.getRhyssb().equals("")){
			return "会议室设备为必填属性";
		}
		if(model.getNum()==null){
			return "容纳人数为必填属性";
		}
		preModel.setRoomNo(model.getRoomNo());
		preModel.setRoomType(model.getRoomType());
		preModel.setRaddress(model.getRaddress());
		preModel.setRhyssb(model.getRhyssb());
		preModel.setNum(model.getNum());
		roomMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询会议室列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(RoomMsg queryModel,Integer pageSize,LoginModel login) {
		RoomMsgExample se = new RoomMsgExample();
		RoomMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getRoomNo()!=null&&queryModel.getRoomNo().equals("")==false){
			sc.andRoomNoLike("%"+queryModel.getRoomNo()+"%");//模糊查询
		}
		if(queryModel.getRoomType()!=null){
			sc.andRoomTypeEqualTo(queryModel.getRoomType());//查询会议室类型等于指定值
		}
		if(login.getLoginType()==2) {
			UserMsg user = userMsgMapper.selectByPrimaryKey(login.getId());
			if(user.getUserType()==2) {
				sc.andRoomTypeEqualTo(3);
			}
		}
		int count = (int)roomMsgMapper.countByExample(se);
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
	*根据参数查询会议室列表数据
	*/
	@Override
	public Map<String,Object> getDataList(RoomMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		RoomMsgExample se = new RoomMsgExample();
		RoomMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getRoomNo()!=null&&queryModel.getRoomNo().equals("")==false){
			sc.andRoomNoLike("%"+queryModel.getRoomNo()+"%");//模糊查询
		}
		if(queryModel.getRoomType()!=null){
			sc.andRoomTypeEqualTo(queryModel.getRoomType());//查询会议室类型等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		if(login.getLoginType()==2) {
			UserMsg user = userMsgMapper.selectByPrimaryKey(login.getId());
			if(user.getUserType()==2) {
				sc.andRoomTypeEqualTo(3);
			}
		}
		List<RoomMsg> list = roomMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(RoomMsg model:list){
			list2.add(getRoomMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装会议室为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getRoomMsgModel(RoomMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomMsg",model);
		map.put("roomTypeStr",DataListUtils.getRoomTypeNameById(model.getRoomType()+""));//解释会议室类型字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		roomMsgMapper.deleteByPrimaryKey(id);
	}
}
