# FrameWork

Key Drivers of BDD
Steps to be followed to write a cucumber BDD script

Runner Class
Runner class acts as Automation Runner/Driver script and it will trigger the automation suite for individual or group test. Runner class use the JUnit annotation @RunWith(), which tells JUnit what is the test runner class. It more like a starting point for JUnit to start executing your tests.


Feature Files
Feature files are written in plain text format. Feature files are essential part of cucumber which serves automation test script for execution. The feature file is written in Gherkin language with gherkin keywords. Feature file is saved with ".feature" extension.

Gherkin Keywords:

Feature: Defines what feature you will be testing
Scenario: Defines what scenario you will be testing
Scenario Outline: Same scenario can be executed for multiple sets of data using scenario outline. The data is provided by a tabular structure separated by (I I).
Given: Describes the Pre-condition to be carried out
When: describes the actions to be performed
Then: Describes the conditions to be validated i.e., expected result of the test
And: Describes the Conditions to be incorporated with When/Then step
But: Describes the Conditions excluded with When/Then step
Background: Describes a Common step to be included for all Test scenarios.


Tag
To run a specific set of tests cucumber uses tags as @CucumberOptions. Multiple tags can be given by using comma separate. Cucumber by default runs all scenarios in all the feature files but in real world scenarios all the features are not necessary to run for instance. Tags are a way to group Scenarios. They are @-prefixed strings and you can place as many tags for a Scenario as you like Cucumber runs only those tag mentioned in feature files. Cucumber can perform different operations before and after each scenario based on what tags are present on a scenario or Feature.

Types of Tags:

Scenario Tags

Feature Tags

Step Definition Class
Step Definition is a java method in a class with an annotation in it. Cucumber finds the Step Definition file with the help of Glue code written in Test runner class. The pattern is used to link the step definition to all the matching steps, and the code is what Cucumber will execute when it sees a Gherkin Step. Step Definition class contains all the implementation of the Steps.



com.mns.applicationname.config
It is used to store all the configuration and constants which is used across the framework.

Configuration file: The configuration details are stored in an yml file. This functions stores the configuration details into a list which is present in the yml file. We can define which configuration file need to refer when running the test scripts for the particular environment.

Constants File: It stores the constants which can be used across the framework.

com.mns.applicationname.context
It is used to set and get the values which can be used for the scenario.

com.mns.applicationname.dao
This class is used to read the data from JSON file.


com.mns.applicationname.exception
This class contains the user defined exception for easier understanding of failure.

Ex. Config Exception, Data Exception

com.mns.applicationname.file
This package contains Read and Write CSV file.

com.mns.applicationname.guice
This class is used to initiate guice injection with cucumber scenario and helps in binding configuration with cucumber scenario. Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection in java to move the dependency resolution from compile-time to run time.

com.mns.applicationname.hooks
This class contains Before and After cucumber hooks.

@before hook gets executed before executing test scenario

@after hook gets executed after executing the scenario.

com.mns.applicationname.pages
The page object java class are stored based on the pages in the application. It contains the functions for each pages. PageObject class contains Selenium webdriver commands and functions for reusable.

com.mns.applicationname.stepdefs
It contains the step definitions (which is created by running the feature file) related to Web application. These are created from the feature file.

com.mns.applicationname.tests
Test Runner class file is defined under this package and it acts as the Driver script. It is the main runner class which drives all the features designed for Selenium. It is implemented with cucumber tags through which we can run the desired test features

com.mns.applicationname.utils
It contains the utilities like database connectivity, date util, Random item selection etc... Which can be used across the framework

com.mns.applicationname.webdriver
It contains the flow on how to find the selenium locator elements from locators.yaml file and setting the web driver timeout value. This file reads only ID, Name, CSS and Xpath locators. If want to read other locators, then need to define that locators here.

src/test/ resources /features
The input files / Feature files are created under this folder.

/bin
bin folder created under that all the required browser .exe files will be maintained, all the web drivers are maintained here ,Browser(chrome) kill short cut link is available.

Note: Replace selenium browser drivers based on browser version installed in machine.

/config
Configuration related details (Locators, ST, SIT Test data) will be maintained as .yaml file.

/files
Parents request ID notepad is available through which we can get the request ID for a particular run.

/lib
Add the dependency jars here which does not available in Maven Repository.

pom.xml
Contains the required Dependencies (Both Maven Repository jars and lib folder jars) and Plugins

How to use framework
Make sure you replace all applicationname word with respective application name
Example: com.mns.plm.config

To modify any dependency jar version, update it under dependencies tag in pom.xml

To add any jar dependency which is available in maven repository, add it under dependencies tag in pom.xml

To add any jar dependency which is not available in maven repository, keep the jar under lib folder and add it under dependencies tag in pom.xml using scope and systemPath

Make sure you keep selenium browser driver version under bin folder based on browser version installed in machine

Write Feature files under features folder

Keep same name for Step definition and page files which corresponding to one feature for easy code maintenance

Example:

Sample.feature

Samplestepdefs.java

SamplePage.java

In this framework there is no need of creating object to access variables and methods of another class. This one is achieved via Google juice dependency injection using Constructor. Refer Samplestepdefs.java and SamplePage.java files for more details

Keep selenium locator elements value in .yml file under locator

This framework is constructed default to read ID, Name, CSS and Xpath locators. If you want to read other locators, then need to define that locators under Locator.java file

Keep environment specific values separately (config_ST.yml, config_SIT.yml) in yml file under config folder

To read which environment specific config yml file while running the scenarios in locally, update it in Configuration.java file

To update timeout value for the locator element, modify DEFAULT_TIME_OUT_IN_SECONDS variable value under Synchronizer.java file.

Refer ActionsNew.java for default methods available for finding the element and elements with (This timeout value is applicable only for the particular element) or without passing timeout value

Customized HTML status report is integrated with this framework. Please update it with your respective project details under email package when using it

For customized status report, store parent request ID, scenario name, pass/fail in separate database and use it in Before and After hooks. In this framework, added sample report database in Before and After hooks. If does not required while running, then comment it and uncomment and update database details when needed
