package com.paypalexample.base;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class BaseClass1 {
	
	static String accessToken;
	public static final String clientId="Abc-qkRR5520Ar9_HsrhwhyzYz2WgkaZoVX-40G0Fxr3IOwlRoBU9ARmJ_jq7qAqJZrh9MgQjx1BHtTC";
	public static final String clientSecrete="EMJrLRB3BhQa2irOG5Mg1u1vD1Ljm2I4yWCjfVMxhWZeRjBa-Lqnw70v7wHzBHf5knpXM94wj3G6TP1q";
	
	
	@Test
	public static void getToken()
	{
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";
		accessToken=given().parameter("grant_type","client_credentials").auth()
		.preemptive().basic(clientId,clientSecrete).when().post("/oauth2/token").then()
		.log().all().extract().path("access_token");
		System.out.println(accessToken);
	}

}
