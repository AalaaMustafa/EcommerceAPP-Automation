Feature: F04_Search | users will be able to search for products with different parameters


  Scenario: User Could Search Using Product Name
    Given user click on search bar
    When user search for product like "Nokia"
    And user click on search Button
    Then user could search successfully and go to search page


  Scenario: User Search Using SKU
    Given   user click on search bar
    When    user search for product like "AP_MBP_13"
    And     user click on search Button
    Then    user could search successfully with SKU


  Scenario: user search using invalid product name
    Given   user click on search bar
    When    user search for product like "Xiaomi"
    And     user click on search Button
    Then    user could not search