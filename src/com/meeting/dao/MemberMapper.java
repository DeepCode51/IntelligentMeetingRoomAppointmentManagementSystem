package com.meeting.dao;
import com.meeting.model.Member;
import com.meeting.model.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface MemberMapper {
	long countByExample(MemberExample example);
	int deleteByExample(MemberExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Member record);
	int insertSelective(Member record);
	List<Member> selectByExample(MemberExample example);
	Member selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);
	int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);
	int updateByPrimaryKeySelective(Member record);
	int updateByPrimaryKey(Member record);
}
