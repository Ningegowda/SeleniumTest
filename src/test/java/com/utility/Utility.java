package com.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class Utility {

	public static JSONObject getResponse(String endUrl) {
		RestAssured.baseURI = "https://gist.githubusercontent.com/kumarpani";
		Response response = given().contentType(ContentType.JSON).when().get(endUrl).then().extract().response();
		Assert.assertEquals(response.statusCode(), 200);
		;
		JSONObject playerListResponseJson = new JSONObject(response.asString());
		return playerListResponseJson;
	}
}
