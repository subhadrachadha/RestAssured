package com.filedownload.example;

import java.io.File;
import static io.restassured.RestAssured.given;

public class FiledownLoad1 {

	public static void main(String[] args) {
		File inputFile=new File(System.getProperty("user.dir")+"//src//test//resources//"+"geckodriver-v0.11.1-arm7hf.tar.gz");
		int expectedSize=(int)inputFile.length();
		byte[] actualByteArray=given().when().get("https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz")
		.then().extract().asByteArray();
		System.out.println(actualByteArray.toString());
	}
}
