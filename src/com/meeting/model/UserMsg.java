package com.meeting.model;
public class UserMsg {
	private Integer id;//ID
	private String loginName;//登录名
	private String password;//密码
	private String realName;//姓名
	private String celPhone;//联系电话
	private String email;//邮箱
	private Integer sex;//性别
	private String createTime;//创建时间
	private Integer userType;//用户类型
	private Integer departId;//所属部门
	private String jobName;//职位名
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName == null ? null : loginName.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelPhone(){
		return celPhone;
	}
	public void setCelPhone(String celPhone){
		this.celPhone = celPhone == null ? null : celPhone.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public String getCreateTime(){
		return createTime;
	}
	public void setCreateTime(String createTime){
		this.createTime = createTime == null ? null : createTime.trim();
	}
	public Integer getUserType(){
		return userType;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Integer getDepartId(){
		return departId;
	}
	public void setDepartId(Integer departId){
		this.departId = departId;
	}
	public String getJobName(){
		return jobName;
	}
	public void setJobName(String jobName){
		this.jobName = jobName == null ? null : jobName.trim();
	}
}
