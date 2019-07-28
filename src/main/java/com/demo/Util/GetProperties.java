package com.demo.Util;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import com.demo.Actions.initilizeProp;

public class GetProperties {
 
	public String getProperties(String key) {
		initilizeProp initilize = new initilizeProp();
		Properties prop = new Properties();
		String value = null;
		try {
			String path = System.getProperty("user.dir")+"\\src\\main\\resources\\Env\\"+initilize.getEnvName()+".properties";
			System.out.println(path);			
			File f = new File(path);
			FileReader reader=new FileReader(f);		    
			prop.load(reader);
			System.out.println(prop.getProperty(key));
			value = prop.getProperty(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
}
