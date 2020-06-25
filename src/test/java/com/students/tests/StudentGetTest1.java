package com.students.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;




public class StudentGetTest1 {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	/******
	 * given
	 * set cookies,add headers,setting header information
	 * when()
	 * all the resources get consumed after when method
	 * GET,PUT,POST ,DELETE
	 * Then()
	 * all validations will happen after the Then method
	 * validate status code,extract response code,extract cookies,extract
	 * response body
	 * 
	 */
	@Test(enabled = false)
	public void getAllStudentInformation()
	{
		Response res=given().when().get("/list");
		System.out.println(res.body().prettyPrint());
		
		//validate the status code
		given().when().get("/list").then().statusCode(200);
		
		
	}
	
	@Test
	public void getStudentInfo()
	{
				Response res=given().param("programme","Financial Analysis").
				param("limit","2").get("/list");
		System.out.println(res.body().prettyPrint());
	}

}
