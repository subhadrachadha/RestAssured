package com.specification.examples;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {
static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
static RequestSpecBuilder builder;
static RequestSpecification requestSpec;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
		builder=new RequestSpecBuilder();
		builder.addQueryParam("query","ipod");
		builder.addQueryParam("format","json");
		builder.addQueryParam("apiKey",APIKEY);
		builder.addQueryParam("facet","on");
		builder.addHeader("Accept", "*/*");
		requestSpec=builder.build();
		
		
		
	}
	
	@Test
	public void test001()
	{
		given().
		spec(requestSpec).
		when()
		.get("/search").
		then().
		log().all();
		
	}

}
