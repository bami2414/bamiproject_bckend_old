package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.bami.businessLogic.NearByStores;
import com.example.bami.dao.StoreDao;
import com.example.bami.model.Store;
import com.example.bami.model.StoreDetails;


@Path("/stores")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {

	@GET
	public ArrayList<Store> allStores(@QueryParam("size") int size) throws Exception {
		ArrayList<Store> list = new ArrayList<Store>();
		StoreDao storeDao = new StoreDao();
		if(size > 0) {
			list = storeDao.getStoreBySize(size);
		} else {
			list = storeDao.getAllStores();
		}
		return list;
	}
	
	@GET
	@Path("/popularstores")
	public ArrayList<Store> popularStores() throws Exception {
		ArrayList<Store> list = new ArrayList<Store>();
		StoreDao storeDao = new StoreDao();
		list = storeDao.getPopularStores();
		return list;
	}
	
	@GET
	@Path("/nearby")
	public ArrayList<StoreDetails> nearByStores(@QueryParam("lat") double lat, @QueryParam("lon") double lon) throws Exception {
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		NearByStores nearByStores = new NearByStores();
		list = nearByStores.getNearByStores(lat, lon);
		return list;
	}
	
}
