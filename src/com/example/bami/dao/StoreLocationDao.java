package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.StoreLocation;
import com.example.bami.model.StoreLocationLatLon;
import com.example.bami.service.DbConnection;

public class StoreLocationDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public StoreLocationDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<StoreLocation> getAllStoreLocations() throws Exception {
		ArrayList<StoreLocation> list = new ArrayList<StoreLocation>();
		String querry = "select * from StoreLocations;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreLocation storeLocation = new StoreLocation();
			storeLocation.setCity(rs.getString("city"));
			storeLocation.setCountry(rs.getString("country"));
			storeLocation.setLat(rs.getDouble("lat"));
			storeLocation.setLon(rs.getDouble("lon"));
			storeLocation.setLine1(rs.getString("line1"));
			storeLocation.setLine2(rs.getString("line2"));
			storeLocation.setPincode(rs.getInt("pincode"));
			storeLocation.setShopNo(rs.getString("shopNo"));
			storeLocation.setState(rs.getString("state"));
			storeLocation.setStoreId(rs.getInt("storeId"));
			list.add(storeLocation);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public StoreLocation getStoreLocationByStoreId(int storeId) throws Exception {
		StoreLocation storeLocation = new StoreLocation();
		String querry = "select * from StoreLocations where storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			storeLocation.setCity(rs.getString("city"));
			storeLocation.setCountry(rs.getString("country"));
			storeLocation.setLat(rs.getDouble("lat"));
			storeLocation.setLon(rs.getDouble("lon"));
			storeLocation.setLine1(rs.getString("line1"));
			storeLocation.setLine2(rs.getString("line2"));
			storeLocation.setPincode(rs.getInt("pincode"));
			storeLocation.setShopNo(rs.getString("shopNo"));
			storeLocation.setState(rs.getString("state"));
			storeLocation.setStoreId(rs.getInt("storeId"));
		}
		rs.close();
		dbConnection.closeConnection();
		return storeLocation;
	}
	
	public ArrayList<StoreLocationLatLon> getStoreLocationWithLatLon() throws Exception {
		ArrayList<StoreLocationLatLon> list = new ArrayList<StoreLocationLatLon>();
		String querry = "select storeId,lat,lon from StoreLocations;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreLocationLatLon storeLocationLatLon = new StoreLocationLatLon();
			storeLocationLatLon.setStoreId(rs.getInt("storeId"));
			storeLocationLatLon.setLat(rs.getDouble("lat"));
			storeLocationLatLon.setLon(rs.getDouble("lon"));
			list.add(storeLocationLatLon);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
}
