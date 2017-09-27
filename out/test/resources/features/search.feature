Feature: Inorder to place an order
  as a user I want to search for products

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @pageobject
  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he searches for a product from the drop-down menu
    Then I the result for the drop down menu displayed

  @ui @pageobject
  Scenario: Should be able to search for a product from the icons
    Given John is viewing the Etsy landing page
    When he searches for a product from category icon
    Then I the result for the category displayed

  @ui @pageobject
  Scenario Outline: Should be able to search suggestions
    Given John is viewing the Etsy landing page
    When he enter "<searchText>" in search box
    Then he sees search suggestions contains "<searchText>"
    Examples:
      | searchText |
      | backpack      |







