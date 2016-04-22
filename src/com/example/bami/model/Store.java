package com.example.bami.model;

import java.util.Date;

public class Store implements Comparable<Store>{

	private int storeId;
	private String storeName;
	private String offer;
	private Date startDate;
	private Date endDate;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public int compareTo(Store o) {
		// TODO Auto-generated method stub
		return this.storeId-o.storeId;
	}
	
}
