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

public class FilterExample1 {
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost:8080";
		RestAssured.basePath="/student";
		RestAssured.port=8080;
	}
	
	@Before
	public  void beforeEachTest()
	{
		requestWriter=new StringWriter();
		requestCapture=new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter=new StringWriter();
		responseCapture=new PrintStream(new WriterOutputStream(responseWriter),true);
		
		errorWriter=new StringWriter();
		errorCapture=new PrintStream(new WriterOutputStream(errorWriter),true);
		
		
	}
	
	@Test
	public void getStudent()
	{
		String response=RestAssured.given().when().get("/list").asString();
		System.out.println(response);
		
		RestAssured.
		given().filter(new RequestLoggingFilter(requestCapture))
		.filter(new ResponseLoggingFilter(responseCapture)).
		filter(new ErrorLoggingFilter(errorCapture)).
		when().get("/list");
		
		System.err.println("****"+requestWriter.toString());
		/*System.err.println("********"+responseWriter.toString());
		System.err.print(errorWriter.toString());
		*/
	}

}
