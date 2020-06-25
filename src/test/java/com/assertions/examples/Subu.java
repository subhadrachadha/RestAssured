package com.assertions.examples;

import org.junit.Test;

import io.restassured.RestAssured;

public class Subu {
	
	@Test
	public void test()
	{
		RestAssured.given().when().get("https://reqres.in/api/users").then().statusCode(200);
	}

}
