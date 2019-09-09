package com.restapi.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_ExtractValuesofEachnodesinJSON {
	
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
		
		JsonPath jsonpath = response.jsonPath();
		
		assertEquals(jsonpath.get("City"),"Delhi");
		
		
	}

}
