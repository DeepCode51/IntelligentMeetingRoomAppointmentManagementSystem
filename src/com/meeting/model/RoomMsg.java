package com.meeting.model;
public class RoomMsg {
	private Integer id;//ID
	private String roomNo;//会议室编号
	private String raddress;//会议室地址
	private String rhyssb;//会议室设备
	private Integer roomType;//会议室类型
	private Integer num;//容纳人数
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getRoomNo(){
		return roomNo;
	}
	public void setRoomNo(String roomNo){
		this.roomNo = roomNo == null ? null : roomNo.trim();
	}
	public String getRaddress(){
		return raddress;
	}
	public void setRaddress(String raddress){
		this.raddress = raddress == null ? null : raddress.trim();
	}
	public String getRhyssb(){
		return rhyssb;
	}
	public void setRhyssb(String rhyssb){
		this.rhyssb = rhyssb == null ? null : rhyssb.trim();
	}
	public Integer getRoomType(){
		return roomType;
	}
	public void setRoomType(Integer roomType){
		this.roomType = roomType;
	}
	public Integer getNum(){
		return num;
	}
	public void setNum(Integer num){
		this.num = num;
	}
}
