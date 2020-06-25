	package com.xmlpath.examples;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.*;

import java.util.List;

public class SearchXMLPathExamples {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	//extract numitems
	
	@Test
	public void test001()
	{
		String numitem=given().queryParam("query", "ipod").queryParam("format","xml")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract().path("searchresponse.numItems");
		System.out.println(numitem);
	}
	
	//Get first product name from xml
	@Test
	public void test002()
	{
		String productName=given().queryParam("query", "ipod").queryParam("format","xml")
		.queryParam("apiKey", APIKEY).when().get("/search").then().extract().path("searchresponse.items.item[0].name");
		System.out.println(productName);
	}
	
	//Get first product name from xml
		@Test
		public void test003()
		{
			String xml=given().queryParam("query", "ipod").queryParam("format","xml")
			.queryParam("apiKey", APIKEY).when().get("/search").asString();
			String giftOPtion=with(xml).getString("searchresponse.items.item[0].giftoptions");
			System.out.println(giftOPtion);
		}
		
		//GET ALL Items size
		@Test
		public void test004()
		{
			NodeChildrenImpl items=given().queryParam("query", "ipod").queryParam("format","xml")
			.queryParam("apiKey", APIKEY).when().get("/search").then().extract().path("searchresponse.items.item");
			System.out.println(items.size());
		}
		
		//get all the names of items
		
		@Test
		public void test005()
		{
			String xml=given().queryParam("query","ipod").queryParam("format","xml").
			queryParam("apiKey",APIKEY).when().get("/search").asString();
			List<String> names=with(xml).getList("searchresponse.items.item.name");
			System.out.println(names);
		}
		
		//get the salePrice of particular item
		
		@Test
		public void test006()
		{
			String xml=given().queryParam("query","ipod").queryParam("format","xml").
			queryParam("apiKey",APIKEY).when().get("/search").asString();
			List<Object> saleprice=with(xml).getList("searchresponse.items.item.findAll{it.name=='Apple iPod touch 128GB (Previous Model)'}.salePrice");
			System.out.println(saleprice);
		}
		
		
		//deep search in xml path
		
		@Test
		public void test007()
		{
			String xml=given().queryParam("query","ipod").queryParam("format","xml").
					queryParam("apiKey",APIKEY).when().get("/search").asString();
					List<Object> saleprice=with(xml).getList("**.findAll{it.name=='Apple iPod touch 128GB (Previous Model)'}.salePrice");
					System.out.println(saleprice);
			
		}
		
		//get the itemid starts with 12981
		
		@Test
		public void test008()
		{
			List<String> item=given().queryParam("query","ipod")
			.queryParam("format","json").
			queryParam("apiKey",APIKEY).when().get("/search").then()
			.extract().path("items.findAll{it.itemId==~/1298.*/}.itemId");
			System.out.println(item);
		}
		
		
		@Test
		public void test009()
		{
			String xml=given().queryParam("query","ipod")
			.queryParam("format","xml").
			queryParam("apiKey",APIKEY).when().get("/search").andReturn().asString();
			//System.out.println(xml);
			List<String> item=with(xml).getList("searchresponse.items.item.salePrice");
			System.out.println(item);
		}

}
