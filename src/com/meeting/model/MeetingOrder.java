package com.meeting.model;
public class MeetingOrder {
	private Integer id;//ID
	private String title;//会议主题
	private Integer uid;//预订用户
	private Integer udepartId;//所属部门
	private Integer rid;//会议室
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String usingIntro;//用途
	private Integer meetingStatus;//预订状态
	private String createTime;//创建时间
	private Double totalHours;//总时长
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title == null ? null : title.trim();
	}
	public Integer getUid(){
		return uid;
	}
	public void setUid(Integer uid){
		this.uid = uid;
	}
	public Integer getUdepartId(){
		return udepartId;
	}
	public void setUdepartId(Integer udepartId){
		this.udepartId = udepartId;
	}
	public Integer getRid(){
		return rid;
	}
	public void setRid(Integer rid){
		this.rid = rid;
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
	public String getUsingIntro(){
		return usingIntro;
	}
	public void setUsingIntro(String usingIntro){
		this.usingIntro = usingIntro == null ? null : usingIntro.trim();
	}
	public Integer getMeetingStatus(){
		return meetingStatus;
	}
	public void setMeetingStatus(Integer meetingStatus){
		this.meetingStatus = meetingStatus;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Double getTotalHours(){
		return totalHours;
	}
	public void setTotalHours(Double totalHours){
		this.totalHours = totalHours;
	}
}
