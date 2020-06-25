package com.students.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.student.model.Student1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class StudentPostTest1 {
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void createStudent()
	{
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("Java");
		courses.add("C++");
		Student1 student1=new Student1();
		student1.setFirstName("mithu");
		student1.setLastName("chuchu");
		student1.setEmail("subhadra.singh111@gmail.com");
		student1.setProgramme("computer science");
		student1.setCourses(courses);
		
		given().contentType
		(ContentType.JSON).log().all().when().
		body(student1).post().then().
		statusCode(200);
	}
}
