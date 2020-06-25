package com.students.tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import com.student.base.TestBase;
public class StudentDeleteTest extends TestBase  {
	
	
	/**
	 * Test for Deleting student information
	 */
	@Test
	public void deleteStudent(){
		//Put the student ID here
		String studentId="59";
		
		given()
		.when()
		.delete("/"+studentId)
		.then();
		//.statusCode(204);
	}

}
