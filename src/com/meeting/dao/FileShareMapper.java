package com.meeting.dao;
import com.meeting.model.FileShare;
import com.meeting.model.FileShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface FileShareMapper {
	long countByExample(FileShareExample example);
	int deleteByExample(FileShareExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(FileShare record);
	int insertSelective(FileShare record);
	List<FileShare> selectByExample(FileShareExample example);
	FileShare selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") FileShare record, @Param("example") FileShareExample example);
	int updateByExample(@Param("record") FileShare record, @Param("example") FileShareExample example);
	int updateByPrimaryKeySelective(FileShare record);
	int updateByPrimaryKey(FileShare record);
}
