package com.aws.greet.utils;

import com.google.gson.Gson;

public class ApplicationUtils {

	
	/**
	 * Creating JSONP format based on response
	 * @param callbackFunc
	 * @param jsonObject
	 * @return
	 */
	public static String createJsonFormat(Object jsonObject) {
		String jsonPStr = "";
		Gson gson = new Gson();
		jsonPStr = gson.toJson(jsonObject);
		return jsonPStr;
	}


}
