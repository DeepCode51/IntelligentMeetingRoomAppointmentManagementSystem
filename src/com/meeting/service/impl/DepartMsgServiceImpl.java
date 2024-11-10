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
public class DepartMsgServiceImpl implements DepartMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	DepartMsgMapper departMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(DepartMsg model,LoginModel login){
		if(model.getDname()==null||model.getDname().equals("")){
			return "部门名为必填属性";
		}
		departMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(DepartMsg model,LoginModel login){
		DepartMsg preModel = departMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getDname()==null||model.getDname().equals("")){
			return "部门名为必填属性";
		}
		preModel.setDname(model.getDname());
		departMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询部门列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(DepartMsg queryModel,Integer pageSize,LoginModel login) {
		DepartMsgExample se = new DepartMsgExample();
		DepartMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDname()!=null&&queryModel.getDname().equals("")==false){
			sc.andDnameLike("%"+queryModel.getDname()+"%");//模糊查询
		}
		int count = (int)departMsgMapper.countByExample(se);
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
	*根据参数查询部门列表数据
	*/
	@Override
	public Map<String,Object> getDataList(DepartMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		DepartMsgExample se = new DepartMsgExample();
		DepartMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getDname()!=null&&queryModel.getDname().equals("")==false){
			sc.andDnameLike("%"+queryModel.getDname()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<DepartMsg> list = departMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(DepartMsg model:list){
			list2.add(getDepartMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装部门为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getDepartMsgModel(DepartMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("departMsg",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		departMsgMapper.deleteByPrimaryKey(id);
	}
}
