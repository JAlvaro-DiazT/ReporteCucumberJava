Feature: Login
  As a user
  I want to be able to log in to my account
  To access the website's features

  Scenario: Login with valid credentials
    Given The user is on the login page
    When The user enters their username "alvaro" and password "diaz"
    Then The user should see the Logout button
    And The user should see the Menu button