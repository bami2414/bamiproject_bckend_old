package com.example.bami.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.bami.dao.ItemDao;
import com.example.bami.model.Item;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	@GET
	public ArrayList<Item> getAllItems() throws Exception {
		ArrayList<Item> list = new ArrayList<Item>();
		ItemDao itemDao = new ItemDao();
		list = itemDao.getAllItems();
		return list;
	}
	
	@GET
	@Path("/itemid/{itemId}")
	public Item getItemByItemId(@PathParam("itemId") int itemId) throws Exception {
		Item item = new Item();
		ItemDao itemDao = new ItemDao();
		item = itemDao.getItemByItemId(itemId);
		return item;
	}
	
}
