package com.hyperstudio.karaoke.api.utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 * Json 을 처리해주는 도구
 * @author Hyper4j
 *
 */
public class JsonAPI {
	
	/**
	 * Json 형태의 String 을, JSONArray 로 변환.
	 * @param arguments : Json String
	 * @return
	 */
	public static JSONArray parse(String arguments) {
		
		JSONParser parser = new JSONParser();
	    JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(arguments);
			return jsonArray;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * jsonObject 안에, arguments 키로, 값을 가져온다.
	 * @param jsonObject
	 * @param arguments
	 * @return
	 */
	public static String GET(JSONObject jsonObject, String arguments) {
		return (String) jsonObject.get(arguments);
	}

}
