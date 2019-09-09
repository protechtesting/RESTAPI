package com.restapi.testcases;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_Post_Request {
	
	@Test
	public void verifyRegistrationSuccessful()
	{
		
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//Request payload sending along with post request
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "Durai");
		requestParams.put("LastName", "pandi");
		requestParams.put("UserName", "raja");
		requestParams.put("Password", "6271061589");
		requestParams.put("Email", "grantvictory@gmail.com");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		
		
		//Response Object		
		Response response = httpRequest.request(Method.POST,"/register");
		
		//print response in console window		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//Verify Status Code
		int statuscode =response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		assertEquals(statuscode,201);
		
		
		//Verify Success code
		String successCode = response.jsonPath().get("SuccessCode");		
		assertEquals(successCode,"OPERATION_SUCCESS");
		
		
		
		
		
	}


}
