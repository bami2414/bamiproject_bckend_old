package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.Store;
import com.example.bami.model.StoreDetails;
import com.example.bami.service.DbConnection;

public class StoreDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public StoreDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<Store> getAllStores() throws Exception {
		ArrayList<Store> list = new ArrayList<Store>();
		String querry = "select s.storeId,s.storeName,o.offer,o.startDate,o.endDate from StoreDetails s join "
				+ "Offers o on s.storeId = o.storeId;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Store store = new Store();
			store.setStoreName(rs.getString("storeName"));
			store.setOffer(rs.getString("offer"));
			store.setStoreId(rs.getInt("storeId"));
			store.setStartDate(rs.getTimestamp("startDate"));
			store.setEndDate(rs.getTimestamp("endDate"));
			list.add(store);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<Store> getStoreBySize(int size) throws Exception {
		ArrayList<Store> list = new ArrayList<Store>();
		String querry = "select s.storeId,s.storeName,o.offer,o.startDate,o.endDate from StoreDetails s join "
				+ "Offers o on s.storeId = o.storeId limit " + size + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Store store = new Store();
			store.setStoreName(rs.getString("storeName"));
			store.setOffer(rs.getString("offer"));
			store.setStoreId(rs.getInt("storeId"));
			store.setStartDate(rs.getTimestamp("startDate"));
			store.setEndDate(rs.getTimestamp("endDate"));
			list.add(store);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<Store> getPopularStores() throws Exception {
		ArrayList<Store> list = new ArrayList<Store>();
		String querry = "select s.storeId,s.storeName,o.offer,o.startDate,o.endDate from StoreDetails s join "
				+ "Offers o on s.storeId = o.storeId join PopularStoresId p "
				+ "on p.storeId = o.storeId;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Store store = new Store();
			store.setStoreName(rs.getString("storeName"));
			store.setOffer(rs.getString("offer"));
			store.setStoreId(rs.getInt("storeId"));
			store.setStartDate(rs.getTimestamp("startDate"));
			store.setEndDate(rs.getTimestamp("endDate"));
			list.add(store);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<StoreDetails> getStoreDetailsByBrandId(int brandId) throws Exception {
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		String querry = "select s.storeId,s.storeName,o.offer,o.startDate,o.endDate,a.line1,a.line2,a.shopNo,a.city "
				+ "from StoreDetails s join Offers o on s.storeId = o.storeId join StoreLocations a on a.storeId = o.storeId where o.brandId = "
				+ brandId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreDetails storeDetails = new StoreDetails();
			storeDetails.setStoreId(rs.getInt("storeId"));
			storeDetails.setStoreName(rs.getString("storeName"));
			storeDetails.setOffer(rs.getString("offer"));
			storeDetails.setStartDate(rs.getTimestamp("startDate"));
			storeDetails.setEndDate(rs.getTimestamp("endDate"));
			storeDetails.setLine1(rs.getString("line1"));
			storeDetails.setLine2(rs.getString("line2"));
			storeDetails.setShopNo(rs.getString("shopNo"));
			storeDetails.setCity(rs.getString("city"));
			list.add(storeDetails);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<StoreDetails> getAllStoreDetails() throws Exception {
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		String querry = "select s.storeId,s.storeName,o.offer,o.startDate,o.endDate,a.line1,a.line2,a.shopNo,a.city "
				+ "from StoreDetails s join Offers o on s.storeId = o.storeId join StoreLocations a on a.storeId = o.storeId;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			StoreDetails storeDetails = new StoreDetails();
			storeDetails.setStoreId(rs.getInt("storeId"));
			storeDetails.setStoreName(rs.getString("storeName"));
			storeDetails.setOffer(rs.getString("offer"));
			storeDetails.setStartDate(rs.getTimestamp("startDate"));
			storeDetails.setEndDate(rs.getTimestamp("endDate"));
			storeDetails.setLine1(rs.getString("line1"));
			storeDetails.setLine2(rs.getString("line2"));
			storeDetails.setShopNo(rs.getString("shopNo"));
			storeDetails.setCity(rs.getString("city"));
			list.add(storeDetails);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}

	
}
