package com.meeting.model;
public class FileShare {
	private Integer id;//ID
	private String title;//标题
	private String fintro;//文件介绍
	private String fileUrl;//文件链接
	private String createDate;//上传日期
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
	public String getFintro(){
		return fintro;
	}
	public void setFintro(String fintro){
		this.fintro = fintro == null ? null : fintro.trim();
	}
	public String getFileUrl(){
		return fileUrl;
	}
	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl == null ? null : fileUrl.trim();
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}
