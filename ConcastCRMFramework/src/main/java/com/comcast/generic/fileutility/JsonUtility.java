package com.comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable, ParseException{
		FileReader fileR= new FileReader("./configAppData/app.commandata.json");
		JSONParser parser= new JSONParser();
		 Object obj = parser.parse(fileR);
		 JSONObject map= (JSONObject)obj;
		 String data=(String) map.get(key);
		return data;
		
	}

}
