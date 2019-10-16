package com.paypalexample.base;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class BaseClass {
	
	static String accessToken;
	public static final String clientId="AVChnTh4wDqXzXGA5QF8AsQo6HoGMgDR_M_hJBMSmaanDoojtyQCR920ZPUzJGllleid6HpLUXc2qTJO";
	public static final String clientSecrete="EB7M3sgT-0YfrOG3_Dq3GuRF-3dkzucFLIaIKS8WIRGyfX3MwvElA7juCQW5l6C7GMMCKK9fk6Uj0Sni";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";
		accessToken=given().parameters("grant_type", "client_credentials")
		.auth().preemptive().basic(clientId,clientSecrete).when()
		.post("/oauth2/token").then()
		.log().all().extract().path("access_token");
		System.out.println(accessToken);
	}
	
	

}
