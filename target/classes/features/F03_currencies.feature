@SmokeTesting
Feature: User could switch between currencies [US-Euro]

  Background: User navigates to demo.nopcommerce website

  Scenario: User switch between US and Euro

    When User Select “Euro” from currency dropdown list
    Then  user check if action done successfully