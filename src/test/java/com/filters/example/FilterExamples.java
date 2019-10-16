package com.filters.example;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterExamples {
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	public static StringWriter errWriter;
	public static PrintStream errCapture;
	
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
	}
	
	@Before
	public void beforeEachTest()
	{
		requestWriter = new StringWriter();
		requestCapture= new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter=new StringWriter();
		responseCapture=new PrintStream(new WriterOutputStream(responseWriter),true);
		
		errWriter=new StringWriter();
		errCapture=new PrintStream(new WriterOutputStream(errWriter),true);
		
		
	}
	
	@Test
	public void getStudent()
	{
		String response=RestAssured.given()
		.log().all().when().get("/list").asString();
		System.out.println(response);
		
		
		RestAssured.given().filter(new RequestLoggingFilter(requestCapture)).
		filter(new ResponseLoggingFilter(responseCapture)).
		when().get("/list").asString();
		System.err.print(requestWriter.toString());
		System.err.print(responseWriter.toString());
		
		
		RestAssured.given().
		filter(new ErrorLoggingFilter(errCapture)).
		when().get("/lists").asString();
		System.err.print(errWriter.toString());
		
	}

}
