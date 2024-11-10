package com.meeting.model;
public class Member {
	private Integer id;//ID
	private Integer stafId;//参会用户
	private String realName;//姓名
	private String celphone;//联系电话
	private String email;//联系邮箱
	private String remark;//备注
	private String createTime;//创建时间
	private Integer meetingId;//参与会议
	private String title;//会议主题
	private String startTime;//开始时间
	private String endTime;//结束时间
	private Integer roomId;//会议室
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getStafId(){
		return stafId;
	}
	public void setStafId(Integer stafId){
		this.stafId = stafId;
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelphone(){
		return celphone;
	}
	public void setCelphone(String celphone){
		this.celphone = celphone == null ? null : celphone.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark == null ? null : remark.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Integer getMeetingId(){
		return meetingId;
	}
	public void setMeetingId(Integer meetingId){
		this.meetingId = meetingId;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title == null ? null : title.trim();
	}
	public String getStartTime(){
		return startTime;
	}
	public void setStartTime(String startTime){
		this.startTime = startTime == null ? null : startTime.trim();
	}
	public String getEndTime(){
		return endTime;
	}
	public void setEndTime(String endTime){
		this.endTime = endTime == null ? null : endTime.trim();
	}
	public Integer getRoomId(){
		return roomId;
	}
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
}
