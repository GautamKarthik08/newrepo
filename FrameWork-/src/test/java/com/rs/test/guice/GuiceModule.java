package com.rs.test.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.rs.test.config.Configuration;
import com.rs.test.webdriver.Locator;
import cucumber.api.guice.CucumberScopes;




public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		try {
			bind(Configuration.class).in(Scopes.SINGLETON);
			bind(Locator.class).in(Scopes.SINGLETON);
			
			install(new WebDriverProviderModule()); 
		} catch (Exception e) {
			addError(e.getMessage());
		}
	}

}
