package com.meeting.model;
public class NoticeMsg {
	private Integer id;//ID
	private String noticeName;//标题
	private String noticeDetail;//公告详情
	private String createTime;//创建时间
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getNoticeName(){
		return noticeName;
	}
	public void setNoticeName(String noticeName){
		this.noticeName = noticeName == null ? null : noticeName.trim();
	}
	public String getNoticeDetail(){
		return noticeDetail;
	}
	public void setNoticeDetail(String noticeDetail){
		this.noticeDetail = noticeDetail == null ? null : noticeDetail.trim();
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
}
