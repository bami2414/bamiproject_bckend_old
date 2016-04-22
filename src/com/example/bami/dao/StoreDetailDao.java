package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.StoreDetail;
import com.example.bami.service.DbConnection;

public class StoreDetailDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public StoreDetailDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<StoreDetail> getAllStoreDetails() throws Exception {
		ArrayList<StoreDetail> list = new ArrayList<StoreDetail>();
		String querry = "select * from StoreDetails;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreDetail storeDetail = new StoreDetail();
			storeDetail.setStoreId(rs.getInt("storeId"));
			storeDetail.setStoreName(rs.getString("storeName"));
			storeDetail.setStoreType(rs.getString("storeType"));
			list.add(storeDetail);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public StoreDetail getStoreDetailByStoreId(int storeId) throws Exception {
		StoreDetail storeDetail = new StoreDetail();
		String querry = "select * from StoreDetails where storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			storeDetail.setStoreId(rs.getInt("storeId"));
			storeDetail.setStoreName(rs.getString("storeName"));
			storeDetail.setStoreType(rs.getString("storeType"));
		}
		rs.close();
		dbConnection.closeConnection();
		return storeDetail;
	}
	
}
