package com.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PlayerList {
	 private static final int totalPlayer = 11;
		Map<String, String> playerMap= new HashMap<String, String>();
		 @BeforeClass(alwaysRun = true)
		 public void createHeaderMap() {
				RestAssured.baseURI = "https://gist.github.com/kumarpani"; 
			 
		 }
		 @Test
		 public void Testcase1() {
		 RequestSpecification request = RestAssured.given(); 
			Response response = request.get("/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json"); 
			JSONObject playerJsonObj= new JSONObject(response.asString());
			int objlength=playerJsonObj.getJSONArray("player").length();
			int totalPlayer=11;
			int count=0;
			for(int i=0;i<=objlength-1;i++) {
				if(playerJsonObj.getJSONArray("player").getJSONObject(i).get("country").equals("India")){
					count++;
				}else {
					playerMap.put(playerJsonObj.getJSONArray("player").getJSONObject(i).get("name").toString(), playerJsonObj.getJSONArray("player").getJSONObject(i).get("country").toString());
				}
				
			}
			System.out.println(playerMap);
			Assert.assertTrue(totalPlayer-count==4,"Indian players are 7 out of 11 are" + count);
			return;
			}
		 @Test
		 public void Testcase2() {
		 RequestSpecification request = RestAssured.given(); 
			Response response = request.get("/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json"); 
			JSONObject playerJsonObj= new JSONObject(response.asString());
			int objlength=playerJsonObj.getJSONArray("player").length();
			int count=0;
			for(int i=0;i<=objlength-1;i++) {
				if(playerJsonObj.getJSONArray("player").getJSONObject(i).get("role").equals("Wicket-keeper")){
					count++;
				}else {
					playerMap.put(playerJsonObj.getJSONArray("player").getJSONObject(i).get("name").toString(), playerJsonObj.getJSONArray("player").getJSONObject(i).get("role").toString());
				}
			}
			System.out.println(playerMap);
			Assert.assertTrue(totalPlayer-count==11,"wicket keeper count should be " + " " + count);
			return;
			}
			
		}

