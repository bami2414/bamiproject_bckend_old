package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.OfferDao;
import com.example.bami.model.Offer;

@Path("/offers")
@Produces(MediaType.APPLICATION_JSON)
public class OfferResource {

	@GET
	public ArrayList<Offer> allOffers() throws Exception {
		ArrayList<Offer> list = new ArrayList<Offer>();
		OfferDao offerDao = new OfferDao();
		list = offerDao.getAllOffers();
		return list;
	}
	
	@GET
	@Path("/brandid/{brandId}/storeid/{storeId}")
	public Offer offerBybrandIdAndStoreId(@PathParam("brandId") int brandId, @PathParam("storeId") int storeId) throws Exception {
		Offer offer = new Offer();
		OfferDao offerDao = new OfferDao();
		offer = offerDao.getOfferByStoreIdAndBrandId(storeId, brandId);
		return offer;
	}
	
	@GET
	@Path("/storeid/{storeId}")
	public Offer offerByStoreId(@PathParam("storeId") int storeId) throws Exception {
		Offer offer = new Offer();
		OfferDao offerDao = new OfferDao();
		offer = offerDao.getOfferByStoreId(storeId);
		return offer;
	}
	
}
