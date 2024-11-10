package com.meeting.dao;
import com.meeting.model.RoomMsg;
import com.meeting.model.RoomMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface RoomMsgMapper {
	long countByExample(RoomMsgExample example);
	int deleteByExample(RoomMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(RoomMsg record);
	int insertSelective(RoomMsg record);
	List<RoomMsg> selectByExample(RoomMsgExample example);
	RoomMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") RoomMsg record, @Param("example") RoomMsgExample example);
	int updateByExample(@Param("record") RoomMsg record, @Param("example") RoomMsgExample example);
	int updateByPrimaryKeySelective(RoomMsg record);
	int updateByPrimaryKey(RoomMsg record);
}
