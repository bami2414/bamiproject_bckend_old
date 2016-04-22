package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.StoreWorkingHourDao;
import com.example.bami.model.StoreWorkingHour;

@Path("/storeworkinghours")
@Produces(MediaType.APPLICATION_JSON)
public class StoreWorkingHourResource {

	@GET
	public ArrayList<StoreWorkingHour> allStoreWorkingHours() throws Exception {
		ArrayList<StoreWorkingHour> list = new ArrayList<StoreWorkingHour>();
		StoreWorkingHourDao storeWorkingHourDao = new StoreWorkingHourDao();
		list = storeWorkingHourDao.getAllStoreWorkingHours();
		return list;
	}
	
	@GET
	@Path("/storeid/{storeId}")
	public StoreWorkingHour storeWorkingHourByStoreId(@PathParam("storeId") int storeId) throws Exception {
		StoreWorkingHour storeWorkingHour = new StoreWorkingHour();
		StoreWorkingHourDao storeWorkingHourDao = new StoreWorkingHourDao();
		storeWorkingHour = storeWorkingHourDao.getStoreWorkingHourByStoreId(storeId);
		return storeWorkingHour;
	}
	
}
