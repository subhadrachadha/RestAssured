package com.restassured.examples.jsoup;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public class JsoupExamples {
	public static SessionFilter filter;
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI = "http://localhost:8080";
		filter = new SessionFilter();
		RestAssured.given().auth().form("admin","admin",new FormAuthConfig("/login","uname","pwd"))
		.filter(filter).post().then();
		
	}
	
	
	@Test
	public void extractTitle()
	{
		String response=RestAssured.given().when().get("http://localhost:8080/").asString();
		
		//parse the html to a document object
		
		Document document=Jsoup.parse(response);
		System.out.println(document.title().toUpperCase());
	}
	
	@Test
	public void extractingElementsByTag()
	{
String response=RestAssured.given().when().get("http://localhost:8080/").asString();
		//parse the html to a document object
		Document document=Jsoup.parse(response);
		Elements element =document.getElementsByTag("form");
		System.out.println(element.size());
		for(Element e:element)
		{
			System.out.println(e);
		}
		
	}

	@Test
	public void extractingElementsByID()
	{
     String response=RestAssured.given().when().get("http://localhost:8080/").asString();
		//parse the html to a document object
		Document document=Jsoup.parse(response);
		Element element =document.getElementById("command");
		System.out.println(element.text());
		
		
	}
	
	@Test
	public void extractingAllLinks()
	{
     String response=RestAssured.given().when().get("http://localhost:8080/").asString();
		//parse the html to a document object
		Document document=Jsoup.parse(response);
		Elements links=document.select("a[href]");
		for(Element e:links)
		{
			System.out.println(e.text());
		}
		
		
	}
	
	@Test
	public void extractingEmailInformation()
	{
     String response=RestAssured.given().sessionId(filter.getSessionId()).when().get("/student/list").asString();
     Document document=Jsoup.parse(response);
     
     //System.out.println(document);
	
     Elements emailid=document.select("table tbody tr td:nth-child(4)");
     System.out.println(emailid.size());
     ArrayList<String> actValue=new ArrayList<String>();
     
     
     for(Element e:emailid)
     {
    	 System.out.println(e.text());
    	 actValue.add(e.text());
     }
     assertThat(actValue,hasItem("eu.tellus@anuncIn.edu"));
		
		
	}

}
