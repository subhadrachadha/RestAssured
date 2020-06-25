package com.students.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BaseClass2 {
	
	static String accessToken;
	public static final String clientId="Abc-qkRR5520Ar9_HsrhwhyzYz2WgkaZoVX-40G0Fxr3IOwlRoBU9ARmJ_jq7qAqJZrh9MgQjx1BHtTC";
	public static final String clientSecrete="EMJrLRB3BhQa2irOG5Mg1u1vD1Ljm2I4yWCjfVMxhWZeRjBa-Lqnw70v7wHzBHf5knpXM94wj3G6TP1q";
	
	
	@Test
	public void getToken()
	{
		accessToken=given().parameter("grant_type", "client_credentials")
		.auth().preemptive().basic(clientId,clientSecrete).when()
		.post("https://api.sandbox.paypal.com/v1/oauth2/token")
		.then().log().all().extract().path("access_token");
		System.out.println(accessToken);
	}

}
