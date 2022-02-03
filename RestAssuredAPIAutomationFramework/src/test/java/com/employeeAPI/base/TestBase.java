package com.employeeAPI.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public RequestSpecification httpRequest;
	public Response response;
	
	public String empId = "21";
	
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		
	}

}
