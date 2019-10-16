package com.jsonpath.examples;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

public class SearchJsonPathExample {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	//extract numitem
	@Test
	public void test001()
	{
		int numItem=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("numItems");
		System.out.println(numItem);
	}
	
	//extract query
	@Test
	public void test002()
	{
		String query=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("query");
		System.out.println(query);
	}
	
	//extract first product name
	@Test
	public void test003()
	{
		String productName=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items[0].name");
		System.out.println(productName);
	}
	
	@Test
	public void test004()
	{
	  HashMap<String,String> gift=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items[0].giftOptions");
		System.out.println(gift);
	}
	@Test
	public void test005()
	{
	  int size=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items.size()");
		System.out.println(size);
	}
	@Test
	public void test006()
	{
	  List<String> name=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items.name");
		System.out.println(name);
	}
	@Test
	public void test007()
	{
	  List<HashMap<String,String>> value=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items.find { it.name == 'Apple iPod Touch 6th Generation 32GB Refurbished' }");
		System.out.println(value);
	}
	
	@Test
	public void test008()
	{
	  List<Float> salePrice=given().queryParam("query","ipod").queryParam("format", "json")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract()
		.path("items.findAll{ it.name == 'Apple iPod touch 32GB - Blue (Previous Model)'}.salePrice");
		System.out.println(salePrice);
	}
	
	//get the names which have salesPrice
	
	@Test
	public void test009()
	{
		List<String> names=given().queryParam("query","ipod").
		queryParam("format","json").
		queryParam("apikey",APIKEY).when().get("/search").then().extract().path("items.findAll{it.salePrice<150}.name");
		System.out.println(names);
	}
	
	
	
	//get all msrp value starts with Ref
	
	@Test
	public void test010()
	{
		List<String> msrp=given().queryParam("format","json").queryParam("query","ipod").
		queryParam("apikey",APIKEY).when().get("/search").then().extract().path("items.findAll{it.name==~/Ref.*/}.msrp");
		System.out.println(msrp);
		
	}
	
	//get the salesPrice of an item ends with ed 
	
	public void test011()
	{
		List<String> salesPrice=given().queryParam("format","json").queryParam("query","ipod").
		queryParam("apikey",APIKEY).when().get("/search").then().extract().path("items.findAll{it.name==~/.*ed/}.salesPrice");
		System.out.println(salesPrice);
		
	}

}
