package com.aws.greet.format.response;

import java.util.List;

import com.aws.greet.format.CityData;
import com.aws.greet.format.StatusMessage;

public class CityResponseFormat extends StatusMessage{
	
	private List<CityData> cityData;	

	public List<CityData> getCityData() {
		return cityData;
	}

	public void setCityData(List<CityData> cityData) {
		this.cityData = cityData;
	}
}
