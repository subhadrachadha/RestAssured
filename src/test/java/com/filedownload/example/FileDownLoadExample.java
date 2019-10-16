package com.filedownload.example;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

public class FileDownLoadExample {

	@Test
	public void verifyDownloadedFile()
	{
		File inputFile=new File(System.getProperty("user.dir")+"//src//test//resources//"+"geckodriver-v0.11.1-arm7hf.tar.gz");
		
		int expectedSize=(int) inputFile.length();
		
		System.out.println("the expected size of file is"+expectedSize);
		
		byte[] actualValue=given().when().get("https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz")
		.then().extract().asByteArray();
		
		System.out.println("size of actual value"+actualValue.length+"bytes");
		
		assertThat(expectedSize,equalTo(actualValue));
		
	}
}
