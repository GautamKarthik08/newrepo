package com.rs.test.config;

public class Constants {

	public static final String USER_DIR = System.getProperty("user.dir", ".");

	public static final String CONFIG_FILE = USER_DIR + "/config/config.yml";

	public static final String CONFIG = System.getProperty("config", "default");

	public static final String LOCATOR_PATH = USER_DIR + "/config/locator/";
	
	public static final String CHROME_KILL_FILE = USER_DIR + "\\bin\\chromekill.lnk";

}
