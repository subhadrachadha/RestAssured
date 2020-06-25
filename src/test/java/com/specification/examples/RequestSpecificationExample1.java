package com.specification.examples;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class RequestSpecificationExample1 {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	
	static ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	

	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";	
		
		builder =new RequestSpecBuilder();
		builder.addQueryParam("query", "ipod");
		builder.addQueryParam("format", "json");
		builder.addQueryParam("apiKey",APIKEY);
		builder.addQueryParam("facet", "on");
		builder.addQueryParam("Accept", "*/*");
		requestSpec=builder.build();
		
		responseBuilder=new ResponseSpecBuilder();
responseBuilder.expectHeader("content-type","application/json;charset=utf-8");
responseBuilder.expectHeader("content-type","application/json;charset=utf-8");
responseBuilder.expectHeader("server","Mashery Proxy");
responseBuilder.expectStatusCode(200);

responseBuilder.expectBody("query",equalTo("ipod"));
responseBuilder.expectBody("numItems",hasItem(10));
responseSpec=responseBuilder.build();
		
		
		
	}
	
	@Test
	public void getSearchResult()
	{
		given().spec(requestSpec).when().get("/search").then().spec(responseSpec);
		
	}
	
	
	
	
}
