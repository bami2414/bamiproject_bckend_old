package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.StoreContent;
import com.example.bami.model.StoreContentDetails;
import com.example.bami.service.DbConnection;

public class StoreContentDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public StoreContentDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<StoreContent> getStoreContentByStoreId(int storeId) throws Exception {
		ArrayList<StoreContent> list = new ArrayList<StoreContent>();
		String querry = "select * from StoreContents where storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreContent storeContent = new StoreContent();
			storeContent.setStoreId(rs.getInt("storeId"));
			storeContent.setBrandId(rs.getInt("brandId"));
			storeContent.setItemId(rs.getInt("itemId"));
			storeContent.setStartPrice(rs.getInt("startPrice"));
			storeContent.setEndPrice(rs.getInt("endPrice"));
			list.add(storeContent);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<StoreContentDetails> getStoreContentDetailsByStoreId(int storeId) throws Exception {
		ArrayList<StoreContentDetails> list = new ArrayList<StoreContentDetails>();
		String querry = "select i.itemName,i.gender,s.startPrice,s.endPrice from Items i join StoreContents s on "
						+ "i.itemId = s.itemId where s.storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreContentDetails storeContentDetails = new StoreContentDetails();
			storeContentDetails.setItemName(rs.getString("itemName"));
			storeContentDetails.setGender(rs.getString("gender"));
			storeContentDetails.setStartPrice(rs.getInt("startPrice"));
			storeContentDetails.setEndPrice(rs.getInt("endPrice"));
			list.add(storeContentDetails);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
}
