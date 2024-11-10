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
public class FileShareServiceImpl implements FileShareService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	FileShareMapper fileShareMapper;
	/**
	新增
	*/
	@Override
	public String add(FileShare model,LoginModel login){
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getFintro()==null||model.getFintro().equals("")){
			return "文件介绍为必填属性";
		}
		if(model.getFileUrl()==null||model.getFileUrl().equals("")){
			return "文件链接为必填属性";
		}
		if(model.getFileUrl()!=null){
			String [] fileSplit = model.getFileUrl().split(";");
			if(fileSplit.length>1){
				return "文件链接的文件数量不能大于1";
			}
		}
		model.setCreateDate(sdf2.format(new Date()));//当前日期格式
		fileShareMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(FileShare model,LoginModel login){
		FileShare preModel = fileShareMapper.selectByPrimaryKey(model.getId());
		if(model.getTitle()==null||model.getTitle().equals("")){
			return "标题为必填属性";
		}
		if(model.getFintro()==null||model.getFintro().equals("")){
			return "文件介绍为必填属性";
		}
		if(model.getFileUrl()==null||model.getFileUrl().equals("")){
			return "文件链接为必填属性";
		}
		if(model.getFileUrl()!=null){
			String [] fileSplit = model.getFileUrl().split(";");
			if(fileSplit.length>1){
				return "文件链接的文件数量不能大于1";
			}
		}
		preModel.setTitle(model.getTitle());
		preModel.setFintro(model.getFintro());
		preModel.setFileUrl(model.getFileUrl());
		fileShareMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询共享文件列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(FileShare queryModel,Integer pageSize,LoginModel login) {
		FileShareExample se = new FileShareExample();
		FileShareExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		int count = (int)fileShareMapper.countByExample(se);
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
	*根据参数查询共享文件列表数据
	*/
	@Override
	public Map<String,Object> getDataList(FileShare queryModel,Integer page,Integer pageSize,LoginModel login) {
		FileShareExample se = new FileShareExample();
		FileShareExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getId()!=null){
			sc.andIdEqualTo(queryModel.getId());
		}
		if(queryModel.getTitle()!=null&&queryModel.getTitle().equals("")==false){
			sc.andTitleLike("%"+queryModel.getTitle()+"%");//模糊查询
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<FileShare> list = fileShareMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(FileShare model:list){
			list2.add(getFileShareModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装共享文件为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getFileShareModel(FileShare model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("fileShare",model);
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		fileShareMapper.deleteByPrimaryKey(id);
	}
}
