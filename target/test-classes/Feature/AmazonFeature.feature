@smoke
Feature: User is selecting the new releases and going through affiliate market link

  Scenario: User is accessing the new releases from the hamburger icon
    Given user clicks the hamburger icon
    And user chooses the option of new sellers
    When user selectes top item in the hot releases category of clothing and accessories
    Then user add selected products in the cart
    But user should not be on the same product page after adding product to cart

  Scenario: user is seeing the option of affiliate marketing
    Given user is on the home page
    When user scroll down to footer of the page
    And clicks on the become an affiliate link present in the Make money with us column
    Then user clicks on the sign up button
    But user should not be on the signin page
