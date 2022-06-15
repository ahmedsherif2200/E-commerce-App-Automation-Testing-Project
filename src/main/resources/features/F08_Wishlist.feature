@SmokeTesting
Feature: User could add products to wishlist

  Background: User navigates to demo.nopcommerce website

  Scenario: User choose a product and click on Add to wishlist icon

    When user add product to wishlist
    Then after adding the product to wishlist  success message appeared

  Scenario:  number of wishlist items in home page is increased

    When user add product to wishlist
    Then after adding the product to wishlist  success message appeared

    And user get the of wishlist items after adding product
    Then number of wishlist items increased