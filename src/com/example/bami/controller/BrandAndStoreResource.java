package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.BrandAndStoreDao;
import com.example.bami.model.BrandAndStore;

@Path("/brandandstores")
@Produces(MediaType.APPLICATION_JSON)
public class BrandAndStoreResource {
	
	@GET
	public ArrayList<BrandAndStore> getAllBrandAndStore() throws Exception {
		ArrayList<BrandAndStore> list = new ArrayList<BrandAndStore>();
		BrandAndStoreDao brandAndStoreDao = new BrandAndStoreDao();
		list = brandAndStoreDao.getAllBrandAndStore();
		return list;
	}
	
}
