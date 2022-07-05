Feature: F07_FollowUs | users could open followUs links

  Background: User Login First
    When      user navigate to login page
    And       user enter "oshenoshaa9@gmail.com" and "Password123"
    Then      user click on login button
    And       user could login successfully and go to home page


  Scenario: User Opens Facebook Link
    When    user opens facebook link
    Then    "https://www.facebook.com/nopCommerce" is opened in new tab


  Scenario: User Opens Twitter Link
    When    user opens twitter link
    Then    "https://twitter.com/nopCommerce" is opened in new tab


  Scenario: User Opens rss Link
    When    user opens rss link
    Then    "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab


  Scenario: User Opens Youtube Link
    When    user opens youtube link
    Then    "https://www.youtube.com/user/nopCommerce" is opened in new tab