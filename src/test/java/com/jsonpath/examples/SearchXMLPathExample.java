package com.jsonpath.examples;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;

import static io.restassured.RestAssured.*;
import static io.restassured.path.xml.XmlPath.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

public class SearchXMLPathExample {
	
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
		
	}
	
	@Ignore
	@Test
	public void test001()
	{
		String data=given().queryParam("query","ipod").
		queryParam("format","xml").queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").
		when().get("/search").then().extract().path("searchresponse.items.item[0].name");
		System.out.println(data);
	}
	
	@Ignore
	@Test
	public void test002()
	{
		String xml=given().queryParam("query","ipod").
		queryParam("format","xml").queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").
		when().get("/search").asString();
		System.out.println(xml);
	}
	
	@Ignore
	@Test
	public void test003()
	{
		String xml=given().queryParam("query","ipod").
		queryParam("format","xml").queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").
		when().get("/search").asString();
		String gift=with(xml).getString("searchresponse.items.item[0].giftOPtions");
		System.out.println(gift);
	}
	
	@Test
	public void test004()
	{
		String gift =given().queryParam("query","ipod").
		queryParam("format","xml").queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").
		when().get("/search").asString();
		List<String> names=with(gift).getList("searchresponse.items.item.name");
		List<String> salePrice=with(gift).getList("searchresponse.items.item.findAll{it.name=='Refurbished Apple iPod Touch 5th gen 16GB WiFi MP3 MP4 Digital Music Video Player MGG82LL/A'}.salePrice");
		System.out.println(names);
		System.out.println(salePrice);
	}

}
