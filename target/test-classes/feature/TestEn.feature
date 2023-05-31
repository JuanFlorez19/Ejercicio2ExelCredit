#Language: En
Feature: Automation Test in SwagLabs

  Background: 
    Given a user in the page saucedemo

  @Login
  Scenario Outline: Validate login with user and password correct
    When enter a correct user <User>
    And enter a correct password <Password>
    And press the login button
    Then allows the entry to the system

    Examples: 
      | User            | Password       |
      | "standard_user" | "secret_sauce" |

  @Buy_Product
  Scenario Outline: Buy product in the page saucedemo
    When enter a correct user <User>
    And enter a correct password <Password>
    And press the login button
    And select a item required <Item>
    And complete the form with the information <Name><LastName><ZipCode>
    And validate product description and total price of the <Item>
    Then finish with the order displaying the following message "Thank you for your order!"

    Examples: 
      | User            | Password       | Item                  | Name      | LastName  | ZipCode  |
      | "standard_user" | "secret_sauce" | "Sauce Labs Onesie"   | "Juan"    | "Florez"  | "151651" |
