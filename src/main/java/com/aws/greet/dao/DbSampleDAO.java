package com.aws.greet.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.aws.greet.format.CityData;
import com.aws.greet.format.mapper.CityDataRowMapper;


@Repository
public class DbSampleDAO extends DBConfigClass{


	/**
	 * 
	 * @return
	 */
	public List<JSONObject> getRecords() {
				
		String sql = "Select * from dummycity";
		
		SqlRowSet srs = null;
		
		JSONObject result = null;
		
		List<JSONObject> finalResult = new ArrayList<JSONObject>();
				
		try 
		{		
			srs = jdbcTemplate.queryForRowSet(sql);
					
			while(srs.next())
			{
				result = new JSONObject();
				
				result.put("name", srs.getString(1));
				result.put("countryCode", srs.getString(2));
				result.put("district", srs.getString(3));
				
				finalResult.add(result);				
			}				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return finalResult;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public List<CityData> getCityByCode(String code) {
		
		String sql = "Select distinct NAME, countrycode, district from dummycity where countrycode = :value";			
		
		List<CityData> data = null;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("value", code);
		
		try {
			
			data = (List<CityData>) namedJdbcTemplate.query(sql, params, new CityDataRowMapper());
							
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return data;
	}

}
