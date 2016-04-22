package com.example.bami.businessLogic;

import java.util.ArrayList;
import java.util.Collections;

import com.example.bami.dao.StoreDao;
import com.example.bami.dao.StoreLocationDao;
import com.example.bami.model.StoreDetails;
import com.example.bami.model.StoreIdAndDistance;
import com.example.bami.model.StoreLocationLatLon;

public class NearByStores {

	public ArrayList<StoreDetails> getNearByStores(double lat,double lon) throws Exception {
		StoreDao storeDao = new StoreDao();
		StoreLocationDao storeLocationDao = new StoreLocationDao();
		ArrayList<StoreDetails> list = new ArrayList<StoreDetails>();
		ArrayList<StoreLocationLatLon> storeLoc = storeLocationDao.getStoreLocationWithLatLon();
		ArrayList<StoreDetails> storesList = storeDao.getAllStoreDetails();
		//Map<Double,Integer> storeIds = new HashMap<Double,Integer>();
		ArrayList<StoreIdAndDistance> storeIds = new ArrayList<StoreIdAndDistance>();
		for(StoreLocationLatLon storeLocationLatLon : storeLoc) {
			double currentLat = storeLocationLatLon.getLat();
			double currentLon = storeLocationLatLon.getLon();
			double dist = distance(lat,lon,currentLat,currentLon);
			StoreIdAndDistance storeIdAndDistance = new StoreIdAndDistance();
			storeIdAndDistance.setDistance(dist);
			storeIdAndDistance.setStoreId(storeLocationLatLon.getStoreId());
			storeIds.add(storeIdAndDistance);
		}
		Collections.sort(storeIds);
		Collections.sort(storesList);
		for(StoreIdAndDistance storeIdAndDistance : storeIds) {
			int storeId = storeIdAndDistance.getStoreId();
			StoreDetails storeDetails = new StoreDetails();
			storeDetails = findStoreById(storeId, storesList);
			list.add(storeDetails);
		}
		return list;
	}
	
	private StoreDetails findStoreById(int storeId,ArrayList<StoreDetails> storesList) {
		StoreDetails storeDetails = new StoreDetails();
		int lft = 0; int rht = storesList.size()-1;
		int mid;
		while(rht-lft >= 0) {
			mid = lft+(rht-lft)/2;
			if(storeId == storesList.get(mid).getStoreId()) {
				storeDetails = storesList.get(mid);
				break;
			} else if(storeId < storesList.get(mid).getStoreId()) {
				rht = mid - 1;
			} else {
				lft = mid + 1;
			}
		}
		return storeDetails;
	}
	
	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 0.8684;
		return (dist);
	}
	
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
