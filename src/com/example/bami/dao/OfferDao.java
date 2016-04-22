package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.Offer;
import com.example.bami.service.DbConnection;

public class OfferDao {
	
	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public OfferDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<Offer> getAllOffers() throws Exception {
		ArrayList<Offer> list = new ArrayList<Offer>();
		String querry = "select * from Offers;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Offer offer = new Offer();
			offer.setBrandId(rs.getInt("brandId"));
			offer.setStoreId(rs.getInt("storeId"));
			offer.setOffer(rs.getString("offer"));
			offer.setCondAply(rs.getString("condAply"));
			offer.setStartDate(rs.getTimestamp("startDate"));
			offer.setEndDate(rs.getTimestamp("endDate"));
			list.add(offer);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public Offer getOfferByStoreIdAndBrandId(int storeId, int brandId) throws Exception {
		Offer offer = new Offer();
		String querry = "select * from Offers where storeId = " + storeId + " and brandId = " + brandId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			offer.setBrandId(rs.getInt("brandId"));
			offer.setStoreId(rs.getInt("storeId"));
			offer.setOffer(rs.getString("offer"));
			offer.setCondAply(rs.getString("condAply"));
			offer.setStartDate(rs.getTimestamp("startDate"));
			offer.setEndDate(rs.getTimestamp("endDate"));
		}
		rs.close();
		dbConnection.closeConnection();
		return offer;
	}
	
	public Offer getOfferByStoreId(int storeId) throws Exception {
		Offer offer = new Offer();
		String querry = "select * from Offers where storeId = " + storeId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			offer.setBrandId(rs.getInt("brandId"));
			offer.setStoreId(rs.getInt("storeId"));
			offer.setOffer(rs.getString("offer"));
			offer.setCondAply(rs.getString("condAply"));
			offer.setStartDate(rs.getTimestamp("startDate"));
			offer.setEndDate(rs.getTimestamp("endDate"));
		}
		rs.close();
		dbConnection.closeConnection();
		return offer;
	}
	
}
