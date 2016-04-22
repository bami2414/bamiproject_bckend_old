package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.BrandAndStore;
import com.example.bami.service.DbConnection;

public class BrandAndStoreDao {
	
	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public BrandAndStoreDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<BrandAndStore> getAllBrandAndStore() throws Exception {
		ArrayList<BrandAndStore> list = new ArrayList<BrandAndStore>();
		String querry = "select * from Brands;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			BrandAndStore brandAndStore = new BrandAndStore();
			brandAndStore.setId(rs.getInt("brandId"));
			brandAndStore.setName(rs.getString("brandName"));
			brandAndStore.setType("B");
			list.add(brandAndStore);
		}
		rs.close();
		querry = "select * from StoreDetails;";
		rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			BrandAndStore brandAndStore = new BrandAndStore();
			brandAndStore.setId(rs.getInt("storeId"));
			brandAndStore.setName(rs.getString("storeName"));
			brandAndStore.setType("S");
			list.add(brandAndStore);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
}
