package com.rs.test.tests;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)


@CucumberOptions(monochrome = true, features = "src/test/resources/features",glue = { "com.rs.test" },
plugin = {"pretty", "json:target/cucumber-reports/cucumber.json" }, tags = {"@Test13"})

public class AllTest {
	public static String dryRun = "False";
	@AfterClass
	static public void afterClass() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				CucumberResultsOverview results = new CucumberResultsOverview();
				results.setOutputDirectory("target/cucumber-html-reports");
				results.setOutputName("cucumber-reports");
				results.setSourceFile("./target/cucumber-reports/cucumber.json");

				try {
					results.executeFeaturesOverviewReport();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
