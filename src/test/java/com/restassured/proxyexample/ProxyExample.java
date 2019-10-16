package com.restassured.proxyexample;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;

public class ProxyExample {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080/student/list";
		
	}
	
	@Test
	public void sendRequest()
	{
		ProxySpecification ps=new ProxySpecification("localhost",5051,"http");
		given().proxy(ps).when().get("/list").then().log().body();
		
	}

}
