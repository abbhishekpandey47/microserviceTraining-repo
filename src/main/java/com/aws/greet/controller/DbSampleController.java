package com.aws.greet.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aws.greet.format.CityData;
import com.aws.greet.format.request.CityRequestFormat;
import com.aws.greet.format.response.CityResponseFormat;
import com.aws.greet.service.DbSampleService;
import com.aws.greet.utils.ApplicationUtils;
import com.aws.greet.utils.Constants;


@RestController
@RequestMapping("/DbSample")
public class DbSampleController {
	
	@Autowired
	DbSampleService dbSrvc;
	
	
	@RequestMapping(value = "/getCityRecords", method = RequestMethod.POST)	
	public String getCityRecords()
	{
		List<JSONObject> data = null;
		
		try {
			System.out.println("Will get Execute every 10 secs");
			data = dbSrvc.getRecords();
			
			System.out.println(data.get(0).getString("name"));
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return ApplicationUtils.createJsonFormat(data);
	}
	
	
	@RequestMapping(value = "/getCityByCode", method = RequestMethod.POST)
	public String getCityByCode(@RequestBody CityRequestFormat request)
	{		
		
		CityResponseFormat cityResponseList = new CityResponseFormat();
		
		try {
			
			if(request.getCountryCode() == null || request.getCountryCode() == "")
				cityResponseList.setError(Constants.MISSING_CITY_CODE);
			else
			{
				List<CityData>	cityData = dbSrvc.getCityByCode(request);
				if(cityData.size() > 0)
					cityResponseList.setCityData(cityData);
				else
					cityResponseList.setError(Constants.NO_DATA);
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
			cityResponseList.setError(Constants.ERROR);
		}
		
		return ApplicationUtils.createJsonFormat(cityResponseList);
	}

}
