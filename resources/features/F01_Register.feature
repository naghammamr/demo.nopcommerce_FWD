@smoke
Feature: User could register a new account

  #Scenario-1
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter email "test@example.com" field and fills Password fields "P@ssw0rd" and "P@ssw0rd"
    And user clicks on register button
    Then success message is displayed