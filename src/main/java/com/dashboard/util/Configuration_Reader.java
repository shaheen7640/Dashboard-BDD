package com.dashboard.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {
	
	/**
	 * @author Shaheen Akhtar
	 *This class is responsible to read the config.properties file.
	 */
	private Properties property;
	public Properties init_Property() {
		
		property = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\"
					+ "com\\DashboardBDD\\config\\config.properties");
			property.load(fileInputStream);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Properties file is missing");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Unable to load/read config.properties");
		}
		
		
		return property;
	}

}
