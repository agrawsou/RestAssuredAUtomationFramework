package com.employeeAPI.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeAPI.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class DeleteEmployee extends TestBase {
	
	@BeforeClass
	public void deleteEmployee() throws InterruptedException{
		
		logger.info("********Started Delete Employee Test Case**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		JsonPath eval = response.jsonPath();
		String empId = eval.get("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/"+empId);
		Thread.sleep(3000);
	}
	
	@Test
	public void validateResponseBody() {
		logger.info("*******Checking Response Body*********");
		
		String responseBody = response.getBody().asString();
		logger.info("Response body: "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void validateStatusCode() {
		logger.info("*******Checking Status Code*********");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code: "+statusCode);
		Assert.assertEquals(statusCode, 200);;
	}
	
	@Test
	public void validateResponseTime() {
		logger.info("*******Checking Response Time*********");
		
		long responseTime = response.getTime();
		logger.info("Response Time: "+responseTime);
		Assert.assertTrue(responseTime<6000);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*******Completed all the test validations*********");
	}

}
