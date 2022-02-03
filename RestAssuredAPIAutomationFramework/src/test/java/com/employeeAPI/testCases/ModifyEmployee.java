package com.employeeAPI.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeAPI.base.TestBase;
import com.employeeAPI.utils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class ModifyEmployee extends TestBase {
	
	String empName = RestUtils.getEmpName();
	String empSal = RestUtils.getEmpSal();
	String empAge = RestUtils.getEmpAge();
	
	
	@BeforeClass
	public void modifyEmployees() throws InterruptedException{
		
		logger.info("********Started Modify Employees Test Case**********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.PUT,"/update/"+empId);
		Thread.sleep(3000);
	}
	
	@Test
	public void validateResponseBody() {
		logger.info("*******Checking Response Body*********");
		
		String responseBody = response.getBody().asString();
		logger.info("Response body: "+responseBody);
		Assert.assertTrue(responseBody.contains(empName));
		Assert.assertTrue(responseBody.contains(empSal));
		Assert.assertTrue(responseBody.contains(empAge));
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
		Assert.assertTrue(responseTime<10000);
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*******Completed all the test validations*********");
	}

}
