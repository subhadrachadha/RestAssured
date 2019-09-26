package com.students.tests;


import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import org.junit.BeforeClass;
import org.junit.Test;
import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;
public class StudentPostTest extends TestBase {

/**
 * Test for creating new student	
 */
	@Test
	public void createNewStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then();
		//.statusCode(201);
		
	
	}
}
