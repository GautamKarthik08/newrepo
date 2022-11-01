package com.rs.test.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class CucumberInjectorSource implements InjectorSource {
	public Injector getInjector() {
		return Guice.createInjector(CucumberModules.SCENARIO, new GuiceModule());
	}
}