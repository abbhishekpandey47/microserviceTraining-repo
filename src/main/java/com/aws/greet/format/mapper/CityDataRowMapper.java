package com.aws.greet.format.mapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aws.greet.format.CityData;

public class CityDataRowMapper implements RowMapper<CityData> {
	
	
	public CityData mapRow(ResultSet rs, int arg1) throws SQLException  {
			
		CityData buildFormat = new CityData();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		if(rsmd.getColumnName(1).toString().equalsIgnoreCase("NAME"))
		{
			buildFormat.setCityName(rs.getString("NAME"));
			buildFormat.setCode(rs.getString("COUNTRYCODE"));
			buildFormat.setDistrict(rs.getString("DISTRICT"));
		}
	
		
		return buildFormat;
	}
	

}
