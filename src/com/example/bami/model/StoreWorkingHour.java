package com.example.bami.model;

public class StoreWorkingHour {

	private int storeId;
	private String opnTime;
	private String clsTime;
	private String offDay;
	
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getOpnTime() {
		return opnTime;
	}
	public void setOpnTime(String opnTime) {
		this.opnTime = opnTime;
	}
	public String getClsTime() {
		return clsTime;
	}
	public void setClsTime(String clsTime) {
		this.clsTime = clsTime;
	}
	public String getOffDay() {
		return offDay;
	}
	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	
}
