package com.aws.greet.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.greet.dao.GreetServiceDB;
import com.aws.greet.format.FormsFormat;
import com.aws.greet.format.StatusMessage;

@Service
public class GreetServiceClass {
	
	@Autowired
	GreetServiceDB gsDB;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public StatusMessage getGreetings(FormsFormat format)
	{
		
		StatusMessage response = new StatusMessage();
		
		try 
		{
			Date date = new Date();
		    String strDateFormat = "HH";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(date);
		    
		    int time = Integer.parseInt(formattedDate);
		    
		    if(time >= 0 && time <= 5)
		    	response.setSuccess("Hi " + format.getName() + " Please go to Sleep.. Good Night & Sweet dreams..");
		    if(time >= 6 && time <= 11)
		    	response.setSuccess("Hello " + format.getName() + " Good Morning!! Have a good day.");
		    else if(time >= 12 && time <= 17)				    	
		    	response.setSuccess("Hey " + format.getName() + " Good Afternoon!!");
		    else if(time >= 18 && time <= 20)
		    	response.setSuccess("Hello " + format.getName() + " Good Evening!!");
		    else if(time >= 21 && time <= 24)
		    	response.setSuccess("Hello " + format.getName() + " Good Night!!");
		}
		catch(Exception e)
		{
			response.setError("Error");
			logger.error(e.getMessage());
		}
		
		return response;
	}
	
	
	
	
	/**
	 * Test query at application startup
	 * @throws ApplicationException
	 * @throws Exception
	 */
	public void testQuery() throws ApplicationException {
		String methodName = "testQuery";
	
		gsDB.testQuery();
		
	} 
}
