@SmokeTesting
Feature: User could select different categories and sub-category

  Background: User navigates to demo.nopcommerce website

  Scenario: Select random category then hover and open sub-Category

    Given Hover the header menu and select random category then hover it
    When Click on random sub-category

    Then User could open sub-category page