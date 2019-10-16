package com.fileupload.example;

import org.junit.Test;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

public class FileuploadLoadExample {
	
	@Test
	public void uploadFileExample()
	{
		String apiKey="6d629993b0c999f2366595d879834465df8faf01";
		File inputFile=new File(System.getProperty("user.dir")+"//src//test//resources//dancing_banana.gif");
		System.out.println(inputFile.length());
		given().auth().basic(apiKey, "").multiPart("source_file",inputFile)
		.multiPart("target_format","png").
		when().post("https://sandbox.zamzar.com/v1/jobs").then().time(lessThan(1L),TimeUnit.SECONDS);
		//then().log().all();
		
	}

}
