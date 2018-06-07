package com.aws.greet.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aws.greet.format.FormsFormat;
import com.aws.greet.format.StatusMessage;
import com.aws.greet.service.GreetServiceClass;
import com.aws.greet.utils.ApplicationUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/awsGreet")
@Api(value = "ggrreett", tags = {"GRREETT APPII" })
public class GreetController 
{
	
	/**
	 * API to get the Greets
	 * 
	 * @return
	 */	
	
	@Autowired
	GreetServiceClass gsServc;
		
	
	@RequestMapping(value = "/getGreetings", method = RequestMethod.POST, consumes={"application/json"}, produces = MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Returns ", notes = " ", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of Greets", response = String.class),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "No Greets Available"), })
	@ResponseStatus(value = HttpStatus.OK)
	//@Scheduled(fixedRate = 5000)
	public String getGreets(@ApiParam (value = "some blah blah description", required = true) @RequestBody FormsFormat form)
			throws Exception{
			
			//String methodName = "getGreets";
			//logger.startMethod(methodName);								
			
		StatusMessage response = new StatusMessage();
		
			try
			{					
				if(form.getName().isEmpty() || form.getName().equals(""))
					response.setError("Missing User Name");
				else								
					response = gsServc.getGreetings(form);				    			
			}
			catch(Exception e1)
			{
				//logger.error(methodName, e1.toString());
				response.setError("Some Error Occured!!");	
			}
			
			return ApplicationUtils.createJsonFormat(response);
		}
	
	
	/**
	 * API to get the Greets
	 * 
	 * @return
	 */	
	
	@RequestMapping(value = "/getSum", method = RequestMethod.POST)
	@ApiOperation(value = "Returns ", notes = " ", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of Greets", response = String.class),
			@ApiResponse(code = 400, message = "Invalid input provided"),
			@ApiResponse(code = 404, message = "No Greets Available"), })
	@ResponseStatus(value = HttpStatus.OK)
	//@Scheduled(fixedRate = 5000)
	public String getSum(@ApiParam (value = "some blah blah description", required = true) @RequestBody FormsFormat form)
			throws Exception{
			
			//String methodName = "getGreets";
			//logger.startMethod(methodName);
			
			StatusMessage response = new StatusMessage();			
			
			try
			{																		   
				    int sum = form.getOperand1() + form.getOperand2();
				    response.setSuccess("Sum of " + form.getOperand1() + " + " + form.getOperand2() + " is " + sum );
			
			}
			catch(Exception e1)
			{
				//logger.error(methodName, e1.toString());
				response.setError("Some Error Occured!!");	
			}
			
			return ApplicationUtils.createJsonFormat(response);
		}

}

