package com.meeting.model;
public class SignLog {
	private Integer id;//ID
	private Integer meetingId;//会议
	private Integer userId;//签到用户
	private String signTime;//签到时间
	private Integer memberId;//参会id
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getMeetingId(){
		return meetingId;
	}
	public void setMeetingId(Integer meetingId){
		this.meetingId = meetingId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public String getSignTime(){
		return signTime;
	}
	public void setSignTime(String signTime){
		this.signTime = signTime == null ? null : signTime.trim();
	}
	public Integer getMemberId(){
		return memberId;
	}
	public void setMemberId(Integer memberId){
		this.memberId = memberId;
	}
}
