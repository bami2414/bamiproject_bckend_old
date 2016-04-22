package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.BrandDao;
import com.example.bami.model.Brand;

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {

	@GET
	public ArrayList<Brand> allBrands(@QueryParam("size") int size) throws Exception {
		ArrayList<Brand> list = new ArrayList<Brand>();
		BrandDao brandDao = new BrandDao();
		if(size > 0) {
			list = brandDao.getBrandBySize(size);
		} else {
			list = brandDao.getAllBrands();
		}
		return list;
	}
	
	@GET
	@Path("/brandid/{brandId}")
	public Brand brandByBrandId(@PathParam("brandId") int brandId) throws Exception {
		Brand brand = new Brand();
		BrandDao brandDao = new BrandDao();
		brand = brandDao.getBrandByBrandId(brandId);
		return brand;
	}
	
	@GET
	@Path("/popularbrands")
	public ArrayList<Brand> popularBrands() throws Exception {
		ArrayList<Brand> list = new ArrayList<Brand>();
		BrandDao brandDao = new BrandDao();
		list = brandDao.getPopularBrands();
		return list;
	}
}
