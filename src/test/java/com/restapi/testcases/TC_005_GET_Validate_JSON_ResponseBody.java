package com.restapi.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET_Validate_JSON_ResponseBody {
	
	@Test
	public void getweatherdetails(){
		
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object		
		Response response = httpRequest.request(Method.GET,"Delhi");
		
		//print response in console window		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		Assert.assertEquals(responseBody.contains("Delhi"),true);
		
		
	}

}
