package com.example.bami.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.bami.model.Brand;
import com.example.bami.service.DbConnection;

public class BrandDao {
	
	private Connection conn = null;
	private DbConnection dbConnection = null;
	
	public BrandDao() throws Exception {
		dbConnection = new DbConnection();
		conn = dbConnection.getConn();
	}
	
	public ArrayList<Brand> getAllBrands() throws Exception {
		ArrayList<Brand> list = new ArrayList<Brand>();
		String querry = "select * from Brands;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setPresenceCount(rs.getInt("presenceCount"));
			list.add(brand);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public Brand getBrandByBrandId(int brandId) throws Exception {
		Brand brand = new Brand();
		String querry = "select * from Brands where brandId = " + brandId + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setPresenceCount(rs.getInt("presenceCount"));
		}
		rs.close();
		dbConnection.closeConnection();
		return brand;
	}
	
	public ArrayList<Brand> getBrandBySize(int size) throws Exception {
		ArrayList<Brand> list = new ArrayList<Brand>();
		String querry = "select * from Brands limit " + size + ";";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setPresenceCount(rs.getInt("presenceCount"));
			list.add(brand);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
	public ArrayList<Brand> getPopularBrands() throws Exception {
		ArrayList<Brand> list = new ArrayList<Brand>();
		String querry = "select b.* from Brands b join PopularBrandsId p on b.brandId = p.brandId;";
		ResultSet rs = conn.createStatement().executeQuery(querry);
		while(rs.next()) {
			Brand brand = new Brand();
			brand.setBrandId(rs.getInt("brandId"));
			brand.setBrandName(rs.getString("brandName"));
			brand.setPresenceCount(rs.getInt("presenceCount"));
			list.add(brand);
		}
		rs.close();
		dbConnection.closeConnection();
		return list;
	}
	
}
