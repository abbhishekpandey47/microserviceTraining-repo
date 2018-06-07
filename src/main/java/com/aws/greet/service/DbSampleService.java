package com.aws.greet.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.greet.dao.DbSampleDAO;
import com.aws.greet.format.CityData;
import com.aws.greet.format.request.CityRequestFormat;

@Service
public class DbSampleService {
	
	@Autowired
	DbSampleDAO dbDB;
	
	/**
	 * 
	 * @return
	 */
	public List<JSONObject> getRecords() {
		
		List<JSONObject> finalResult =	dbDB.getRecords();
		
		
		return finalResult;
	}
	
	
	public List<CityData> getCityByCode(CityRequestFormat req) {
		
		List<CityData> finalResult = null;
		
		try
		{
			finalResult = dbDB.getCityByCode(req.getCountryCode());
		}
		catch(Exception e)
		{
			
		}
		
		return finalResult;
	}

}
