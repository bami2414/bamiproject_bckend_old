package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.StoreLocationDao;
import com.example.bami.model.StoreLocation;

@Path("/storelocations")
@Produces(MediaType.APPLICATION_JSON)
public class StoreLocationResource {

	@GET
	public ArrayList<StoreLocation> allStoreLocations() throws Exception {
		ArrayList<StoreLocation> list = new ArrayList<StoreLocation>();
		StoreLocationDao storeLocationDao = new StoreLocationDao();
		list = storeLocationDao.getAllStoreLocations();
		return list;
	}
	
	@GET
	@Path("/storeid/{storeId}")
	public StoreLocation storeLocationByStoreId(@PathParam("storeId") int storeId) throws Exception {
		StoreLocation storeLocation = new StoreLocation();
		StoreLocationDao storeLocationDao = new StoreLocationDao();
		storeLocation = storeLocationDao.getStoreLocationByStoreId(storeId);
		return storeLocation;
	}
	
}
