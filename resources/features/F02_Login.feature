@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Background:
    Given user go to login page

  #Valid
  Scenario: user could login with valid email and password
  When user login with "valid" email: "test11@example.com" and password: "P@ssw0rd"
  And user clicks on login button
  Then user is logged to the system successfully

  Scenario: user could login with invalid email and password
  When user login with "invalid" email: "wrong@example.com" and password: "P@ssw0rd"
  And user clicks on login button
  Then user could not login to the system