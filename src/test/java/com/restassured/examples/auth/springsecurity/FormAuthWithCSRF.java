package com.restassured.examples.auth.springsecurity;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class FormAuthWithCSRF {
public static SessionFilter filter;
	
	@BeforeClass
	public static void init()
	{
		filter=new SessionFilter();
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd").withCsrfFieldName("_crf"))
		.filter(filter).get("/formAuth");
		System.err.println(filter.getSessionId());
	}

	
	@Test
	public void getAllStudent()
	{
		given().sessionId(filter.getSessionId()).get("/student/list").then().log().all();
	}
}
