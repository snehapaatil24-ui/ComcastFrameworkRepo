package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
	FileInputStream fis= new FileInputStream("./configAppData/commandata.properties");
	Properties pObj= new Properties();
	pObj.load(fis);
	String data=pObj.getProperty(key);
	return data;
		
	}

}
