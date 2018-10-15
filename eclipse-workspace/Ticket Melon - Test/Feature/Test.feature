Feature: Test select where I want to go and when return
	Background:
		Given User open browser
		Then Navigate to Stackexchange

Scenario: Verify successful login
	And Click on Login
	And Select to log in with stackexchange 
	And input username and password
	Then Show Result of login
Scenario: Verify search
	And Fill in "automate test"
	And Check all subject at first page

	
	
	
	