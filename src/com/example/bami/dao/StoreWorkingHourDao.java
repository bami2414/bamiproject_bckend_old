package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.StoreWorkingHour;
import com.example.bami.service.DbConnection;

public class StoreWorkingHourDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public StoreWorkingHourDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<StoreWorkingHour> getAllStoreWorkingHours() throws Exception {
		ArrayList<StoreWorkingHour> list = new ArrayList<StoreWorkingHour>();
		String querry = "select * from StoreWorkingHours;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreWorkingHour storeWorkingHour = new StoreWorkingHour();
			storeWorkingHour.setClsTime(rs.getString("clsTime"));
			storeWorkingHour.setOffDay(rs.getString("offDay"));
			storeWorkingHour.setOpnTime(rs.getString("opnTime"));
			storeWorkingHour.setStoreId(rs.getInt("storeId"));
			list.add(storeWorkingHour);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public StoreWorkingHour getStoreWorkingHourByStoreId(int storeId) throws Exception {
		StoreWorkingHour storeWorkingHour = new StoreWorkingHour();
		String querry = "select * from StoreWorkingHours where storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			storeWorkingHour.setClsTime(rs.getString("clsTime"));
			storeWorkingHour.setOffDay(rs.getString("offDay"));
			storeWorkingHour.setOpnTime(rs.getString("opnTime"));
			storeWorkingHour.setStoreId(rs.getInt("storeId"));
		}
		rs.close();
		dbConnection.closeConnection();
		return storeWorkingHour;
	}
}
