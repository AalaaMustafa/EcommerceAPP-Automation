Feature: F03_ChangeCurrency | user could switch between currencies [$, €]


  Scenario: Guest User Can Choose € Currency
    When    user select “Euro” from currency dropdown list
    Then    All $ sign change to € sign

