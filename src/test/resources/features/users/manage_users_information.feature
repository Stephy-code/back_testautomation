Feature: Manage users information

  As a platform administrator
  I want to manage the users information
  To check, created and update the users data


  @regression
  Scenario: Successful search for users information
    When platform administrator tries to get the users information
    Then the platform administrator should see all data for users

  @regression
  Scenario: Successful creation of new user
    When platform administrator tries to create new user
    Then the platform administrator should see that the user has been created