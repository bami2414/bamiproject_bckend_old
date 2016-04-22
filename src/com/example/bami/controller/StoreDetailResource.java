package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.StoreDetailDao;
import com.example.bami.model.StoreDetail;


@Path("/storedetails")
@Produces(MediaType.APPLICATION_JSON)
public class StoreDetailResource {

	@GET
	public ArrayList<StoreDetail> allStoreDetails() throws Exception {
		ArrayList<StoreDetail> list = new ArrayList<StoreDetail>();
		StoreDetailDao storeDetailDao = new StoreDetailDao();
		list = storeDetailDao.getAllStoreDetails();
		return list;
	}
	
	@GET
	@Path("/storeid/{storeId}")
	public StoreDetail storeDetailByStoreId(@PathParam("storeId") int storeId) throws Exception {
		StoreDetail storeDetail = new StoreDetail();
		StoreDetailDao storeDetailDao = new StoreDetailDao();
		storeDetail = storeDetailDao.getStoreDetailByStoreId(storeId);
		return storeDetail;
	}
}
