package com.assertions.examples;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class AssertionsExamples {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
		
	}
	
	@Test
	public void test001()
	{
		int numItem=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("numItems");
		assertEquals(10,numItem);
	}
	
	@Test
	public void test002()
	{
      given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().body("numItems", equalTo(10));
	}
	
	//verify query
	@Test
	public void test003()
	{
      given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().body("query", equalToIgnoringCase("ipod"));
	}
	
	//verify query
		@Test
		public void test004()
		{
	      given().queryParam("query","ipod").queryParam("format", "json")
			.queryParam("apiKey", APIKEY).when().get("/search").then().body("query", equalToIgnoringCase("ipod"));
		}
	//extract name
		@Test
		public void test005()
		{
			given().queryParam("query","ipod").queryParam("format","json"). 
			queryParam("apiKey",APIKEY).when().get("/search").then().body("items.name",hasItems("Apple iPod touch 128GB (Previous Model)","Apple iPod touch 32GB - Blue (Previous Model)"));
		}
		
		//verify the key
		@Test
		public void test006()
		{
			given().queryParam("query","ipod").queryParam("format","json"). 
			queryParam("apiKey",APIKEY).when().get("/search").then().body("items[0].imageEntities[0]",hasKey("entityType"));
		}

		
		//check the hash value
		@Test
		public void test007()
		{
			given().queryParam("query","ipod").queryParam("format","json"). 
			queryParam("apiKey",APIKEY).when().get("/search").then().body("items.findAll{it.name=='Apple iPod touch 128GB (Previous Model)'}",hasItem(hasEntry("name","Apple iPod touch 128GB (Previous Model)")));
			
		}
		
		//check multiple values in test
		@Test
		public void test008()
		{
			given().queryParam("query","ipod").queryParam("format","json"). 
			queryParam("apiKey",APIKEY).when().get("/search").then().body("items.findAll{it.name=='Apple iPod touch 128GB (Previous Model)'}",hasItem(hasEntry("name","Apple iPod touch 128GB (Previous Model)"))).
			body("items.name",hasItem("Apple iPod touch 32GB - Blue (Previous Model)")).statusCode(200);
			
		}
		
		//logical assertions
		@Test
		public void test009()
		{
			given().queryParam("query","ipod").queryParam("format","json"). 
			queryParam("apiKey",APIKEY).when().get("/search").then()
			.body("items.size()",equalTo(10)).
			body("items.size()",greaterThan(5)).
			body("items.size()",lessThan(11)).
			body("items.size()",greaterThanOrEqualTo(10)).
			body("items.size()",lessThanOrEqualTo(10)).
			statusCode(200);
			
		}
	

}
