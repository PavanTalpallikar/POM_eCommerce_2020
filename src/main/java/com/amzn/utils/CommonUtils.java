package com.amzn.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonUtils {

	static Properties prop;

	public static Properties loadProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_LOCATION);
			prop.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	
	public static String getProperty(String propertyName) {
		return loadProperties().getProperty(propertyName);
	}

}
