package com.test;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.Utility;

public class PlayerList {
	private static int totalPlayer = 0;
	String endUrl = "/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json";
	Map<String, String> playerMap = new HashMap<String, String>();

	@Test(description = "Write the test to validate to team have 4 foriegn players")
	public void TestVag_TC_001() {
		JSONObject playerJsonObj = Utility.getResponse(endUrl);
		totalPlayer = playerJsonObj.getJSONArray("player").length();
		int count = 0;
		for (int i = 0; i <= totalPlayer - 1; i++) {
			if (playerJsonObj.getJSONArray("player").getJSONObject(i).get("country").equals("India")) {
				count++;
			} else {
				playerMap.put(playerJsonObj.getJSONArray("player").getJSONObject(i).get("name").toString(),
						playerJsonObj.getJSONArray("player").getJSONObject(i).get("country").toString());
			}

		}
		Assert.assertTrue(totalPlayer - count == 4,
				"Indian players are 7 out of 11, then forgin players count is " + (totalPlayer - count));
		return;
	}

	@Test(description = "Write the test to validate to team have atleast one wicketkeeper")
	public void TestVag_TC_002() {
		
		JSONObject playerJsonObj = Utility.getResponse(endUrl);
		int totalPlayer = playerJsonObj.getJSONArray("player").length();
		int count = 0;
		for (int i = 0; i <= totalPlayer - 1; i++) {
			if (playerJsonObj.getJSONArray("player").getJSONObject(i).get("role").equals("Wicket-keeper")) {
				count++;
			} else {
				playerMap.put(playerJsonObj.getJSONArray("player").getJSONObject(i).get("name").toString(),
						playerJsonObj.getJSONArray("player").getJSONObject(i).get("role").toString());
			}
		}
		Assert.assertTrue(totalPlayer - count == 10, "wicket keeper count should be " + " " + count);
		return;
	}

}
