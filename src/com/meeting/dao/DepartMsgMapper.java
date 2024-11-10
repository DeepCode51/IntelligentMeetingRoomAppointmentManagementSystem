package com.meeting.dao;
import com.meeting.model.DepartMsg;
import com.meeting.model.DepartMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface DepartMsgMapper {
	long countByExample(DepartMsgExample example);
	int deleteByExample(DepartMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(DepartMsg record);
	int insertSelective(DepartMsg record);
	List<DepartMsg> selectByExample(DepartMsgExample example);
	DepartMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") DepartMsg record, @Param("example") DepartMsgExample example);
	int updateByExample(@Param("record") DepartMsg record, @Param("example") DepartMsgExample example);
	int updateByPrimaryKeySelective(DepartMsg record);
	int updateByPrimaryKey(DepartMsg record);
}
