package com.meeting.dao;
import com.meeting.model.AdminMsg;
import com.meeting.model.AdminMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface AdminMsgMapper {
	long countByExample(AdminMsgExample example);
	int deleteByExample(AdminMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(AdminMsg record);
	int insertSelective(AdminMsg record);
	List<AdminMsg> selectByExample(AdminMsgExample example);
	AdminMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") AdminMsg record, @Param("example") AdminMsgExample example);
	int updateByExample(@Param("record") AdminMsg record, @Param("example") AdminMsgExample example);
	int updateByPrimaryKeySelective(AdminMsg record);
	int updateByPrimaryKey(AdminMsg record);
}
