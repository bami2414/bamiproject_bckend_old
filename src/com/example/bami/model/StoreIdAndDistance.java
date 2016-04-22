package com.example.bami.model;

public class StoreIdAndDistance implements Comparable<StoreIdAndDistance>{

	private int storeId;
	private double distance;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	@Override
	public int compareTo(StoreIdAndDistance s) {
		// TODO Auto-generated method stub
		int res = 0;
		if(this.distance-s.distance > 0)
			res = 1;
		else
			res = -1;
		return res;
	}
}
