package com.restapi.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_Request {
	
	@Test
	public void getweatherdetails()
	{
		
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object		
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//print response in console window		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		//Verify Status Code
		int statuscode =response.getStatusCode();
		System.out.println("status code is :"+statuscode);
		assertEquals(statuscode,200);
		
		//Verify Status Line
		
		String statusline = response.getStatusLine();
		System.out.println("Status Line :" +statusline);
		assertEquals(statusline,"HTTP/1.1 200 OK");
		
		
		
		
	}

}
