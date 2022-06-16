@SmokeTesting
Feature: User could search for any product

  Background: User navigates to demo.nopcommerce website

  Scenario: User search for desired products with product name

    When User Search For Apple Products in the Search field

    Then User could find Apple products

  Scenario: User search for desired products with SKU

    When User Search For Products With Sku in the Search field
    Then Product With the Same Sku is Displayed
