@regression
Feature: implementation of login functionality and searching for product

  Scenario Outline: Login in the Amazon account using valid credentials
    Given User is on the login page
    When user enters the "<username>" and "<password>"
    Then user is navigated to login page
    But user should not see the signin page again

    Examples: 
      | username                    | password |
      | kartikeysharma804@gmail.com | test@12  |
      | kartikeysharma804@gmail.com | test@123 |

  Scenario Outline: Searching for product
    Given user enters the "<product>" in the search bar
    When user selectes the first item
    And user add the product in the cart
    Then cart page is shown
    But user should not be on the cart page

    Examples: 
      | product |
      | laptop  |
      | phone   |
