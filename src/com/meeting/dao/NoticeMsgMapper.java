package com.meeting.dao;
import com.meeting.model.NoticeMsg;
import com.meeting.model.NoticeMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface NoticeMsgMapper {
	long countByExample(NoticeMsgExample example);
	int deleteByExample(NoticeMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(NoticeMsg record);
	int insertSelective(NoticeMsg record);
	List<NoticeMsg> selectByExample(NoticeMsgExample example);
	NoticeMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") NoticeMsg record, @Param("example") NoticeMsgExample example);
	int updateByExample(@Param("record") NoticeMsg record, @Param("example") NoticeMsgExample example);
	int updateByPrimaryKeySelective(NoticeMsg record);
	int updateByPrimaryKey(NoticeMsg record);
}
