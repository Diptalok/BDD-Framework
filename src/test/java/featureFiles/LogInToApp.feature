#Author diptalok
Feature: Login to Vtiger Application

Scenario: Log in to Application with valid credentials
Given I want to launch the browser
And Load the URl
When Log in page is displayed enter the username and password
And click on the log in button
Then Validate for Homepage
When homepage is displayed move to adminstrator
And Click on sign out
Then validate for signout
And close the browser
