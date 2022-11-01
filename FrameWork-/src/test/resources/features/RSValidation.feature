Feature:  validation

  	     @Test13
	   Scenario Outline:  Validate the online new flow 
	Given a customer I go to "dailymail"
	And I validate date and time
	Then I navigate to sports menu
	And I validate menu colour
	Then I click on Football
	And I click on first article
	And I open the galary
	Then I click on left and right
	And I click on fb share
	Then I click on video max
	Then I get the standing of "<Team>"
	
	
Examples:
		 |Team|
	   |Liverpool| 
	   

	