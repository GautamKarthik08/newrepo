package com.rs.test.context;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cucumber.api.Scenario;

import cucumber.runtime.java.guice.ScenarioScope;

public class Context {

	private static Scenario scenario;
	private String tagId;
	private String status;


	public static Connection connectionSQLDB = null;
	private static String parentRequestId; 
	private static String childStartTime;

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getParentRequestId() {
		return parentRequestId;
	}

	public Connection getSQLDBConnection() {
		return connectionSQLDB;
	}

	public String getChildStartTime() {
		return childStartTime;
	}	

}