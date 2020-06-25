package com.restassured.examples.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;


public class JsoupExample1 {
	public static SessionFilter filter;
	
	@BeforeClass
	public static void init()
	{
		filter=new SessionFilter();
		RestAssured.baseURI="http://localhost:9090";
		RestAssured.given().auth().form("user","user",new FormAuthConfig("/login","uname","pwd"))
		.filter(filter)
		.post().then();
		System.err.print(filter.getSessionId());
	}

	@Test
	public void extractTitle()
	{
		
		String response=RestAssured.given().sessionId(filter.getSessionId()).when().get("/student/list").asString();
		Document document=Jsoup.parse(response);
		Elements emailId=document.select("table tbody tr td:nth-child(4)");
		System.out.println(document);
		System.out.println("the size of table"+emailId.size());
		for(Element email:emailId)
		{
			System.out.println(email.text());
		}
	}
}
