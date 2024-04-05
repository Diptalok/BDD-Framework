#Author: Diptalok
Feature: Create new contact

Scenario: Create a new Contact in Contact section after logging in successfully

Given I want to launch the browser
And Load the URl
When Log in page is displayed enter the username and password and click on the log in button
Then Validate for Homepage
When Homepage is visible click on contact link
Then validate contact page is visible
When contact page is visible click on Add contact picture
Then validate create new contact page is visible
When new contact page is visible fill up the mandatory fields in create contact page and save it
Then validate a new contact is created
When going backward twice contact page is visible
Then click on delete contact
When alert asking for confirmation
Then accept the alert
And take a screenshot for validation
When homepage is displayed move to adminstrator
And Click on sign out
Then validate for signout
And close the browser