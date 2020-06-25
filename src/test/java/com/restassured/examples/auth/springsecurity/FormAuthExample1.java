package com.restassured.examples.auth.springsecurity;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class FormAuthExample1 {
	public static SessionFilter filter;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:9090";
		RestAssured.given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
		.filter(filter)
		.get("/formAuth");
		System.err.print(filter.getSessionId());
	}
	
	@Test
	public void getAllStudent()
	{
		RestAssured.given().sessionId(filter.getSessionId()).get("/student/list").then().log().all();
	}

}
