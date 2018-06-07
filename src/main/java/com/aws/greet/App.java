package com.aws.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



import com.aws.greet.service.*;





/**
 * Application file for startup
 * 
 */
@Configuration
@SpringBootApplication
//@PropertySources({ @PropertySource(value = "file:/home/pandab8/oneNetwork.properties", ignoreResourceNotFound = true) })
@PropertySource("file:${DB_CONNECT}")
public class App implements CommandLineRunner {	
	
	@Autowired
	GreetServiceClass greetService;	
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
    }
    
  
    public void run(String... arg0) throws Exception 
    {
    	System.out.println("Connecting ty Data Source...");
    	System.out.println("Plese wait...");
    	
    	greetService.testQuery();
    	
    	System.out.println("Connected....");
	}
}