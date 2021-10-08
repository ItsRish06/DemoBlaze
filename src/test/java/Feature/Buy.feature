@buy
Feature: DemoBlaze Buy Function


  Scenario: Test Buy PopUp Window
    Given b-User is into cart
    When b-User clicks PlaceOrder
    Then b-User Gets Popup For Details

  Scenario Outline: Test online Payment Function
    Given b-User is on cart and Clicks PlaceOrder
    When b-User Enters <name> <country> <city> <creditCard> <month> <year>
    And b-User Clicks Purchase
    Then b-Validate successful purchase
    Examples:
      |name|country|city|creditCard|month|year|
      |Rishab|India|Mumbai|123456789|April|22|
      |Alex|USA|New York|123456789|January|24|


  Scenario Outline: Test Buy Function with invalid data
    Given b-User is on cart and Clicks PlaceOrder
    When b-User Enters <name> <country> <city> <creditCard> <month> <year>
    And b-User Clicks Purchase
    Then b-validate unsuccessful purchase
    Examples:
      |name|country|city|creditCard|month|year|
      |1234|India|Mumbai|123456789|April|22|
      |Rishab|Mumbai|Mumbai|123456789|April|22|
      |Rishab|India|Maharashtra|123456789|April|22|
      |Rishab|India|Mumbai|asdf|April|22|
      |Rishab|India|Mumbai|123456789|Monday|22|
      |Rishab|India|Mumbai|123456789|April|-122|
