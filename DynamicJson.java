package com.cognizant.skillup;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import files.Payload;

public class DynamicJson {
	public static void main(String args[])
	{
		
			RestAssured.baseURI="http://216.10.245.166";
			String str=given().header("Content-Type","application/json")
			.body(Payload.Addbook())
			.when().post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
			JsonPath js=new JsonPath(str);
			String id=js.get("id");
			System.out.println(id);
			
	}
	
}
