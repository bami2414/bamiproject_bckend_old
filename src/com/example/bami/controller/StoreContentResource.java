package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.StoreContentDao;
import com.example.bami.model.StoreContentDetails;

@Path("/storecontents")
@Produces(MediaType.APPLICATION_JSON)
public class StoreContentResource {

	@GET
	@Path("/storeid/{storeId}")
	public ArrayList<StoreContentDetails> getStoreContentDetailsByStoreId(@PathParam("storeId") int storeId) throws Exception {
		ArrayList<StoreContentDetails> list = new ArrayList<StoreContentDetails>();
		StoreContentDao storeContentDao = new StoreContentDao();
		list = storeContentDao.getStoreContentDetailsByStoreId(storeId);
		return list;
	}
	
}
