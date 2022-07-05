Feature: F02_Login | user should be able to login to the system


  Scenario: User Login with Valid Data
    When    user navigate to login page
    And     user enter "oshenoshaa9@gmail.com" and "Password123"
    Then    user click on login button
    And     user could login successfully and go to home page


  Scenario: User Login With Invalid Data
    When    user navigate to login page
    And     user enter "oshenoshaa9@gmail.com" and "Password"
    Then    user click on login button
    And     user could not login successfully and go to home page