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
public class NoticeMsgServiceImpl implements NoticeMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	NoticeMsgMapper noticeMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(NoticeMsg model,LoginModel login){
		if(model.getNoticeName()==null||model.getNoticeName().equals("")){
			return "标题为必填属性";
		}
		if(model.getNoticeDetail()==null||model.getNoticeDetail().equals("")){
			return "公告详情为必填属性";
		}
		model.setCreateTime(sdf1.format(new Date()));//当前时间格式
		noticeMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(NoticeMsg model,LoginModel login){
		NoticeMsg preModel = noticeMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getNoticeName()==null||model.getNoticeName().equals("")){
			return "标题为必填属性";
		}
		if(model.getNoticeDetail()==null||model.getNoticeDetail().equals("")){
			return "公告详情为必填属性";
		}
		preModel.setNoticeName(model.getNoticeName());
		preModel.setNoticeDetail(model.getNoticeDetail());
		noticeMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询公告列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(NoticeMsg queryModel,Integer pageSize,LoginModel login) {
		NoticeMsgExample se = new NoticeMsgExample();
		NoticeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getNoticeName()!=null&&queryModel.getNoticeName().equals("")==false){
			sc.andNoticeNameLike("%"+queryModel.getNoticeName()+"%");//模糊查询
		}
		int count = (int)noticeMsgMapper.countByExample(se);
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
	*根据参数查询公告列表数据
	*/
	@Override
	public Map<String,Object> getDataList(NoticeMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		NoticeMsgExample se = new NoticeMsgExample();
		NoticeMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getNoticeName()!=null&&queryModel.getNoticeName().equals("")==false){
			sc.andNoticeNameLike("%"+queryModel.getNoticeName()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<NoticeMsg> list = noticeMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(NoticeMsg model:list){
			list2.add(getNoticeMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装公告为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getNoticeMsgModel(NoticeMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("noticeMsg",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		noticeMsgMapper.deleteByPrimaryKey(id);
	}
}
