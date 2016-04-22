package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.Item;
import com.example.bami.service.DbConnection;

public class ItemDao {

	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public ItemDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<Item> getAllItems() throws Exception {
		ArrayList<Item> list = new ArrayList<Item>();
		String querry = "select * from Items;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Item item = new Item();
			item.setItemId(rs.getInt("itemId"));
			item.setItemName(rs.getString("itemName"));
			item.setGender(rs.getString("gender"));
			list.add(item);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public Item getItemByItemId(int itemId) throws Exception {
		Item item = new Item();
		String querry = "select * from Items where itemId = " + itemId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			item.setItemId(rs.getInt("itemId"));
			item.setItemName(rs.getString("itemName"));
			item.setGender(rs.getString("gender"));
		}
		rs.close();
		dbConnection.closeConnection();
		return item;
	}
	
}
