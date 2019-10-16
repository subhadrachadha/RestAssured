package com.restassured.examples.jsonassert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import io.restassured.RestAssured;

public class JsonAssertExample {
	
	@Test
	public void getStudents() throws IOException, JSONException
	{
		String expectedValue=new String(Files.readAllBytes
				(Paths.get(System.getProperty("user.dir")+"//src//test//resources//File.txt")));
		String actualValue=RestAssured.given().when().get("http://localhost:8080/student/list").asString();
		JSONAssert.assertEquals(expectedValue, actualValue,JSONCompareMode.LENIENT);
		
	}
	
	@Test
	public void getStudentsStrict() throws IOException, JSONException
	{
		String expectedValue=new String(Files.readAllBytes
				(Paths.get(System.getProperty("user.dir")+"//src//test//resources//difforder.txt")));
		String actualValue=RestAssured.given().when().get("http://localhost:8080/student/list").asString();
		JSONAssert.assertEquals(expectedValue, actualValue,JSONCompareMode.STRICT);
		
	}

}
