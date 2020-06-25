package com.jsonpath.examples;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class SearchJsonPathExample1 {
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://api.walmartlabs.com/";
		RestAssured.basePath="/v1";
	}
	
	
	@Test
	public void searchApi()
	{
		int number=given().queryParam("query", "ipod").queryParam("format","json")
		.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("numItems");
		System.out.println(number);
		assertEquals(10,number);
	}
	
	@Ignore
	@Test
	public void test003()
	{
		String s=given().queryParam("query", "ipod").queryParam("format","json")
		.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items[0].name");
		System.out.println(s);
	}
	
	@Ignore
	@Test
	public void test004()
	{
		HashMap<String,String> s = given().queryParam("query", "ipod").queryParam("format","json")
				.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items[0].imageEntities[0]");
				System.out.println(s);
		
	}
	
	@Ignore
	@Test
	public void test005()
	{
		int s = given().queryParam("query", "ipod").queryParam("format","json")
				.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.size");
				System.out.println(s);
		
	}
	
	@Ignore
	@Test
	public void test006()
	{
		List<String> s = given().queryParam("query", "ipod").queryParam("format","json")
				.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.name");
				System.out.println(s);
		
	}
	
	
	@Ignore
	@Test
	public void test007()
	{
		List<HashMap<String,Object>> s = given().queryParam("query", "ipod").queryParam("format","json")
				.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.findAll{it.name=='Apple iPod touch 7th Generation 32GB - Space Gray (New Model)'}");
				System.out.println(s);
		
	}
	
	@Ignore
	@Test
	public void test008()
	{
		List<Float> flo=given().queryParam("query","ipod").queryParam("format","json")
		.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.findAll{it.salePrice<150}.name");
		System.out.println(flo);
	}
	
	@Ignore
	@Test
	public void test009()
	{
		List<HashMap<String,String>> msrp=given().queryParam("query","ipod").queryParam("format","json")
		.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.findAll{it.name==~/App.*/}.msrp");
		System.out.println(msrp);
	}
	
	@Ignore
	@Test
	public void test0010()
	{
		List<HashMap<String,String>> msrp=given().queryParam("query","ipod").queryParam("format","json")
		.queryParam("apiKey","75e3u4sgb2khg673cbv2gjup").when().get("/search").then().extract().path("items.findAll{it.name==~/.ed/}.msrp");
		System.out.println(msrp);
	}

}
