package com.aws.greet.dao;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Repository;

@Repository
public class GreetServiceDB extends DBConfigClass{
	
	/**
	 * Test query to check connections at application startup
	 * @throws ApplicationException
	 */
	public void testQuery() throws ApplicationException {
		String methodName = "testQuery";
		
		String sql = "select count(1) from dual";
		try{
			
			jdbcTemplate.queryForList(sql);
			
		}catch(Exception e){
			
			throw new ApplicationException("Not able to run test query", null);
		}
		
	}
}
