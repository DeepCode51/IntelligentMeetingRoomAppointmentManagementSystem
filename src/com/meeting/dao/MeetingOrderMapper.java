package com.meeting.dao;
import com.meeting.model.MeetingOrder;
import com.meeting.model.MeetingOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface MeetingOrderMapper {
	long countByExample(MeetingOrderExample example);
	int deleteByExample(MeetingOrderExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(MeetingOrder record);
	int insertSelective(MeetingOrder record);
	List<MeetingOrder> selectByExample(MeetingOrderExample example);
	MeetingOrder selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") MeetingOrder record, @Param("example") MeetingOrderExample example);
	int updateByExample(@Param("record") MeetingOrder record, @Param("example") MeetingOrderExample example);
	int updateByPrimaryKeySelective(MeetingOrder record);
	int updateByPrimaryKey(MeetingOrder record);
}
