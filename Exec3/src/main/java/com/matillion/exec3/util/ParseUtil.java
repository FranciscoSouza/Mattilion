package com.matillion.exec3.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseUtil {

	public String parseDistance(String response) {
		JSONParser parser = new JSONParser();
		String distance ="";
		try {

			Object obj = parser.parse(response);
			JSONObject jsonobj = (JSONObject) obj;

			JSONArray dist = (JSONArray) jsonobj.get("rows");
			JSONObject obj2 = (JSONObject) dist.get(0);
			JSONArray disting = (JSONArray) obj2.get("elements");
			JSONObject obj3 = (JSONObject) disting.get(0);
			JSONObject obj4 = (JSONObject) obj3.get("distance");
			JSONObject obj5 = (JSONObject) obj3.get("duration");
			//System.out.println(obj4.get("text"));
			distance = (String) obj5.get("text");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return distance;
	}

}
