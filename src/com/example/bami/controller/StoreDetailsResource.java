package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.StoreDao;
import com.example.bami.model.StoreDetails;

@Path("/storedetailslarge")
@Produces(MediaType.APPLICATION_JSON)
public class StoreDetailsResource {

	@GET
	public ArrayList<StoreDetails> allStores() throws Exception {
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		StoreDao storeDao = new StoreDao();
		list = storeDao.getAllStoreDetails();
		return list;
	}
	
	@GET
	@Path("/brandid/{brandId}")
	public ArrayList<StoreDetails> storesByBrandId(@PathParam("brandId") int brandId) throws Exception {
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		StoreDao storeDao = new StoreDao();
		list = storeDao.getStoreDetailsByBrandId(brandId);
		return list;
	}	
	
}
