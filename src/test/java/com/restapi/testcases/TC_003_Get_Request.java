package com.restapi.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_Get_Request {
	
	@Test
	public void googleMapTest()
	{
		
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object		
		Response response = httpRequest.request(Method.GET,"maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//print response in console window		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		String contentType=response.header("Content-Type");// capture details of Content-Type header
		  System.out.println("Content Type is:"+contentType);
		  assertEquals(contentType, "application/json");
		  
		  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
		  System.out.println("Content Encoding is:"+contentEncoding);
	    assertEquals(contentEncoding, "gzip");
		  
		
		
		
		
	}


}
